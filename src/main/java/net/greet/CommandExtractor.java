package net.greet;


public class CommandExtractor {

    private String user;
    private String language;
    private String command;

    public CommandExtractor( String command ) {

        String[] arr = command.split( " " );
        this.command = arr[ 0 ];
        this.language = "xhosa";

        if ( arr.length == 3 ) {
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
           return language;
        }

    public String getCommand( ) {
        return command;
    }

    public String getGreet(){

        return "\n"+ Language.valueOf( language.toLowerCase( ) ).getValue( )+getUser();
    }

}