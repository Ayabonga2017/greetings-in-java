package net.greet;

import java.sql.SQLException;
import java.util.Map;

public interface Greet {

    String names( String name);
    Map < String,Integer > namesGreeted() throws SQLException ;
    String removeName(String name);
    String clearNames();
    int count() throws SQLException;
    int countName(String name);
}