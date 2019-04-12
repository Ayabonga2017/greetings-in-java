package net.greet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CounterWithDB {
    public static void main ( String args[] ) throws SQLException, ClassNotFoundException{


        final String DATABASE_URL = "jdbc:h2:./target/greet_java";
        Class.forName ( "org.h2.Driver" );
        Connection conn = DriverManager.getConnection ( DATABASE_URL , "sa" , "" );
        final String INSERT_PEOPLE_SQL = "insert into people (name, language) values (?, ?)";
        PreparedStatement addToDB = conn.prepareStatement ( INSERT_PEOPLE_SQL );


    }
}