
import net.greet.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DataBaseTest {

    final String DATABASE_URL = "jdbc:h2:./target/greet_java_test";

    @BeforeEach
    public void cleanUpTables () {

        try {
            try ( Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" ) ) {
                // delete NAMES that the tests are adding

                Statement statement = conn.createStatement ( );
                statement.addBatch ( "delete from people where name in ('THABANG','AYABONGA','UNALO','YEGAN','NTANDO')" );
                statement.executeBatch ( );

            }
        } catch ( Exception ex ) {
            System.out.println ( "These test will fail until the peopleTest table is created: " + ex );
        }
    }
    @Test
    public void loadJdbcDriver () {

        try {

            Class.forName ( "org.h2.Driver" );
        } catch ( ClassNotFoundException e ) {
            fail ( e );
        }
    }
    @Test
    public void connectToDatabase () {

        try {
            Class.forName ( "org.h2.Driver" );
            final String JDBC_URL = "jdbc:h2:./target/greet_java_test";
            Connection conn = DriverManager.getConnection ( JDBC_URL , "sa" , "" );

        } catch ( Exception e ) {
            fail ( e );
        }
    }
    @Test
    public void executeSQLStatement () {

        try {
            Class.forName ( "org.h2.Driver" );
            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            Statement statement = conn.createStatement ();
            ResultSet rs = statement.executeQuery ( "select * from people" );

        } catch ( Exception e ) {
            fail ( e );
        }
    }
    @Test
    public void greetFromDB () {

        try {
            Class.forName ( "org.h2.Driver" );
            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            final String INSERT_PEOPLE_SQL = "insert into people (name, counter) values (?, ?)";
            //  final String FIND_NAME_SQL = "select name, language from people where name = ?";

            // PreparedStatement are SQL statements that can be called
            // over and over with different parameters
            PreparedStatement addNameWithLang = conn.prepareStatement ( INSERT_PEOPLE_SQL );

            addNameWithLang.setString ( 1 , "THABANG" );
            addNameWithLang.setInt ( 2 , 1);
           // addNameWithLang.setInt ( 3 , 1 );
            addNameWithLang.execute ( );
            addNameWithLang.setString ( 1 , "AYABONGA" );
            addNameWithLang.setInt ( 2 , 1 );
           // addNameWithLang.setInt ( 3 , 2 );
            addNameWithLang.execute ( );
            addNameWithLang.setString ( 1 , "UNALO" );
            addNameWithLang.setInt ( 2 , 1 );
            addNameWithLang.execute ( );
            addNameWithLang.setString ( 1 , "YEGAN" );
            addNameWithLang.setInt ( 2 , 1 );
          //  addNameWithLang.setInt ( 3 , 3 );
            addNameWithLang.execute ( );
            addNameWithLang.setString ( 1 , "NTANDO" );
            addNameWithLang.setInt ( 2 , 1 );
        //    addNameWithLang.setInt ( 3 , 4 );
            addNameWithLang.execute ( );
            PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );

            ps.setString ( 1 , "NTANDO" );
            ResultSet rs = ps.executeQuery ( );

            while ( rs.next ( ) ) {
                assertEquals ( "OLÀ NTANDO" , Language.valueOf ( "portuguese" ).getValue ( ) + rs.getString ( "name" ) );

                System.out.println ( "\n" + Language.valueOf ( "portuguese" ).getValue ( ) + " " + rs.getString ( "name" ) );
            }
        } catch ( Exception e ) {
            fail ( e );
        }
    }
    @Test
    public void countNamesFromDB () {

        try {

            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            Statement statement = conn.createStatement ( );
            final String INSERT_PEOPLE_SQL = "insert into people (name, counter) values (?, ?)";

            // PreparedStatement are SQL statements that can be called
            // over and over with different parameters
            PreparedStatement addNameWithLang = conn.prepareStatement ( INSERT_PEOPLE_SQL );

            addNameWithLang.setString ( 1 , "THABANG" );
            addNameWithLang.setInt ( 2 , 1 );
            addNameWithLang.execute ( );

            addNameWithLang.setString ( 1 , "AYABONGA" );
            addNameWithLang.setInt ( 2 ,1 );
            addNameWithLang.execute ( );

            addNameWithLang.setString ( 1 , "UNALO" );
            addNameWithLang.setInt ( 2 , 1 );
            addNameWithLang.execute ( );

            addNameWithLang.setString ( 1 , "YEGAN" );
            addNameWithLang.setInt ( 2 , 1 );
            addNameWithLang.execute ( );

            addNameWithLang.setString ( 1 , "NTANDO" );
            addNameWithLang.setInt ( 2 , 1 );
            addNameWithLang.execute ( );

            ResultSet rs = statement.executeQuery ( "select count(*) as countNames from people" );
            if ( rs.next ( ) ) {
                assertEquals ( 6 , rs.getInt ( "countNames" ) );

                System.out.println ( "Should return the counter for names inserted in the table:\n" + rs.getInt ( "countNames" ) );
            }
        } catch ( Exception e ) {
            fail ( e );
        }
    }
    @Test
    public void clearNamesInserted () {

        try {
            try ( Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" ) ) {
                // delete NAMES that the tests are adding

                Statement statement = conn.createStatement ( );
                statement.addBatch ( "delete from people where name in ('AYA','MZWA','AYANDA','BRIAN')" );
                statement.executeBatch ( );

            }
        } catch ( Exception ex ) {
            System.out.println ( "These test will fail until the fruit table is created: " + ex );
        }
    }
    @Test
    public void clearName () {

        try {
            try ( Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" ) ) {
                // delete NAMES that the tests are adding

                Statement statement = conn.createStatement ( );
                statement.addBatch ( "delete from people where name in ('AYA')" );
                statement.executeBatch ( );

            }
        } catch ( Exception ex ) {
            System.out.println ( "These test will fail until the people table is created: " + ex );
        }
    }
    @Test
    public void greetedNames () {
        try {

            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            ResultSet rs;

            //    final String INSERT_PEOPLE_SQL = "insert into test (name, counter) values (?, ?)";

                // PreparedStatement are SQL statements that can be called
                // over and over with different parameters
//                PreparedStatement addNameWithLang = conn.prepareStatement ( INSERT_PEOPLE_SQL );
//
//                addNameWithLang.setString ( 1 , "THABANG" );
//                addNameWithLang.setInt ( 2 , 1 );
//                addNameWithLang.execute ( );
//
//                addNameWithLang.setString ( 1 , "AYABONGA" );
//                addNameWithLang.setInt ( 2 , 1 );
//                addNameWithLang.execute ( );

                PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );

                ps.setString ( 1 , "NTANDO" );
                rs = ps.executeQuery ( );

                if ( rs.next ( ) ) {
                   String names = rs.getString ( "name" );
                   System.out.println ( "Should display the names inside the table:\n" + names );
                   rs.close ();
            }
        } catch ( Exception e ) {
            fail ( e );
        }

    }
    @Test
    public void countFromDB () {
        try {

            Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
            Statement statement = conn.createStatement ( );
            ResultSet rs = statement.executeQuery ( "SELECT COUNT(*) AS rowcount FROM people" );

            if ( rs.next ( ) ) {
                int count = rs.getInt ( "rowcount" );
                System.out.println ( "Should display the names inside the table:\n" + count );

                rs.close ( );
            }

        } catch ( Exception e ) {
            fail ( e );
        }

    }
}