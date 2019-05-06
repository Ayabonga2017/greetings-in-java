package net.greet;


public class CommandExtractor {

    private String user;
    private String language;
    private String command;
    // String[] arr;
    boolean lengthOne;

    public CommandExtractor( String command ) {

        String[] arr = command.split( " " );
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

    public String getCommand( ) {
        return command;
    }

    public String getGreet(){
        System.out.printf( getLang()+getUser() );
        return getLang()+getUser();
    }
//    public String getLanguage( ) {
//        return language;
//    }
//
//    public boolean hasLanguage(){
//        return !getLang().equals( null );
//    }


}