package net.greet;

public class CommandExtractor {

    String user;
    String language;
    String command;
    String[] arr;


    public CommandExtractor ( String command ) {

         this.arr = command.split ( " " );
        this.command = arr[ 0 ];
        this.user = arr[ 1 ];

        this.language ="xhosa";
        if(arr.length == 3) {
            this.language = arr[ 2 ];
        }

    }

    public String getCommand ( ) {

        System.out.println (arr);
        if ( arr.length == 2 && command.equalsIgnoreCase ( "greet" ) ) {

           String diff =language = "xhosa";
            System.out.println ( "\n" + Language.valueOf ( diff ).getValue () + user );

        } else if ( arr.length == 3 ) {
            language = arr[ 2 ];
            System.out.println ( "\n" + Language.valueOf ( language ).getValue () + user );

        }
        return command;
    }

    public String getUser ( ) {
        System.out.println ( user );
        return user;
    }

    public String getLang ( ) {

        if ( this.language.isEmpty () ) {

            language = "xhosa";
            System.out.println ( Language.valueOf ( language.toLowerCase () ).getValue () );
            return Language.valueOf ( "xhosa" ).getValue ();

        } else {
            System.out.println ( Language.valueOf ( language.toLowerCase () ).getValue () );
        }
        return Language.valueOf ( language.toLowerCase () ).getValue ();
    }

}
