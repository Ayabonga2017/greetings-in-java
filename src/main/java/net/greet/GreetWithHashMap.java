package net.greet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GreetWithHashMap implements Greet{

    int counter = 0;
    String name;
    String language;

    static Map < String,Integer > nameList = new HashMap <> ( );

    @Override
    public void names ( String names ) {
        names = names.substring ( 0 , 1 ).toUpperCase ( ) + names.substring ( 1 ).toUpperCase ( );
        if (name != "") name = names;
        Integer counter = nameList.containsKey ( names ) ?nameList.get ( names ) : 0;
        nameList.put ( names , counter + 1 );
    }
    @Override
    public void namesGreeted ( ) {

        if (nameList.isEmpty ( ) == true) {
            System.out.println ( "\nno users have been greeted yet" );
        } else {
            System.out.println ( nameList );
        }
    }
    @Override
    public void greetedName ( String name ) {

        if (name.isEmpty ( ) == false) {
            for ( Map.Entry entry : nameList.entrySet ( ) ) {
                System.out.println ( "\n" + name + " was greeted " + entry.getValue ( ) + " time(s)\n" );
            }
        } else {
            System.out.println ( "\nuser not found" );
        }
    }
    @Override
    public void removeName ( String name ) {
        if (nameList.containsKey ( name )) {
            nameList.remove ( name );
            System.out.println ( "\n" + name + " was removed from the list !\n" );
        } else {
            System.out.println ( "\nuser not found" );
        }
    }
    @Override
    public  void clearNames ( ) {

        if (nameList.isEmpty ( ) == true) {
            System.out.println ( "\nlist is empty" );
        } else if (nameList.isEmpty ( ) == false) {
            nameList.clear ( );
            System.out.println ( "\nDeleted all users !" );
        }
    }
    @Override
    public  int count ( ) {
        if (nameList.size ( ) == 0) {
            System.out.println ( "\nNo users have been greeted yet" );
        } else {
            System.out.println ( "\nShould return the Counter:\n") ;
            System.out.println ( counter = nameList.size ( ) );
        }
        return counter;
    }
    @Override
    public void invalid ( ) {
        System.out.println ( "\nInvalid command." + "\ntype 'help' to get the list of valid commands." );
    }
    @Override
    public void help ( ) {
        System.out.println ( "\nValid Commands are as follow :\n" + "\n- greet + name + language : will greet a person with a language of your choice." );
        System.out.println ( "- greet + name : will greet a person with the default language.\n" + "- greeted : will display a list of greeted names. " );
        System.out.println ( "- greetedcount + name : will display how many times a person has been greeted.\n" + "- counter : will display the number of greeted names. " );
        System.out.println ( "- clear + name : will remove a persons name from the list and decrement the counter.\n" + "- clearall : will delete all the names on the list set the counter to 0." );
        System.out.println ( "- exit : will exit the greeting application.\n" + "- help : will display all the possible commands to use when using this application." );
    }
    @Override
    public void exit ( ) {
        System.out.println ( "\nGood-Bye\n" );
        System.exit ( 0 );
    }
    @Override
    public void namesWithDefault ( String name ) throws SQLException{
        language = "xhosa";

        System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + name.toUpperCase ( ) );
    }
    @Override
    public void namesWithLang ( String name , String language ) throws SQLException{ }

    @Override
    public int countName ( String name ){
        return 0;
    }
}
