package net.greet;

public class Language {

    public enum LangType {IsiXhosa , Portuguese, French,English
    }
        public static String langInSwitch(LangType type) {

            switch(type) {
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
    }
