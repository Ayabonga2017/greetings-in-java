import net.greet.*;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CommandTest {

   GreetWithDatabase greet = new GreetWithDatabase( );
   // GreetWithHashMap greet = new GreetWithHashMap( );
   CommandExecutor executor =new CommandExecutor ( greet );

   // Greet mocked = mock ( Greet.class, "");

    @Test
    public void commandWithLanguage( ) throws SQLException {

        System.out.println( "\ngreet in French" );

        CommandExtractor comm = new CommandExtractor( "greet aya french" );
        assertEquals( executor.execute (comm), "\nbonjour aya" );
    }
    @Test
    public void commandWithDiff( ) throws SQLException {

        System.out.println( "\ngreet in default" );

        CommandExtractor comm = new CommandExtractor( "greet thabang" );

        assertEquals( executor.execute (comm), "\nmholo thabang" );

    }
    @Test
    public void countNme( ) throws SQLException {

        System.out.println( "\ncount name command" );

        CommandExtractor comm = new CommandExtractor( "count ayanda" );
        assertEquals( executor.execute (comm), "1" );
    }
    @Test
    public void countAll( ) throws SQLException {

        System.out.println( "\ncount all command" );

        CommandExtractor comm = new CommandExtractor( "counter" );
        assertEquals( executor.execute (comm), "6" );

    }
    @Test
    public void greeted( ) throws SQLException {

        System.out.println( "\nShould display names that have been greeted" );

        CommandExtractor comm = new CommandExtractor( "greeted" );
        assertEquals( executor.execute (comm),"greeted names" );

    }
    @Test
    public void clearName( ) throws SQLException {

        System.out.println( "\nremove user command" );

        CommandExtractor comm = new CommandExtractor( "clear aya" );
        assertEquals( executor.execute (comm),"\naya was removed successfully!" );

    }
    @Test
    public void help( ) throws SQLException {

        System.out.println( "\nhelp command" );

        CommandExtractor comm = new CommandExtractor( "help" );
       assertEquals( executor.execute (comm),"" );

    }
//    @Test
//    public void exit( ) throws SQLException {
//
//        System.out.println( "\nexit command" );
//
//        CommandExtractor comm = new CommandExtractor( "exit" );
//        assertEquals( executor.execute (comm),"Good-Bye" );
//
//    }

}