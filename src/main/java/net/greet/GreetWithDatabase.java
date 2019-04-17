package net.greet;

import java.sql.*;

public class GreetWithDatabase implements Greet {

    final String DATABASE_URL = "jdbc:h2:./target/greet_java";

    public void loadJdbcDriver () {

        try {

            Class.forName ( "org.h2.Driver" );
        } catch ( ClassNotFoundException e ) {
            // fail ( e );
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

    public GreetWithDatabase () {

        try {
            insertDB = conn.prepareStatement ( INSERT_PEOPLE_SQL );
            findCount = conn.prepareStatement ( FIND_COUNTER_SQL );
            updateCounter = conn.prepareStatement ( UPDATE_NAME_COUNT_SQL );

        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    @Override
    public void greetedName ( String name ) {

        try {
            findCount.setString ( 1 , name );
            ResultSet rs = findCount.executeQuery ( );

            if ( ! rs.next ( ) ) {
                // insert
                insertDB.setString ( 1 , name );
                insertDB.setInt ( 2 , 1 );
                System.out.println ( insertDB.execute ( ) );

            } else {
                //if already exists
                int count = rs.getInt ( "counter" );
                updateCounter.setInt ( 2 , ++ count );
                updateCounter.setString ( 1 , name );
                updateCounter.execute ( );
            }

        } catch ( SQLException ex ) {
            ex.printStackTrace ( );
        }
    }

    @Override
    public void namesWithDefault ( String name ) throws SQLException {

        try {

            findCount.setString ( 1 , name );
            ResultSet rs = findCount.executeQuery ( );

            if ( ! rs.next ( ) ) {
                // insert
                insertDB.setString ( 1 , name );
                insertDB.setInt ( 2 , 1 );
                insertDB.execute ( );

            } else {
                //if already exists
                int count = rs.getInt ( "counter" );
                updateCounter.setInt ( 1 , ++ count );
                updateCounter.setString ( 2 , name );
                updateCounter.execute ( );
                System.out.println ( "\n" + "Updated Counter" );

            }
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    @Override
    public void namesWithLang ( String name , String language ) throws SQLException {

        try {

            findCount.setString ( 1 , name );
            ResultSet rs = findCount.executeQuery ( );

            if ( ! rs.next ( ) ) {
                // insert
                insertDB.setString ( 1 , name );
                insertDB.setInt ( 2 , 1 );
                insertDB.execute ( );

            } else {
                //if already exists
                int count = rs.getInt ( "counter" );
                updateCounter.setInt ( 1 , ++ count );
                updateCounter.setString ( 2 , name );
                updateCounter.execute ( );
                System.out.println ( "\n" + "Updated Counter" );

            }

        } catch ( SQLException ex ) {
            ex.printStackTrace ( );
        }

    }

    @Override
    public void namesGreeted () throws SQLException {

        PreparedStatement ps = conn.prepareStatement ( "select name from people " );
        ResultSet rs = ps.executeQuery ( );

        if ( rs.next ( ) ) {
            System.out.println ( "\n" + rs.getString ( "name" ) );
        } else {
            System.out.println ( "\nNo names greeted yet" );
        }
    }

    @Override
    public void removeName ( String name ) {

    }

    @Override
    public void clearNames () throws SQLException {
        Statement statement = null;
        try {
            statement = conn.createStatement ( );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
        try {
            statement.addBatch ( "delete from people" );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
        statement.executeBatch ( );
        System.out.println ( "\n" + "deleted all users from the Database" );
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
                System.out.println ( "\n" + rs.getInt ( "counter" ) );
            }
        } catch ( SQLException ex ) {
            ex.printStackTrace ( );
        }
        // if this pet wasn't greeted yet
        return 0;
    }

    @Override
    public void invalid () {
        System.out.println ( "\nInvalid command." + "\ntype 'help' to get the list of valid commands." );
    }

    @Override
    public void help () {
        System.out.println ( "\nValid Commands are as follow :\n" + "\n- greet + name + language : will greet a person with a language of your choice." );
        System.out.println ( "- greet + name : will greet a person with the default language.\n" + "- greeted : will display a list of greeted names. " );
        System.out.println ( "- greetedcount + name : will display how many times a person has been greeted.\n" + "- counter : will display the number of greeted names. " );
        System.out.println ( "- clear + name : will remove a persons name from the list and decrement the counter.\n" + "- clearall : will delete all the names on the list set the counter to 0." );
        System.out.println ( "- exit : will exit the greeting application.\n" + "- help : will display all the possible commands to use when using this application." );
    }

    @Override
    public void exit () {
        System.out.println ( "\nGood-Bye\n" );
        System.exit ( 0 );
    }

    @Override
    public void names ( String name ) {

    }
}
