package net.greet;

import java.sql.SQLException;

interface Greet {

    void names( String name);
    void namesGreeted() throws SQLException ;
    String removeName(String name);
    void clearNames();
    int count() throws SQLException;
    void invalid();
    void help();
    void exit();
    void namesWithDefault(String name);
    void namesWithLang(String name, String language);
    int countName(String name);
}