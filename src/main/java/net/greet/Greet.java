package net.greet;
import java.util.HashMap;
import java.util.Map;

public class Greet {

    static int counter = 0;
    static String language;
    static String name;

    public Greet ( String language ,String name ) {

        this.name = name.toUpperCase ( );
        this.language = language;

        if ( name.isEmpty() == true ) { System.out.println ( "please enter a name " ); }

        if ( language.isEmpty () ) { } }

    static Map < String, Integer > nameList = new HashMap <> ( );

   /* public static String greetMessage ( ) {


        if ( language == "Portuguese" ) {
            return message = "OLÀ " + name + " !";
        }
        if ( language == "IsiXhosa" ) {
            return message = "MHOLO " + name + " !";
        }
        if ( language == "French" ) {
            return message = "BONJOUR " + name + " !";
        }
        return message;
    }

    */

    public static void nameS ( String names ) {
        if ( name != "" ) name = names;
        Integer counter = nameList.containsKey ( names ) ? nameList.get ( names ) : 0;
        nameList.put ( names ,counter + 1 );
        // System.out.println ( "is nameList empty? : " + nameList.isEmpty ( ) );
    }

    public static void namesGreeted ( ) { System.out.println ( nameList); }

    public static void removeName(){
        if(nameList.containsKey(name)){ nameList.remove(name); } }

    public  static  void clearNames(){ nameList.clear (); }

    public static int count ( ) { counter = nameList.size ( );
        return counter;
    }

    public static void message ( ) {
        System.out.println ( language + Greet.name + " !");
    }
}
