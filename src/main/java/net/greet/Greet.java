package net.greet;

import java.sql.SQLException;

public interface Greet {

    String names( String name);
    String namesGreeted() throws SQLException ;
    String removeName(String name);
    String clearNames();
    int count() throws SQLException;
    String invalid();
    String help();
    String exit();
    int countName(String name);
}