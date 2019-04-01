package net.greet;

import java.util.ArrayList;

public class Greet {


    public static int counter;
    static String  language;
    static  String name;
    private static String message;


    public Greet(String aLanguage, String aName )
    {
        name = aName.toUpperCase ();
        language = aLanguage;
    }

    public static String greetMessage( ) {

      String   error = "select the right language";

            if ( language == "Portuguese" ) {
                counter++;
                return message ="OLÀ " + name + " !";
            }
            if ( language == "IsiXhosa" ) {
                counter++;
                return message= "MHOLO " + name + " !";
            }
            if ( language == "French" ) {
                counter++;
                return message = "BONJOUR " + name + " !" ;

            }
            return message;
    }

    public static String name(){ return name;}

    public static int count(){
        return counter ++; }

    public static String lang(){ return language; }

}