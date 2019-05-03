package net.greet;


public class CommandExtractor {

    String user;
    String language;
    String command;
    String[] arr;
    boolean lengthOne;



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
    public String getCommand(){

        return command;
    }


}