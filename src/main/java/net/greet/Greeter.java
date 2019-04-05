package net.greet;

import java.util.Scanner;

import static net.greet.Greet.language;

public class Greeter {

    public static void main ( String args[] ) {

        System.out.println ( "--------Welcome to the Greetings App--------\n " );

        while ( true ) {

            Scanner in = new Scanner ( System.in );
            System.out.print ( "\nType command : " .toLowerCase ());
            String name = in.nextLine ( );
            String[] arr = name.split ( " " );

            if (arr[ 0 ].equals ( "greet".toLowerCase () ) && arr.length == 2) {
                String userName = arr[ 1 ];
                Greet.nameS ( userName );
                System.out.println ( "\n" + ( userName ) );

            } else if (arr.length == 3) {

                String userName = arr[ 1 ];
                Greet.nameS ( userName );
                language = arr[ 2 ];
                Language.valueOf ( language.toLowerCase ( ) );
                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getGreet ( userName ) );
            }

            else if (arr[ 0 ].equals ( "remove".toLowerCase ()) && arr.length == 2) {
                String userName = arr[ 1 ];
                Greet.removeName ( userName );

            }
           else if (arr[ 0 ].equals ( "clear".toLowerCase ()) && arr.length == 1) {
                Greet.clearNames ();
            }
           else if (arr[ 0 ].equals ( "greeted".toLowerCase () ) && arr.length==1) {
                Greet.namesGreeted ();
            }
            else if (arr[ 0 ].equals ( "greetcount") && arr.length == 2) {
                String userName = arr[ 1 ];
                Greet.greetedName ( userName );

            }
            else if (arr[ 0 ].equals ( "counter" ) && arr.length==1) {
                Greet.count ();
            }
            else if (arr[ 0 ].equals ( "help" ) && arr.length==1) {
                Greet.help ();

            }
            else if (arr[ 0 ].equals ( "exit" ) && arr.length==1) {
                Greet.exit ();

            }else{
                System.out.println ( "Invalid command , please try again" + "\ntype help to get the list of valid commands" );
            }
        }
    }
}


