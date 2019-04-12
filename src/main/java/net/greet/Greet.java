package net.greet;

import java.sql.SQLException;

interface Greet {

    void names( String name);
    void namesGreeted() throws SQLException;
    void greetedName(String name);
    void removeName(String name);
    void clearNames() throws SQLException;
    int count();
    void invalid();
    void help();
    void exit();
    void namesWithDefault(String name)throws SQLException;
    void namesWithLang(String name, String language) throws SQLException;
}

