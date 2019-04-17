
import net.greet.GreetWithHashMap;
import net.greet.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    GreetWithHashMap greetMap = new GreetWithHashMap ();

    @BeforeEach
    public  void cleanMap(){
        greetMap.clearNames (); }
    @Test
    public void greetMe ( ){

        System.out.println ( "\nShould greet Minentle in French :" );

        String userName = "MINENHLE";
        greetMap.names ( userName );
        String language =Language.valueOf ( "french".toLowerCase () ).getValue ();

        assertEquals (language + userName, "BONJOUR MINENHLE" );

        System.out.println ( "\nShould greet AYA in English :" );

        String name = "AYA";
        greetMap.names ( name );
        String languageType =Language.valueOf ( "english".toLowerCase () ).getValue ();

        assertEquals ( languageType + name , "HEY AYA" );

    }
    @Test
    public  void greetCounter(){

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
    public  void greetedNames(){

        greetMap.names ( "Min" );
        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );
        System.out.println ( "\nShould return the list of names on the map :\n" );
        greetMap.namesGreeted();
    }
    @Test
    public  void greetRemoveUserName(){
        System.out.println ( "\nShould remove a name  and decrement the counter:\n" );
        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );
        greetMap.namesGreeted();
        greetMap.removeName ("ASA");
        greetMap.namesGreeted();
        assertEquals ( 5,greetMap.count ());
    }
    @Test
    public  void greetClear(){
        System.out.println ( "\nList should be empty and counter be 0:\n" );
        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );
        greetMap.clearNames ();

        assertEquals ( 0,greetMap.count () );
    }

}
