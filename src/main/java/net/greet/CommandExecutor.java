package net.greet;
import java.sql.SQLException;

public class CommandExecutor {

     Greet greeter;

    public CommandExecutor ( Greet greet ) {
        this.greeter = greet;
    }

    public String execute ( CommandExtractor extractor ) throws SQLException {

        if ( "greet".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.names( extractor.getUser( ) );
            System.out.printf (extractor.getGreet() );
            return extractor.getGreet();

        } else if ( "clear".equalsIgnoreCase( extractor.getCommand( ) ) ) {
           return greeter.removeName( extractor.getUser( ) );
        } else if ( "clearall".equalsIgnoreCase( extractor.getCommand( ) ) ) {
            return greeter.clearNames( );
        } else if ( "greeted".equalsIgnoreCase( extractor.getCommand( ) ) ) {
           return greeter.namesGreeted( );
        } else if ( "count".equalsIgnoreCase( extractor.getCommand( ) ) ) {
            System.out.println ("\n"+ extractor.getUser()+" was greeted "+ greeter.countName(extractor.getUser()) + " time(s)" );
           return String.valueOf( greeter.countName( extractor.getUser( ) ) );

        } else if ( "counter".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            System.out.println( "\nNumber of greeted users :\n" + "\n" + greeter.count( ) );
            return String.valueOf( greeter.count( ) );

        } else if ( "help".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.help( );
        } else if ( "exit".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.exit( );
        } else {

           return greeter.invalid( );
        }
        return "";
    }
}

