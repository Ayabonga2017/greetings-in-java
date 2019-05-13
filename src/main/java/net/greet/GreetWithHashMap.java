package net.greet;

import java.util.HashMap;
import java.util.Map;

public class GreetWithHashMap implements Greet {

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
    public Map < String,Integer > namesGreeted ( ) {

            return  nameList;
        }
    @Override
    public String removeName ( String name ) {
        if ( nameList.containsKey ( name ) ) {
            nameList.remove ( name );
            return "\n" + name + " was removed successfully!";
        } else {
            return "\nuser not found";
        }
    }
    @Override
    public String clearNames ( ) {

        if ( nameList.isEmpty ( ) == true ) {
            return "list is empty";
        } else{
            nameList.clear ( );
            return "deleted all users";

        }
    }
    @Override
    public int count ( ) {

        return  nameList.size ( );
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