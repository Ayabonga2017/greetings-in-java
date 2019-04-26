package net.greet;

import java.sql.*;
import java.util.Scanner;

public class Greeter {

    public static void main ( String args[] ) throws SQLException {

        System.out.println ( "-----------------------------GREETINGS APP -----------------------------\n " );

      //GreetWithHashMap greetMap = new GreetWithHashMap ();
        GreetWithDatabase greetMap = new GreetWithDatabase ();

        String userName;
        String language;

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType in a command : ".toLowerCase () );
            String name = input.nextLine ( );
            String[] arr = name.split ( " " );
            String command = arr[0];
            boolean lengthOne = arr.length == 1;


            if ( arr.length == 2 && command.equalsIgnoreCase ( "greet" )) {

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

            } else if (arr.length == 2 && command.equalsIgnoreCase ( "clear") ) {

                userName = arr[ 1 ];
                greetMap.removeName ( userName );

            }else if (lengthOne && command.equalsIgnoreCase ( "clearall" ) ) {

                greetMap.clearNames ( );

            }else if (lengthOne && command.equalsIgnoreCase ( "greeted" ) ) {

                greetMap.namesGreeted ( );

            }else if (arr.length == 2 && command.equalsIgnoreCase ( "count") ) {

                userName = arr[ 1 ];
                greetMap.countName(userName);

            }else if (lengthOne && command.equalsIgnoreCase ( "counter" )) {

                System.out.println (  "\nNumber of greeted users :\n" +"\n"+greetMap.count ( ));

            }else if (lengthOne && command.equalsIgnoreCase ( "help" ) ) {

                greetMap.help ( );

            }else if (lengthOne&& command.equalsIgnoreCase ( "exit" )  ) {

                greetMap.exit ( );

            }else {

                greetMap.invalid ( );
            }
        }
    }
}