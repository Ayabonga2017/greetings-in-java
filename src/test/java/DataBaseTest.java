import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.fail;

public class DataBaseTest {

    final String DATABASE_URL = "jdbc:h2:./target/greet_java";

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
            System.out.println ( rs );

        } catch ( Exception e ) {
            fail ( e );
        }
    }
}
