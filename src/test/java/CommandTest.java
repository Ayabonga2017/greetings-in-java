import net.greet.CommandExtractor;
import net.greet.GreetWithDatabase;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    GreetWithDatabase greetMap = new GreetWithDatabase( );

    @Test
    public void command( ) {

        System.out.println( "\ngreet command test" );

        CommandExtractor comm = new CommandExtractor( "greet aya english" );

        assertEquals( comm.getLang( ) + comm.getUser( ), "hey aya" );

    }
    @Test
    public void commandWithFrench( ) {

        System.out.println( "\ngreet command test French" );

        CommandExtractor comm = new CommandExtractor( "greet aya french" );

        assertEquals( comm.getLang( ) + comm.getUser( ), "bonjour aya" );

    }
    @Test
    public void commandWithDiff( ) {

        System.out.println( "\ngreet command test diff" );

        CommandExtractor comm = new CommandExtractor( "greet thabang" );

        assertEquals( comm.getLang( ) + comm.getUser( ), "mholo thabang" );

    }
    @Test
    public void countNme( ) {

        System.out.println( "\ngreet command test diff" );

        CommandExtractor comm = new CommandExtractor( "count aya" );

        assertEquals( greetMap.countName( comm.getUser( ) ), 1 );
    }
    @Test
    public void countAll( ) throws SQLException {

        System.out.println( "\ngreet command test diff" );

        CommandExtractor comm = new CommandExtractor( "counter" );
        comm.getCommand( );
        assertEquals( greetMap.count( ), 1 );

    }
    @Test
    public void greeted( ) throws SQLException {

        System.out.println( "\nShould display names that have been greeted" );

        CommandExtractor comm = new CommandExtractor( "greeted" );
        comm.getCommand( );
    }
    @Test
    public void clearName( ) {

        System.out.println( "\nShould remove user" );

        CommandExtractor comm = new CommandExtractor( "clear aya" );

        assertEquals( greetMap.removeName( comm.getUser() ),"\naya was deleted from the Database" );

    }
}