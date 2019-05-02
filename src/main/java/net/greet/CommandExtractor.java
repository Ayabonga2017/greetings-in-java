package net.greet;

import java.sql.SQLException;

public class CommandExtractor {

    String user;
    String language;
    String command;
    String[] arr;
    boolean lengthOne;

    GreetWithDatabase greetMap = new GreetWithDatabase( );

    public CommandExtractor( String command ) {

        this.arr = command.split( " " );
        this.command = arr[ 0 ];
        this.lengthOne = arr.length == 1;
        this.language = "xhosa";
        if ( arr.length == 3 ) {
            this.user = arr[ 1 ];
            this.language = arr[ 2 ];

        }
    }

    public String getCommand( ) throws SQLException {


        if ( arr.length == 2 && command.equalsIgnoreCase( "greet" ) ) {

            greetMap.namesWithDefault( getUser () );
        } else if ( arr.length == 3 ) {

            greetMap.namesWithLang( getUser (), getLang () );

        } else if ( arr.length == 2 && command.equalsIgnoreCase( "clear" ) ) {
            greetMap.removeName(getUser ());
        } else if ( lengthOne && command.equalsIgnoreCase( "clearall" ) ) {

            greetMap.clearNames( );
        } else if ( lengthOne && command.equalsIgnoreCase( "greeted" ) ) {

            greetMap.namesGreeted( );
        } else if ( arr.length == 2 && command.equalsIgnoreCase( "count" ) ) {

            this.user = arr[ 1 ];
            greetMap.countName( user );
        } else if ( lengthOne && command.equalsIgnoreCase( "counter" ) ) {
            System.out.println( "\nNumber of greeted users :\n" + "\n" + greetMap.count( ) );

        } else if ( lengthOne && command.equalsIgnoreCase( "help" ) ) {

            greetMap.help( );
        } else if ( lengthOne && command.equalsIgnoreCase( "exit" ) ) {

            greetMap.exit( );
        } else {

            greetMap.invalid( );
        }
        return command;
    }

    public String getUser() {

        this.user = arr[ 1 ];
        if ( user == null ) {

            System.out.printf( "enter a user" );
            return "enter user to greet";
        } else {

           return user;
        }
    }

    public String getLang() {

        if ( this.language.isEmpty( ) ) {

            language = "xhosa";
//
            return Language.valueOf( "xhosa" ).getValue( );
        } else {

           return Language.valueOf( language.toLowerCase( ) ).getValue( ) ;
        }
    }

}