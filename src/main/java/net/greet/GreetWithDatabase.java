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
    }    Connection conn;

    {
        try {
            conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    final String INSERT_PEOPLE_SQL = "insert into people (name, language) values (?, ?)";
    PreparedStatement addToDB;

    {
        try {
            addToDB = conn.prepareStatement ( INSERT_PEOPLE_SQL );
        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }

    @Override
    public void namesWithDefault ( String name ) throws SQLException{

        addToDB.setString ( 1 , name );
        String language = "xhosa";

        addToDB.setString ( 2 , Language.valueOf ( language ).getValue ( ) );
        addToDB.execute ( );

        PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );
        ps.setString ( 1 , name );
        ResultSet rs = ps.executeQuery ( );
        while ( rs.next ( ) ) {
            //   System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
            System.out.println ( "\n" + rs.getString ( "language" ) + " " + rs.getString ( "name".toUpperCase ( ) ) );
        }
    }

    @Override
    public void namesWithLang( String name, String language) throws SQLException{

        addToDB.setString ( 1 , name );
        addToDB.setString ( 2 , Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) );
        Language.valueOf ( language.toLowerCase ( ) );
        addToDB.execute ( );

        PreparedStatement ps = conn.prepareStatement ( "select * from people where name = ?" );
        ps.setString ( 1 , name );
        ResultSet s = ps.executeQuery ( );
        s.next ( );

        //   System.out.println ( "\n" + Language.valueOf ( language.toLowerCase ( ) ).getValue ( ) + userName.toUpperCase ( ) );
        System.out.println ( "\n" + s.getString ( "language" ) + " " + s.getString ( "name" ) );
    }

    @Override
    public void names ( String name ){

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
    public void greetedName ( String name ){

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
}
