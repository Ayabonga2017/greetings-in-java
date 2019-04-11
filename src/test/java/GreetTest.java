import net.greet.Greet;
import net.greet.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void greetMe ( ){

        System.out.println ( "\nShould greet Minentle in French :" );

        String userName = "MINENHLE";
        Greet.nameS ( userName );
        String language =Language.valueOf ( "french".toLowerCase () ).getValue ();
        assertEquals (language + userName, "BONJOUR MINENHLE" );

        System.out.println ( "\nShould greet AYA in English :" );

        String name = "AYA";
        Greet.nameS ( name );
        String languageType =Language.valueOf ( "english".toLowerCase () ).getValue ();

        assertEquals ( languageType + name , "HEY AYA" );

    }

    @Test
    public  void greetCounter(){

        Greet.nameS ( "Min" );
        Greet.nameS ( "Minen" );
        Greet.nameS ( "Ayanda" );
        Greet.nameS ( "Ama" );
        Greet.nameS ( "lllll" );
        Greet.nameS ( "Asa" );
        Greet.nameS ( "Asa" );

        assertEquals (6,Greet.count ( ));
    }

    @Test
    public  void greetedNames(){

        Greet.nameS ( "Min" );
        Greet.nameS ( "Min" );
        Greet.nameS ( "Minen" );
        Greet.nameS ( "Ayanda" );
        Greet.nameS ( "Ama" );
        Greet.nameS ( "lllll" );
        Greet.nameS ( "Asa" );
        System.out.println ( "\nShould return the list of names on the map :\n" );
        Greet.namesGreeted();
    }

    @Test
    public  void greetRemoveUserName(){
        System.out.println ( "\nShould remove a name  and decrement the counter:\n" );
        Greet.nameS ( "Min" );
        Greet.nameS ( "Minen" );
        Greet.nameS ( "Ayanda" );
        Greet.nameS ( "Ama" );
        Greet.nameS ( "lllll" );
        Greet.nameS ( "Asa" );
        Greet.namesGreeted();
        Greet.removeName ("ASA");
        Greet.namesGreeted();
        assertEquals ( 5,Greet.count ());
    }

    @Test
    public  void greetClear(){
        System.out.println ( "\nList should be empty and counter be 0:\n" );
        Greet.nameS ( "Min" );
        Greet.nameS ( "Minen" );
        Greet.nameS ( "Ayanda" );
        Greet.nameS ( "Ama" );
        Greet.nameS ( "lllll" );
        Greet.nameS ( "Asa" );
        Greet.clearNames ();

        assertEquals ( 0,Greet.count () );
    }

}
