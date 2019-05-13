import net.greet.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExecutorTest {

   GreetWithDatabase greet = new GreetWithDatabase( );
   // GreetWithHashMap greet = new GreetWithHashMap( );
   CommandExecutor executor =new CommandExecutor ( greet );

    @BeforeEach
    public  void cleanMap(){
        greet.clearNames ();
    }
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

        greet.names("aya");
        greet.names("thabang");
        greet.names("aya");
        greet.names("ntando");
        greet.names("aya");
        greet.names("andre");

        CommandExtractor comm = new CommandExtractor( "count aya" );

        assertEquals ( "count" ,  comm.getCommand ());
        assertEquals ( "aya" ,  comm.getUser ());
        assertEquals( executor.execute (comm), "\naya was greeted 3 time(s)" );
    }

    @Test
    @DisplayName ( "counter command" )
    public void countAll( ) throws SQLException {

        greet.names("aya");
        greet.names("thabang");
        greet.names("ntando");
        greet.names("andre");

        CommandExtractor comm = new CommandExtractor( "counter" );

        assertEquals ( "counter" ,  comm.getCommand ());
        assertEquals( executor.execute (comm), "4" );
    }

    @Test
    @DisplayName ( "greeted command" )
    public void greeted( ) throws SQLException {

        greet.names("aya");
        greet.names("thabang");
        greet.names("ntando");
        greet.names("andre");

        CommandExtractor comm = new CommandExtractor( "greeted" );
        assertEquals ( "greeted" ,  comm.getCommand ());

        assertEquals( executor.execute (comm),"These users have been greeted: \n" +
                                              "\tandre has been greeted 1 time(s)\n" +
                                              "\taya has been greeted 1 time(s)\n" +
                                              "\tthabang has been greeted 1 time(s)\n" +
                                              "\tntando has been greeted 1 time(s)\n");
    }

    @Test
    @DisplayName ( "clear name command" )
    public void clearName( ) throws SQLException {

        greet.names("aya");
        greet.names("thabang");
        greet.names("ntando");
        greet.names("andre");

        CommandExtractor comm = new CommandExtractor( "clear thabang" );
        assertEquals ( "clear" ,  comm.getCommand ());
        assertEquals ( "thabang" ,  comm.getUser ());
        assertEquals( executor.execute (comm),"\nthabang was removed successfully!" );
    }

    @Test
    @DisplayName ( "\nhelp command" )
    public void help( ) throws SQLException {

        CommandExtractor comm = new CommandExtractor( "help" );
        assertEquals ( "help" ,  comm.getCommand ());

       assertEquals( executor.execute (comm),"\nValid Commands are as follow :\n" +
                                             "\n" +
                                             "- greet + name + language : will greet a person with a language of your choice.- greet + name : will greet a person with the default language.\n" +
                                             "- greeted : will display a list of greeted names. - count + name : will display how many times a person has been greeted.\n" +
                                             "- counter : will display the number of greeted names. - clear + name : will remove a persons name from the list and decrement the counter.\n" +
                                             "- clearall : will delete all the names on the list set the counter to 0.- exit : will exit the greeting application.\n" +
                                             "- help : will display all the possible commands to use when using this application." );
    }

}