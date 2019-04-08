package net.greet;

import java.util.Scanner;
import static net.greet.Greet.language;

public class Greeter {

    public static void main ( String args[] ) {

        System.out.println ( "--------Welcome to the Greetings App--------\n " );

        while ( true ) {

            Scanner in = new Scanner ( System.in );
            System.out.print ( "\nType command : ".toLowerCase ());
            String name = in.nextLine ( );
            String[] arr = name.split ( " " );

            if (arr[ 0 ].equalsIgnoreCase ( "greet".toLowerCase () ) && arr.length == 2) {
                String userName = arr[ 1 ];
                Greet.nameS ( userName );
                 language = "xhosa";
                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getGreet ( userName ) );

            } else if (arr.length == 3) {
                String userName = arr[ 1 ];
                Greet.nameS ( userName );
                language = arr[ 2 ];
                Language.valueOf ( language.toLowerCase ( ) );
                System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getGreet ( userName ) );
            }
            else if (arr[ 0 ].equalsIgnoreCase ( "clear".toLowerCase ()) && arr.length == 2) {
                String userName = arr[ 1 ];
                Greet.removeName ( userName );
            }
           else if (arr[ 0 ].equalsIgnoreCase ( "clearall".toLowerCase ()) && arr.length == 1) {
                Greet.clearNames ();
            }
           else if (arr[ 0 ].equalsIgnoreCase ( "greeted".toLowerCase () ) && arr.length==1) {
                Greet.namesGreeted ();
            }
            else if (arr[ 0 ].equalsIgnoreCase ( "greetcount".toLowerCase ()) && arr.length == 2) {
                String userName = arr[ 1 ];
                Greet.greetedName ( userName );
            }
            else if (arr[ 0 ].equalsIgnoreCase ( "counter".toLowerCase () ) && arr.length==1) {
                Greet.count ();
            }
            else if (arr[ 0 ].equalsIgnoreCase ( "help".toLowerCase () ) && arr.length==1) {
                Greet.help ();
            }
            else if (arr[ 0 ].equalsIgnoreCase ( "exit".toLowerCase () ) && arr.length==1) {
                Greet.exit ();

            }else{
               Greet.invalid();
            }
        }
    }
};


