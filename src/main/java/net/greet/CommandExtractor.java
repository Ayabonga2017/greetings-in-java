package net.greet;


public class CommandExtractor {

    String user ;
    String language;
    String command;
    String[] arr ;



    public CommandExtractor ( String command ){

        String[] arr = command.split ( " " );
        this.command =arr[0] ;
        this.user = arr[1];
        this.language =arr[2];

    }

    public String getCommand () {

        if ( command != "greet" ) {
            System.out.println ( "enter 'greet' to be able to greet a person" );

        }else if ( arr.length == 2 && command.equalsIgnoreCase ( "greet" )) {
            user = "Aya";
                language = "xhosa";
                System.out.println ( "\n" + Language.valueOf ( language).getValue ( ) + user);

            }else if ( arr.length == 3 ) {
                System.out.println ( "\n" + Language.valueOf ( language ).getValue ( ) + user);

            }
        return "wrong command";
    }

    public String getUser(){
        return user;
    }
    public String getLang(){
        return Language.valueOf ( language.toLowerCase ( ) ).getValue ( );
    }

}
