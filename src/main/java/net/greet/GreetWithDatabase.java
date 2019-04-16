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
    } Connection conn;

    {
        try {
            conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    final String INSERT_PEOPLE_SQL = "insert into people (name) values (?)";
    PreparedStatement insertDB;

    final String FIND_COUNTER_SQL = "select counter from people where name = ?";
    PreparedStatement foundCount;

    final String UPDATE_NAME_COUNT_SQL = "update people set counter = ? where name = ?";
    PreparedStatement updateCounter;

    {
        try {
            insertDB = conn.prepareStatement ( INSERT_PEOPLE_SQL );
            foundCount =conn.prepareStatement ( FIND_COUNTER_SQL );
            updateCounter = conn.prepareStatement ( UPDATE_NAME_COUNT_SQL );

        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    @Override
    public void greetedName ( String name ){
        try {
            foundCount.setString(1, name);
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
        try {
            ResultSet rs = foundCount.executeQuery();

            if (!rs.next()) {
                // insert
                insertDB.setString(1, name);
                insertDB.setInt(3, 1);
                System.out.println(insertDB.execute());

            } else {
                int count = rs.getInt("counter");
                updateCounter.setInt(3, ++count);
                updateCounter.setString(1, name);
                updateCounter.execute();
            }

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void namesWithDefault ( String name ) throws SQLException{

        insertDB.setString ( 1 , name );
        String language = "xhosa";
        insertDB.execute ( );

        PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );
        ps.setString ( 1 , name );
        ResultSet rs = ps.executeQuery ( );
        if ( rs.next ( ) ) {
            //   System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
            System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue () + " " + rs.getString ( "name".toUpperCase ( ) ) );
        }
    }

    @Override
    public void namesWithLang( String language, String name) throws SQLException{

        insertDB.setString ( 1 , name );
        insertDB.execute ( );

        language =Language.valueOf ( language.toLowerCase ( ) ).getValue ();

        PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );

        ps.setString ( 1 , name );
        ResultSet s = ps.executeQuery ( );
        if ( s.next ( ) ) {

            System.out.println ( "\n" + language+ " " + s.getString ( "name" ) );
        }
    }


    @Override
    public void namesGreeted () throws SQLException{
        PreparedStatement ps = conn.prepareStatement ( "select name from people " );
        ResultSet rs = ps.executeQuery ( );

        while ( rs.next ( ) ) {
            System.out.println ( "\n" + rs.getString ( "name" ) );
        }
    }

    @Override
    public void removeName ( String name ){

    }

    @Override
    public void clearNames () throws SQLException{
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
        System.out.println ("deleted all users from the Database" );
    }

    @Override
    public int count (){

        return 0;
    }

    @Override
    public void invalid (){

    }

    @Override
    public void help (){

    }

    @Override
    public void exit (){

    }
    @Override
    public void names ( String name ){

    }
}
