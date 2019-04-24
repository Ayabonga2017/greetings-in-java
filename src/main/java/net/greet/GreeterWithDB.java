package net.greet;

import java.sql.*;
import java.util.Scanner;

public class GreeterWithDB {

    public static void main ( String args[] ) throws SQLException {

        System.out.println ( "-----------------------------GREETINGS APP -----------------------------\n " );

      GreetWithHashMap greetMap = new GreetWithHashMap ();
        //GreetWithDatabase greetMap = new GreetWithDatabase ();

        String userName;
        String language;

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType in a command : ".toLowerCase () );
            String name = input.nextLine ( );
            String[] arr = name.split ( " " );

            if ( arr[ 0 ].equalsIgnoreCase ( "greet".toLowerCase ( ) ) && arr.length == 2 ) {

                userName =arr[1];
                greetMap.names ( userName );
                language = "xhosa";

                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ));
                greetMap.namesWithDefault ( userName );

            }else if ( arr.length == 3 ) {

                userName =arr[ 1 ];
                language =arr[ 2 ];

                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ));
                greetMap.namesWithLang (userName,language );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "clear".toLowerCase ( ) ) && arr.length == 2 ) {

                userName = arr[ 1 ];
                greetMap.removeName ( userName );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "clearall" ) && arr.length == 1 ) {

                greetMap.clearNames ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "greeted".toLowerCase ( ) ) && arr.length == 1 ) {

                greetMap.namesGreeted ( );

            }else if ( arr[ 0 ].equalsIgnoreCase ( "count".toLowerCase ( ) ) && arr.length == 2 ) {

                userName = arr[ 1 ];
                greetMap.countName(userName);

            }else if ( arr[ 0 ].equalsIgnoreCase ( "counter".toLowerCase ( ) ) && arr.length == 1 ) {

                System.out.println (  "\nNumber of greeted users :\n" +"\n"+greetMap.count ( ));

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