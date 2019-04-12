package net.greet;

import java.sql.*;
import java.util.Scanner;

import static net.greet.Greet.language;

public class GreeterWIthDB {

    public static void main ( String args[] ) throws SQLException, ClassNotFoundException {

        System.out.println ( "--------Greetings App With DB--------\n " );

        final String DATABASE_URL = "jdbc:h2:./target/greet_java";
        Class.forName ( "org.h2.Driver" );
        Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
        final String INSERT_PEOPLE_SQL = "insert into people (name, language) values (?, ?)";
        PreparedStatement addToDB = conn.prepareStatement ( INSERT_PEOPLE_SQL );

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType command : ".toLowerCase ( ) );
            String name = input.nextLine ( );
            String[] arr = name.split ( " " );

            if ( arr[ 0 ].equalsIgnoreCase ( "greet".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                Greet.nameS ( userName );
                addToDB.setString ( 1 , userName );
                language = "xhosa";
                addToDB.setString ( 2 , Language.valueOf ( language ).getValue ( ) );
                addToDB.execute ( );

                PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );
                ps.setString ( 1 , userName );
                ResultSet rs = ps.executeQuery ( );
                while ( rs.next ( ) ) {
                    //   System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
                    System.out.println ( "\n" + rs.getString ( "language" ) + " " + rs.getString ( "name".toUpperCase ( ) ) );
                }

            }else if ( arr.length == 3 ) {

                String userName = arr[ 1 ];
                Greet.nameS ( userName );
                addToDB.setString ( 1 , userName );
                language = arr[ 2 ];
                addToDB.setString ( 2 , Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) );
                Language.valueOf ( language.toLowerCase ( ) );
                addToDB.execute ( );

                PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );
                ps.setString ( 1 , userName );
                ResultSet s = ps.executeQuery ( );
                s.next ( );

                //   System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
                System.out.println ( "\n" + s.getString ( "language" ) + " " + s.getString ( "name" ) );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "clear".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                Statement statement = conn.createStatement ( );
                statement.addBatch ( "delete from people where name = (arr[ 1 ])" );
                statement.executeBatch ( );
                Greet.removeName ( userName.toUpperCase ( ) );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "clearall" ) && arr.length == 1 ) {
                Statement statement = conn.createStatement ( );
                statement.addBatch ( "delete from people" );
                statement.executeBatch ( );
                Greet.clearNames ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "greeted".toLowerCase ( ) ) && arr.length == 1 ) {
                Greet.namesGreeted ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "greetcount".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                Greet.greetedName ( userName.toUpperCase ( ) );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "counter".toLowerCase ( ) ) && arr.length == 1 ) {
                Greet.count ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "countDB".toLowerCase ( ) ) && arr.length == 1 ) {
                Statement statement = conn.createStatement ( );

                ResultSet rs = statement.executeQuery ( "select count(*) from people" );

                System.out.println ( "Should return the counter for names inserted in the table:\n" + rs.getInt ( "countNames" ) );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "help".toLowerCase ( ) ) && arr.length == 1 ) {
                Greet.help ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "exit".toLowerCase ( ) ) && arr.length == 1 ) {
                Greet.exit ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "display".toLowerCase ( ) ) && arr.length == 1 ) {

                PreparedStatement ps = conn.prepareStatement ( "select name from people " );
                ResultSet rs = ps.executeQuery ( );
                while ( rs.next ( ) ) {
                    //   System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
                    System.out.println ( "\n" + rs.getString ( "name".toUpperCase ( ) ) );
                }
            }else {
                Greet.invalid ( );
            }
        }
    }
}