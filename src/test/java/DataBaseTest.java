import net.greet.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DataBaseTest {

    final String DATABASE_URL = "jdbc:h2:./target/greet_java";

    @BeforeEach
    public void cleanUpTables ( ) {

        try {
            try ( Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" ) ) {
                // delete fruits that the tests are adding

                Statement statement = conn.createStatement ( );
                statement.addBatch ( "delete from people where name in ('yegan', 'aya','unalo')" );
                statement.executeBatch ( );

            }
        } catch ( Exception ex ) {
            System.out.println ( "These test will fail until the fruit table is created: " + ex );
        }
    }

    @Test
    public void loadJdbcDriver ( ) {

        try {

            Class.forName ( "org.h2.Driver" );
        } catch ( ClassNotFoundException e ) {
            fail ( e );
        }
    }

    @Test
    public void connectToDatabase ( ) {

        try {
            Class.forName ( "org.h2.Driver" );
            final String JDBC_URL = "jdbc:h2:./target/greet_java";
            Connection conn = DriverManager.getConnection ( JDBC_URL , "sa" , "" );

        } catch ( Exception e ) {
            fail ( e );
        }
    }

    @Test
    public void executeSQLStatement ( ) {

        try {
            Class.forName ( "org.h2.Driver" );
            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            Statement statement = conn.createStatement ( );
            ResultSet rs = statement.executeQuery ( "select * from people" );

        } catch ( Exception e ) {
            fail ( e );
        }
    }

    @Test
    public void greetFromDB ( ) {

        try {
            Class.forName ( "org.h2.Driver" );
            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            final String INSERT_PEOPLE_SQL = "insert into people (name, language) values (?, ?)";
            final String FIND_NAME_SQL = "select name, language from people where name = ?";

            // PreparedStatement are SQL statements that can be called
            // over and over with different parameters
            PreparedStatement addNameWithLang = conn.prepareStatement ( INSERT_PEOPLE_SQL );

            addNameWithLang.setString ( 1 , "aya" );
            addNameWithLang.setString ( 2 , Language.valueOf ( "french" ).getValue ( ) );
            addNameWithLang.execute ( );

            PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );

            ps.setString ( 1 , "aya" );
            ResultSet rs = ps.executeQuery ( );

            while ( rs.next ( ) ) {
                assertEquals ( "BONJOUR aya" , rs.getString ( "language" ) + rs.getString ( "name" ) );

                System.out.println ( rs.getString ( "language" ) + " " + rs.getString ( "name" ) );
            }
        } catch ( Exception e ) {
            fail ( e );
        }
    }
}
