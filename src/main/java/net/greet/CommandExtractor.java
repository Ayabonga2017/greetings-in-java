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

        if ( arr.length >= 2 ) {
            this.user = arr[ 1 ];
        } else {
            this.user = "";
        }
    }

    public String getUser() {
           return user;
        }

    public String getLang() {

        if ( this.language.isEmpty( ) ) {

            language = "xhosa";

            return Language.valueOf( "xhosa" ).getValue( );
        } else {

           return Language.valueOf( language.toLowerCase( ) ).getValue( ) ;
        }
    }

    public boolean hasName( ) {
      return !user.isEmpty();
    };
    public boolean hasLanguage(){
        return !getLang().equals( null );
    }


}