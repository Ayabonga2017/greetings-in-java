package net.greet;

import java.sql.SQLException;

interface Greet {

    String names( String name);
    void namesGreeted() throws SQLException ;
    String removeName(String name);
    String clearNames();
    int count() throws SQLException;
    String invalid();
    void help();
    void exit();
  //  String namesWithDefault( String name);
 //   String namesWithLang( String name, String language);
    int countName(String name);
}