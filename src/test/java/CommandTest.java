import net.greet.CommandExecutor;
import net.greet.CommandExtractor;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import net.greet.GreetWithDatabase;
import net.greet.GreetWithHashMap;
//import static org.mockito.Mockito.*;

public class CommandTest {

   GreetWithDatabase greetMap = new GreetWithDatabase( );
   // GreetWithHashMap greetMap = new GreetWithHashMap( );

   // CommandExecutor mocked = mock ( CommandExecutor.class, "");

    @Test
    public void commandWithLanguage( ) throws SQLException {

        System.out.println( "\ngreet in French" );

        CommandExtractor comm = new CommandExtractor( "greet aya french" );
        CommandExecutor execute =new CommandExecutor ( comm );
        execute.mainMethod ();

        assertEquals( comm.getLang( ) + comm.getUser( ), "bonjour aya" );
    }
    @Test
    public void commandWithDiff( ) {

        System.out.println( "\ngreet in default" );

        CommandExtractor comm = new CommandExtractor( "greet thabang" );

        assertEquals( comm.getLang( ) + comm.getUser( ), "mholo thabang" );

    }
    @Test
    public void countNme( ) throws SQLException {

        System.out.println( "\ncount name command" );

        CommandExtractor comm = new CommandExtractor( "count lunga" );
        CommandExecutor execute =new CommandExecutor ( comm );
        execute.mainMethod ();

        assertEquals( greetMap.countName( comm.getUser( ) ), 3 );
    }
    @Test
    public void countAll( ) throws SQLException {

        System.out.println( "\ncount all command" );

        CommandExtractor comm = new CommandExtractor( "counter" );
        CommandExecutor execute =new CommandExecutor ( comm );
        execute.mainMethod ();

        assertEquals( greetMap.count( ), 3 );

    }
    @Test
    public void greeted( ) throws SQLException {

        System.out.println( "\nShould display names that have been greeted" );

        CommandExtractor comm = new CommandExtractor( "greeted" );
        CommandExecutor execute =new CommandExecutor ( comm );
        execute.mainMethod ();

    }
    @Test
    public void clearName( ) throws SQLException {

        System.out.println( "\nremove user command" );

        CommandExtractor comm = new CommandExtractor( "clear aya" );
        CommandExecutor execute =new CommandExecutor ( comm );
        execute.mainMethod ();

        assertEquals( greetMap.removeName( comm.getUser() ),"\naya was deleted from the Database" );
    }
    @Test
    public void help( ) throws SQLException {

        System.out.println( "\nhelp command" );

        CommandExtractor comm = new CommandExtractor( "help" );
        CommandExecutor execute =new CommandExecutor ( comm );
        execute.mainMethod ();



    }

}