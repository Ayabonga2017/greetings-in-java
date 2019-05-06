package net.greet;
import java.sql.SQLException;

public class CommandExecutor {

     GreetWithDatabase greetMap = new GreetWithDatabase ( );
  //  GreetWithHashMap greetMap = new GreetWithHashMap ( );
    CommandExtractor extractor;

    public CommandExecutor ( CommandExtractor extractor ) {

        this.extractor = extractor;
    }



    public void mainMethod ( ) throws SQLException {

        if ( extractor.arr.length == 2 && extractor.command.equalsIgnoreCase ( "greet" ) ) {

            System.out.println ( "\n" + extractor.hasLanguage()+extractor.hasName() );
            greetMap.namesWithDefault ( extractor.getUser ( ) );

        } else if ( extractor.arr.length == 3 ) {

            System.out.println ( "\n" + extractor.hasLanguage() + extractor.hasName() );
            greetMap.namesWithLang ( extractor.getUser(), extractor.getLang() );

        } else if ( extractor.arr.length == 2 && extractor.command.equalsIgnoreCase ( "clear" ) ) {

            greetMap.removeName ( extractor.getUser() );
        } else if ( extractor.lengthOne && extractor.command.equalsIgnoreCase ( "clearall" ) ) {

            greetMap.clearNames ( );
        } else if ( extractor.lengthOne && extractor.command.equalsIgnoreCase ( "greeted" ) ) {

            greetMap.namesGreeted ( );
        } else if ( extractor.arr.length == 2 && extractor.command.equalsIgnoreCase ( "count" ) ) {

            greetMap.countName ( extractor.getUser() );
        } else if ( extractor.lengthOne && extractor.command.equalsIgnoreCase ( "counter" ) ) {
            System.out.println ( "\nNumber of greeted users :\n" + "\n" + greetMap.count ( ) );

        } else if ( extractor.lengthOne && extractor.command.equalsIgnoreCase ( "help" ) ) {

            greetMap.help ( );
        } else if ( extractor.lengthOne && extractor.command.equalsIgnoreCase ( "exit" ) ) {

            greetMap.exit ( );
        } else {

            greetMap.invalid ( );
        }
    }

}

