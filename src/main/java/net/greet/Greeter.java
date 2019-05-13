package net.greet;

import java.sql.*;
import java.util.Scanner;

public class Greeter {

    public static void main ( String args[] ) throws SQLException {

        System.out.println ( "-----------------------------GREETINGS APP -----------------------------\n " );

        Greet greet = new GreetWithDatabase();
        CommandExecutor executor = new CommandExecutor (greet);

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType in a command : ".toLowerCase ( ) );
            String name = input.nextLine ( );

            CommandExtractor extractor = new CommandExtractor ( name );

            String results =executor.execute (extractor);

            if ( results.equalsIgnoreCase("exit")){
                System.out.println("Good-bye");
                break;
            }else{
                System.out.println ( executor.execute (extractor));
            }
        }
    }
}