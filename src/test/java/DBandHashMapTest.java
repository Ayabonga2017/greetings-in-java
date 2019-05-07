
import net.greet.GreetWithDatabase;
import net.greet.GreetWithHashMap;
import net.greet.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBandHashMapTest {

  // GreetWithHashMap greetMap = new GreetWithHashMap ();
    GreetWithDatabase greetMap = new GreetWithDatabase ();

    @BeforeEach
    public  void cleanMap(){
        greetMap.clearNames ();
         }
    @Test
    public void greetMe ( ){

        System.out.println ( "\nShould greet Minentle in French :" );

        String userName = "MINENHLE";
        greetMap.names ( userName );

        String language =Language.valueOf ( "french".toLowerCase () ).getValue ();
        assertEquals (language + userName, "bonjour MINENHLE" );

    }
    @Test
    public  void greetCounter() throws SQLException {

        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );
        greetMap.names ( "Asa" );

        assertEquals (6,greetMap.count ( ));
    }
    @Test
    public  void greetedNames() throws SQLException {

        greetMap.names ( "Min" );
        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );

        assertEquals (  greetMap.namesGreeted(),"greeted names" );
    }
    @Test
    public  void greetRemoveUserName() throws SQLException {
        System.out.println ( "\nShould remove a name from the list:\n" );
        greetMap.names ( "min" );
        greetMap.names ( "ainen" );
        greetMap.names ( "ayanda" );
        greetMap.names ( "ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "asa" );

        assertEquals ( greetMap.removeName ("asa"),"\nasa was removed successfully!");
    }
    @Test
    public  void greetClear(){
        System.out.println ( "\nShould clear all greeted names\n" );
        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );

        assertEquals ( greetMap.clearNames (),"deleted all users" );
    }

    @Test
    public  void countName(){
        System.out.println ( "\nShould count for a specific user\n" );
        greetMap.names ( "Min" );
        greetMap.names ( "asa" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );


        assertEquals ( greetMap.countName ( "asa" ),1 );
    }

}
