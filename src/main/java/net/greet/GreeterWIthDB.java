package net.greet;

import java.sql.*;
import java.util.Scanner;

public class GreeterWIthDB {

    public static void main ( String args[] ) throws SQLException, ClassNotFoundException {

        System.out.println ( "--------Greetings App With DB--------\n " );

        String language;

        //GreetWithHashMap greetMap = new GreetWithHashMap ();
        GreetWithDatabase greetMap = new GreetWithDatabase ();

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType command : ".toLowerCase ( ) );
            String name = input.nextLine ( );
            String[] arr = name.split ( " " );

            if ( arr[ 0 ].equalsIgnoreCase ( "greet".toLowerCase ( ) ) && arr.length == 2 ) {

                greetMap.namesWithDefault ( arr[ 1 ] );

            }else if ( arr.length == 3 ) {

                greetMap.namesWithLang (arr[ 2 ] ,arr[ 1 ]);


            }else if ( arr[ 0 ].equalsIgnoreCase ( "clear".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                greetMap.removeName ( userName.toUpperCase ( ) );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "clearall" ) && arr.length == 1 ) {
                greetMap.clearNames ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "greeted".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.namesGreeted ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "greetcount".toLowerCase ( ) ) && arr.length == 2 ) {
                String userName = arr[ 1 ];
                greetMap.greetedName ( userName.toUpperCase ( ) );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "counter".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.count ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "countDB".toLowerCase ( ) ) && arr.length == 1 ) {

            }else if ( arr[ 0 ].equalsIgnoreCase ( "help".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.help ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "exit".toLowerCase ( ) ) && arr.length == 1 ) {
                greetMap.exit ( );

            }else {
                greetMap.invalid ( );
            }
        }
    }
}