package net.greet;

import java.sql.*;

public class GreetWithDatabase implements Greet {

    final String DATABASE_URL = "jdbc:h2:./target/greet_java_test";

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

//    @Override
//    public String namesWithDefault ( String name ) {
//        name = name.substring ( 0,1).toLowerCase () + name.substring ( 1 ).toLowerCase ();
//        name.equalsIgnoreCase ( name );
//
//        try {
//
//            findCount.setString ( 1 , name );
//            ResultSet rs = findCount.executeQuery ( );
//
//            if ( ! rs.next ( ) ) {
//                // name doesn't ---- insert
//                insertDB.setString ( 1 , name );
//                insertDB.setInt ( 2 , 1 );
//                insertDB.execute ( );
//
//            } else {
//                //if already exists ---- update counter
//                int count = rs.getInt ( "counter" );
//                updateCounter.setInt ( 1 , ++ count );
//                updateCounter.setString ( 2 , name );
//                updateCounter.execute ( );
//                System.out.println ( "\n" + "Updated "+name+"'s counter" );
//
//            }
//        } catch ( SQLException e ) {
//            e.printStackTrace ( );
//        }
//        return name;
//    }
//  //  @Override
//    /* public String namesWithLang ( String name , String language ) { */
//        name = name.substring ( 0,1).toLowerCase () + name.substring ( 1 ).toLowerCase ();
//        name.equalsIgnoreCase ( name );
//
//        try {
//
//            findCount.setString ( 1 , name );
//            ResultSet rs = findCount.executeQuery ( );
//
//            if ( ! rs.next ( ) ) {
//                // name doesn't ---- insert
//                insertDB.setString ( 1 , name );
//                insertDB.setInt ( 2 , 1 );
//                insertDB.execute ( );
//
//            } else {
//                //if already exists ---- update counter
//                int count = rs.getInt ( "counter" );
//                updateCounter.setInt ( 1 , ++ count );
//                updateCounter.setString ( 2 , name );
//                updateCounter.execute ( );
//                System.out.println ( "\n" + "Updated "+name +"'s counter" );
//
//            }
//
//        } catch ( SQLException ex ) {
//            ex.printStackTrace ( );
//        }
//return name;
//    }
    @Override
    public void namesGreeted () throws SQLException {

        PreparedStatement ps = conn.prepareStatement ( "select name from people " );
        ResultSet rs = ps.executeQuery ( );

        while ( rs.next ( ) ) {
            System.out.println ( "\n" + rs.getString ( "name" ) );
            rs.getString ( "name"  );
        }
    }
    @Override
    public String removeName ( String name ) {

        try {

            // set the corresponding param
            remove.setString ( 1 , name );
            // execute the delete statement
            remove.execute ( );
            System.out.println ( "\n" + name + " was deleted from the Database" );
            return "\n" + name + " was deleted from the Database" ;

        } catch ( SQLException e ) {
            System.out.println ( e.getMessage ( ) );
        }
        return "\n" + name + " was deleted from the Database" ;

    }
    @Override
    public String clearNames () {
        try {
            deleteAll.execute ( );
            return ( "Deleted all users from the Database" );

        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }

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
    public int countName ( String name ) {

        try {
            findCount.setString ( 1 , name );
            ResultSet rs = findCount.executeQuery ( );

            if ( rs.next ( ) ) {
                System.out.println ("\n"+ name+" was greeted " + rs.getInt ( "counter" ) + " time(s)" );
                return rs.getInt ( "counter" );
            }else{
                System.out.println ("\nuser is not on the database" );
            }
        } catch ( SQLException ex ) {
            ex.printStackTrace ( );
        }
        // if this name wasn't greeted yet
        return 0;
    }
    @Override
    public String invalid () {
        System.out.println ( "\nInvalid command." + "\ntype 'help' to get the list of valid commands." );
        return "\nInvalid command." + "\ntype 'help' to get the list of valid commands.";
    }
    @Override
    public void help () {
        System.out.println ( "\nValid Commands are as follow :\n" + "\n- greet + name + language : will greet a person with a language of your choice." );
        System.out.println ( "- greet + name : will greet a person with the default language.\n" + "- greeted : will display a list of greeted names. " );
        System.out.println ( "- count + name : will display how many times a person has been greeted.\n" + "- counter : will display the number of greeted names. " );
        System.out.println ( "- clear + name : will remove a persons name from the list and decrement the counter.\n" + "- clearall : will delete all the names on the list set the counter to 0." );
        System.out.println ( "- exit : will exit the greeting application.\n" + "- help : will display all the possible commands to use when using this application." );
    }
    @Override
    public void exit () {
        System.out.println ( "\nGood-Bye\n" );
        System.exit ( 0 );
    }
    @Override
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