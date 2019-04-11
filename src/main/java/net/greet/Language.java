package net.greet;

public enum Language {

    xhosa ("MHOLO "),
    english ("HEY "),
    french ("BONJOUR "),
    portuguese ("OLÀ ");

    public String value;

    Language ( String value ) { this.value = value.toLowerCase ( ); }

    public String getValue ( ) { return value.toUpperCase ( ); }
}

