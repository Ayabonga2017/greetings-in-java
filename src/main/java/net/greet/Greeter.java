package net.greet;

import java.sql.*;
import java.util.Scanner;

public class Greeter {

    public static void main ( String args[] ) throws SQLException {

        System.out.println ( "-----------------------------GREETINGS APP -----------------------------\n " );

        while ( true ) {

            Scanner input = new Scanner ( System.in );
            System.out.print ( "\nType in a command : ".toLowerCase ( ) );
            String name = input.nextLine ( );

            CommandExtractor commands = new CommandExtractor ( name );
            CommandExecutor execute = new CommandExecutor (commands);
            execute.mainMethod ();

        }
    }
}