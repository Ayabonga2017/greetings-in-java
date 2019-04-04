package net.greet;
import java.util.Scanner;

import static net.greet.Greet.language;

public class Greeter {

    public static void main (String args[]) {

        while ( true ) {
            System.out.println ( "--------Welcome to the Greetings App--------\n " );

            Scanner in = new Scanner ( System.in );
            System.out.print ( "Enter greet & name  : " );
            String name = in.nextLine ( );
            String[] arr = name.split ( " " );

            if ( arr[0].equals ( "greet" ) ) {
                //System.out.println ( arr.length );

                if ( arr.length == 2 ) {
                    String userName = arr[1];
                    Greet.nameS ( userName );

                } else if ( arr.length == 3 ) {

                    String userName = arr[1];
                    Greet.nameS ( userName );
                     language = arr[2];

                    Language.valueOf ( language.toLowerCase () );
                    System.out.println ( Language.valueOf ( language.toLowerCase () ).getGreet ( userName) );

                    } else {
                        System.out.println ( "Invalid command " );
                        break;
                    }
                }

                System.out.println ( arr[0] + " | " + arr[0] );
                Greet.namesGreeted ( );
            }
        }
    }
