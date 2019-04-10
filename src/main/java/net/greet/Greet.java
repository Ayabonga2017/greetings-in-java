package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Greet {

    static int counter = 0;
    static String language;
    static String name;

    public Greet ( String language , String name ) throws SQLException {

        this.name = name.toLowerCase ( );
        this.language = language;

        if (name.isEmpty ( ) == true) {
            System.out.println ( "please enter a name " );
        }

        if (language.isEmpty ( ) == true) {
            Language.valueOf ( "xhosa" );
        }
    }

    static Map < String,Integer > nameList = new HashMap <> ( );

    public static void nameS ( String names ) {
        names = names.substring ( 0 , 1 ).toUpperCase ( ) + names.substring ( 1 ).toUpperCase ( );
        if (name != "") name = names;
        Integer counter = nameList.containsKey ( names ) ?nameList.get ( names ) : 0;
        nameList.put ( names , counter + 1 );
    }

    public static void namesGreeted ( ) {

        if (nameList.isEmpty ( ) == true) {
            System.out.println ( "\nno users have been greeted yet" );
        } else {
            System.out.println ( nameList );
        }
    }

    public static void greetedName ( String name ) {

        if (name.isEmpty ( ) == false) {
            for ( Map.Entry entry : nameList.entrySet ( ) ) {
                System.out.println ( "\n" + name + " was greeted " + entry.getValue ( ) + " time(s)\n" );
            }
        } else {
            System.out.println ( "\nuser not found" );
        }
    }

    public static void removeName ( String name ) {
        if (nameList.containsKey ( name )) {
            nameList.remove ( name );
            System.out.println ( "\n" + name + " was removed from the list !\n" );
        } else {
            System.out.println ( "\nuser not found" );
        }
    }

    public static void clearNames ( ) {
        if (nameList.isEmpty ( ) == true) {
            System.out.println ( "\nlist is empty" );
        } else if (nameList.isEmpty ( ) == false) {
            nameList.clear ( );
            System.out.println ( "\nDeleted all users !" );
        }
    }

    public static int count ( ) {
        if (nameList.size ( ) == 0) {
            System.out.println ( "\nNo users have been greeted yet" );
        } else {
            System.out.println ( counter = nameList.size ( ) );
        }
        return counter;
    }

    public static void invalid ( ) {
        System.out.println ( "\nInvalid command." + "\ntype 'help' to get the list of valid commands." );
    }

    public static void help ( ) {
        System.out.println ( "\nValid Commands are as follow :\n" + "\n- greet + name + language : will greet a person with a language of your choice." );
        System.out.println ( "- greet + name : will greet a person with the default language.\n" + "- greeted : will display a list of greeted names. " );
        System.out.println ( "- greetedcount + name : will display how many times a person has been greeted.\n" + "- counter : will display the number of greeted names. " );
        System.out.println ( "- clear + name : will remove a persons name from the list and decrement the counter.\n" + "- clearall : will delete all the names on the list set the counter to 0." );
        System.out.println ( "- exit : will exit the greeting application.\n" + "- help : will display all the possible commands to use when using this application." );
    }

    public static void exit ( ) {
        System.out.println ( "\nGood-Bye\n" );
        System.exit ( 0 );
    }

}

