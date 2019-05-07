package net.greet;

import java.util.HashMap;
import java.util.Map;

public class GreetWithHashMap implements Greet {

    int counter = 0;
    String name;
    public int countName;

    static Map < String,Integer > nameList = new HashMap <> ( );

    public GreetWithHashMap ( ) {
        System.out.println ( "USING IN-MEMORY " );
    }

    @Override
    public String names ( String names ) {
        names = names.substring ( 0, 1 ).toLowerCase ( ) + names.substring ( 1 ).toLowerCase ( );
        if ( name != "" ) name = names;
        Integer counter = nameList.containsKey ( names ) ?nameList.get ( names ) : 0;
        nameList.put ( names, counter + 1 );
        return names;
    }
    @Override
    public String namesGreeted ( ) {

        if ( nameList.isEmpty ( ) == true ) {
            System.out.println ( "\nno users have been greeted yet" );
            return "\nno users have been greeted yet";
        } else {
            System.out.println ( nameList );
            return "greeted names";
        }
    }
    @Override
    public String removeName ( String name ) {
        if ( nameList.containsKey ( name ) ) {
            nameList.remove ( name );
            return "\n" + name + " was removed successfully!";
        } else {
            System.out.println ( "\nuser not found" );
            return "\nuser not found";
        }
    }
    @Override
    public String clearNames ( ) {

        if ( nameList.isEmpty ( ) == true ) {
            System.out.println ( "\nlist is empty" );
            return "list is empty";
        } else{
            nameList.clear ( );
            System.out.println ( "\nDeleted all users !" );
            return "deleted all users";

        }
    }
    @Override
    public int count ( ) {
        if ( nameList.size ( ) == 0 ) {
            System.out.println ( "\nNo users have been greeted yet" );
        } else {
            System.out.println ( "\nShould return the Counter:\n" );
            counter = nameList.size ( );
        }
        return counter;
    }
    @Override
    public String invalid ( ) {
        System.out.println ( "\nInvalid command." + "\ntype 'help' to get the list of valid commands." );
        return "\nInvalid command." + "\ntype 'help' to get the list of valid commands.";
    }
    @Override
    public String help ( ) {
        System.out.println ( "\nValid Commands are as follow :\n" + "\n- greet + name + language : will greet a person with a language of your choice." );
        System.out.println ( "- greet + name : will greet a person with the default language.\n" + "- greeted : will display a list of greeted names. " );
        System.out.println ( "- count + name : will display how many times a person has been greeted.\n" + "- counter : will display the number of greeted names. " );
        System.out.println ( "- clear + name : will remove a persons name from the list and decrement the counter.\n" + "- clearall : will delete all the names on the list set the counter to 0." );
        System.out.println ( "- exit : will exit the greeting application.\n" + "- help : will display all the possible commands to use when using this application." );
        return "Valid-Commands";
    }
    @Override
    public String exit ( ) {
        System.out.println ( "\nGood-Bye\n" );

        System.exit ( 0 );
        return "Good-Bye";
    }
    @Override
    public int countName ( String name ) {

        for ( Map.Entry entry : nameList.entrySet ( ) ) {
            this.countName = ( int ) entry.getValue ( );
        }
        System.out.println ( "\n" + name + " was greeted " + countName+ " time(s)\n" );
        return countName;
    }
}