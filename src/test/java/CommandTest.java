import net.greet.CommandExtractor;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import net.greet.GreetWithDatabase;
import net.greet.GreetWithHashMap;

public class CommandTest {

   GreetWithDatabase greetMap = new GreetWithDatabase( );
   // GreetWithHashMap greetMap = new GreetWithHashMap( );

    @Test
    public void commandWithLanguage( ) {

        System.out.println( "\ngreet in French" );

        CommandExtractor comm = new CommandExtractor( "greet aya french" );

        assertEquals( comm.getLang( ) + comm.getUser( ), "bonjour aya" );

    }
    @Test
    public void commandWithDiff( ) {

        System.out.println( "\ngreet in default" );

        CommandExtractor comm = new CommandExtractor( "greet thabang" );

        assertEquals( comm.getLang( ) + comm.getUser( ), "mholo thabang" );

    }
    @Test
    public void countNme( ) {

        System.out.println( "\ncount name command" );

        CommandExtractor comm = new CommandExtractor( "count ntando" );

        assertEquals( greetMap.countName( comm.getUser( ) ), 3 );
    }
    @Test
    public void countAll( ) throws SQLException {

        System.out.println( "\ncount all command" );

        CommandExtractor comm = new CommandExtractor( "counter" );
        comm.getCommand( );
        assertEquals( greetMap.count( ), 2 );

    }
    @Test
    public void greeted( ) throws SQLException {

        System.out.println( "\nShould display names that have been greeted" );

        CommandExtractor comm = new CommandExtractor( "greeted" );
        comm.getCommand( );

       // assertEquals ( greetMap.namesGreeted (),);
    }
    @Test
    public void clearName( ) {

        System.out.println( "\nremove user command" );

        CommandExtractor comm = new CommandExtractor( "clear aya" );

        assertEquals( greetMap.removeName( comm.getUser() ),"\naya was deleted from the Database" );

    }
    @Test
    public void help( ) throws SQLException {

        System.out.println( "\nhelp command" );

        CommandExtractor comm = new CommandExtractor( "help" );
        comm.getCommand ();
       // assertEquals( greetMap.removeName( comm.getUser() ),"\naya was deleted from the Database" );

    }

}