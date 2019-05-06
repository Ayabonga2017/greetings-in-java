package net.greet;
import java.sql.SQLException;

public class CommandExecutor {

     Greet greeter;
  //  GreetWithHashMap greetMap = new GreetWithHashMap ( );
//    CommandExtractor extractor;

    public CommandExecutor ( Greet greet ) {
        this.greeter = greet;
    }

    public String execute ( CommandExtractor extractor ) throws SQLException {

        if ( "greet".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.names( extractor.getUser( ) );
            return extractor.getGreet();

        } else if ( "clear".equalsIgnoreCase( extractor.getCommand( ) ) ) {
            greeter.removeName( extractor.getUser( ) );
        } else if ( "clearall".equalsIgnoreCase( extractor.getCommand( ) ) ) {
            return greeter.clearNames( );
        } else if ( "greeted".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.namesGreeted( );
        } else if ( "count".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.countName( extractor.getUser( ) );

        } else if ( "counter".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            System.out.println( "\nNumber of greeted users :\n" + "\n" + greeter.count( ) );

        } else if ( "help".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.help( );
        } else if ( "exit".equalsIgnoreCase( extractor.getCommand( ) ) ) {

            greeter.exit( );
        } else {

            greeter.invalid( );
        }
    }
}

