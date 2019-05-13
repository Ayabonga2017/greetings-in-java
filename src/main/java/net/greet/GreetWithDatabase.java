package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GreetWithDatabase implements Greet {

    final String DATABASE_URL = "jdbc:h2:./target/greet_java_test";
    private int count;

    public void loadJdbcDriver () {

        try {
            Class.forName ( "org.h2.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace ( );
        }
    }

    Connection conn;

    {
        try {
            conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    final String INSERT_PEOPLE_SQL = "insert into people (name,counter) values (?, ?)";
    PreparedStatement insertDB;

    final String FIND_COUNTER_SQL = "select counter from people where name = ?";
    PreparedStatement findCount;

    final String UPDATE_NAME_COUNT_SQL = "update people set counter = ? where name = ?";
    PreparedStatement updateCounter;

    final String REMOVE_USER = "DELETE FROM people WHERE name = ?";
    PreparedStatement remove;

    final String DELETE_USERS_SQL ="delete from people";
    PreparedStatement deleteAll;
    Map < String,Integer > dbMap = new HashMap <> ();
    public GreetWithDatabase () {

        try {
            insertDB = conn.prepareStatement ( INSERT_PEOPLE_SQL );
            findCount = conn.prepareStatement ( FIND_COUNTER_SQL );
            updateCounter = conn.prepareStatement ( UPDATE_NAME_COUNT_SQL );
            remove = conn.prepareStatement ( REMOVE_USER );
            deleteAll = conn.prepareStatement ( DELETE_USERS_SQL );

            System.out.println ("USING THE DATABASE" );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }
    @Override
    public Map < String,Integer > namesGreeted () throws SQLException {

        PreparedStatement ps = conn.prepareStatement ( "select name , counter from people " );
        ResultSet rs = ps.executeQuery ( );

        while ( rs.next ( ) ) {
            dbMap.put ( rs.getString ( "name" ), rs.getInt ( 2 ));
        }
        return dbMap;
    }
    @Override
    public String removeName ( String name ) {

        try {
            // set the corresponding param
            remove.setString ( 1 , name );
            // execute the delete statement
            remove.execute ( );
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage ( ) );
        }
        return "\n" + name + " was removed successfully!" ;

    }
    @Override
    public String clearNames () {
        try {
            deleteAll.execute ( );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
        return "deleted all users";
    }
    @Override
    public int count () throws SQLException {

        PreparedStatement ps = conn.prepareStatement ( "select count(*) as name_count from people" );
        ResultSet rs = ps.executeQuery ( );

        if ( rs.next ( ) ) {
            rs.getInt ( "name_count" );
        }
        return rs.getInt ( "name_count" );
    }
    @Override
    public int countName ( String name ) throws SQLException {

            findCount.setString(1, name);
            ResultSet rs = findCount.executeQuery();
            
            if ( rs.next ( ) ) {
                count= rs.getInt ( "counter" );
        }
            return count;
            // if this name wasn't greeted yet
    }
    public String names ( String name ) {

        name = name.substring ( 0,1).toLowerCase () + name.substring ( 1 ).toLowerCase ();
        name.equalsIgnoreCase ( name );

        try {

            findCount.setString ( 1 , name );
            ResultSet rs = findCount.executeQuery ( );

            if ( ! rs.next ( ) ) {
                // name doesn't ---- insert
                insertDB.setString ( 1 , name );
                insertDB.setInt ( 2 , 1 );
                insertDB.execute ( );

            } else {
                //if already exists ---- update counter
                int count = rs.getInt ( "counter" );
                updateCounter.setInt ( 1 , ++ count );
                updateCounter.setString ( 2 , name );
                updateCounter.execute ( );
                System.out.println ( "\n" + "Updated "+name+"'s counter" );

            }
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
        return name;
    }
}