import net.greet.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

   GreetWithDatabase greet = new GreetWithDatabase( );
   // GreetWithHashMap greet = new GreetWithHashMap( );
   CommandExecutor executor =new CommandExecutor ( greet );

    @Test
    @DisplayName ( "greet with language command" )
    public void commandWithLanguage( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "greet aya french" );
        assertEquals ( "greet" ,  comm.getCommand ());
        assertEquals ( "aya" ,  comm.getUser ());
        assertEquals ( "french" ,  comm.getLang ());
        assertEquals( executor.execute (comm), "\nbonjour aya" );
    }

    @Test
    @DisplayName ( "greet with default command" )
    public void commandWithDiff( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "greet thabang" );
        assertEquals ( "greet" ,  comm.getCommand ());
        assertEquals ( "thabang" ,  comm.getUser ());
        assertEquals ( "xhosa" ,  comm.getLang ());
        assertEquals( executor.execute (comm), "\nmholo thabang" );
    }

    @Test
    @DisplayName ( "count name command" )
    public void countNme( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "count yegan" );
        assertEquals ( "count" ,  comm.getCommand ());
        assertEquals ( "yegan" ,  comm.getUser ());
        assertEquals( executor.execute (comm), "0" );
    }

    @Test
    @DisplayName ( "counter command" )
    public void countAll( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "counter" );
        assertEquals ( "counter" ,  comm.getCommand ());
        assertEquals( executor.execute (comm), "4" );
    }

    @Test
    @DisplayName ( "greeted command" )
    public void greeted( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "greeted" );
        assertEquals ( "greeted" ,  comm.getCommand ());
        assertEquals( executor.execute (comm),"greeted names" );
    }

    @Test
    @DisplayName ( "clear name command" )
    public void clearName( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "clear aya" );
        assertEquals ( "clear" ,  comm.getCommand ());
        assertEquals ( "aya" ,  comm.getUser ());
        assertEquals( executor.execute (comm),"\naya was removed successfully!" );
    }

    @Test
    @DisplayName ( "\nhelp command" )
    public void help( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "help" );
        assertEquals ( "help" ,  comm.getCommand ());

       assertEquals( executor.execute (comm),"" );
    }

}