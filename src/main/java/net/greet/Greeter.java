package net.greet;

import java.sql.SQLException;
import java.util.Scanner;

public class Greeter {

    public static void main ( String args[] ) throws SQLException{

        System.out.println ( "--------Welcome to the Greetings App--------\n " );

        GreetWithHashMap greetMap = new GreetWithHashMap ();
        String language;

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType command : ".toLowerCase ( ) );
            String name = input.nextLine ( );
            String[] arr = name.split ( " " );

            if ( arr[ 0 ].equalsIgnoreCase ( "greet".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                greetMap.namesWithDefault ( userName );
                language = "xhosa";
                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );

            } else if ( arr.length == 3 ) {
                String userName = arr[ 1 ];
                language = arr[ 2 ];
                greetMap.namesWithLang ( language, userName );

                Language.valueOf ( language.toLowerCase ( ) );
                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "clear".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                greetMap.removeName ( userName.toUpperCase ( ) );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "clearall".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.clearNames ( );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "greeted".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.namesGreeted ( );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "count".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                greetMap.countName ( userName.toUpperCase ( ) );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "counter".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.count ( );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "help".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.help ( );
            } else if ( arr[ 0 ].equalsIgnoreCase ( "exit".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.exit ( );
            } else {
                greetMap.invalid ( );
            }
        }
    }
}


