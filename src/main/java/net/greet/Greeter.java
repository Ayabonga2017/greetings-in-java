package net.greet;

public class Greeter {

    String  language;
  static  String name;
    String help;

    public Greeter(String aLanguage, String aName )
    {
        name = aName.toUpperCase ();
        language = aLanguage;
    }

    public String greetMessage() {

        help = "please select the right language '1. Portuguese ; 2. IsiXhosa ; 3. French ' ";

        if (language == "Portuguese"){ return "OLÀ " + name +  " !"; }
        if (language == "IsiXhosa"){ return "MHOLO " + name + " !"; }
        if (language == "French"){ return "BONJOUR " + name + " !"; }

        return help;
    }

    public static void greeted(){
        System.out.println ( name );

    }
    public static void countUser(){

        System.out.println ( name.length ());
    }
}