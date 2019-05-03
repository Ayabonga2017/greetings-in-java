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
            CommandExecutor exercute = new CommandExecutor (name);
            CommandExtractor commands = new CommandExtractor ( name );
            commands.getCommand ();

        }
    }
}