package net.greet;
import java.util.Scanner;

public class Greeter {

    public static void main (String args[]) {

        while ( true ) {
            System.out.println ( "--------Welcome to the Greetings App--------\n " );

            Scanner in = new Scanner ( System.in );
            System.out.print ( "Enter command : " );
            String name = in.nextLine ( );

            String[] arr = name.split ( " " );

            if ( arr[0].equals ( "greet" ) ) {
                System.out.println ( arr.length );

                if ( arr.length == 2 ) {
                    String userName = arr[1];

                    System.out.println ( "Hello, " + userName );
                    Greet.nameS ( userName );

                } else if ( arr.length == 3 ) {
                    String userName = arr[1];
                    String language = arr[2];

                    Greet.nameS ( userName );
                    Language.valueOf ( language.toLowerCase () );
                    System.out.println ( language + userName );


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
