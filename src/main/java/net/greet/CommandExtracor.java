package net.greet;


public class CommandExtracor {

    String user ;
    String language;
    String command;


    public CommandExtracor ( String command , String user , String language ){

        this.user = user;
        this.language =language;
        this.command =command ;
    }

    public String getUserName () {

        if ( user.isEmpty ( ) == true ) {
            System.out.println ( "\nenter name to greet" );
        } else {
            System.out.println (user );
        }
        return user;
    }

    public String getLanguage () {

        if ( language== "" ){
            System.out.println (Language.valueOf ( "xhosa" ).getValue () );
        }else {
            System.out.println (Language.valueOf ( language ).getValue () );
        }
        return language;
    }

    public String getCommand () {

        if ( command != "greet" ){

            System.out.println ("enter 'greet' to be able to greet a person" );

        }else if (command.equals("greet")){

            System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + user.toUpperCase ( ));
        }
        return command;
    }

    public String getUser(){
        return user;
    }
    public String getLang(){
        return Language.valueOf ( language.toLowerCase ( ) ).getValue ( );
    }

}
