package net.greet;
import java.util.HashMap;
import java.util.Map;

public class Greet {

    static   int counter = 0;
    static String language;
   static  String name;
     static String message;

    public Greet ( String language ,String name ) {

        this.name = name.toUpperCase ( );
        this.language = language;
    }

  static  Map < String, Integer > nameList = new HashMap <> ( );

   /* public static String greetMessage ( ) {

        if ( name.isEmpty() == true ) {
            System.out.println ( "please enter a name " );
        }

        if ( language.isEmpty () ) {
            System.out.println ( "please enter a language " );
        }
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

    public static void nameS (String names ) {

//        nameList.put ( name ,1 );

        if (name !="") name = names;

        Integer counter = nameList.containsKey (names) ? nameList.get (names) : 0;
        nameList.put (names, counter + 1);


        System.out.println ( nameList );
        System.out.println ( "is nameList empty? : " + nameList.isEmpty ( ) );
    }

    public static int count ( ) {

        counter = nameList.size ( );
        return counter;
    }

    public  String getLanguage ( ) {
        return language;
    }

    public  String getName ( ) {
        return name;
    }


}