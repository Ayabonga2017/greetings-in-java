package net.greet;

public class Language {
/*/
    public enum LangType {
        IsiXhosa(), Portuguese, French, English
    }


    public static String langInSwitch ( LangType type ) {

        switch (type) {
            case IsiXhosa:
                return "MHOLO " + Greet.name + " !";
            case Portuguese:
                return "OLÀ " + Greet.name + " !";
            case French:
                return "BONJOUR " + Greet.name + " !";
            case English:
                return "Hey " + Greet.name + " ! ";
            default:
                return "Hey " + Greet.name + " !";
        }
    }

*/

    enum Types {

        Xhosa ( "MHOLO" ),
        English ( "Hey" ),
        French ( "BONJOUR" ),
        Portugues ( "OLÀ" );

        private final String greet;

        Types (String greet) {
             this.greet = greet;
        }
        public String getGreet( ){

            return greet + Greet.name;
        }
    }
}
