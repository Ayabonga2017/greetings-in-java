package net.greet;
import javax.naming.Name;
import java.util.HashMap;
import java.util.Map;

public class Greet {

    static int counter = 0;
    static String language;
    static String name;

    public Greet ( String language ,String name ) {

        this.name = name.toLowerCase ( );
        this.language = language;

        if ( name.isEmpty() == true ) { System.out.println ( "please enter a name " ); }

        if ( language.isEmpty () ==true ) { Language.valueOf ( "english" ); }
    }

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
    }

    public static void namesGreeted ( ) { System.out.println ( nameList); }

    public static void greetedName(String name ){
        for (Map.Entry entry : nameList.entrySet()) {
            System.out.println("\n"+name + " was greeted " + entry.getValue()+ " time(s)\n");
        } }
    public static void removeName(String name ){
        if(nameList.containsKey(name)){ nameList.remove(name); System.out.println ("\n"+name + " was removed from the list !\n" ); } }

    public  static  void clearNames(){ nameList.clear (); System.out.println ( "Deleted all users !" ); }

    public static int count ( ) { System.out.println ( counter = nameList.size ( ) );
        return counter;
    }
    public static void help ( ) { System.out.println (" List of commands\n"); }
    public static void exit ( ) {System.out.println (" Good-Bye\n"); System.exit ( 0 ); }

}