import net.greet.Greet;
import net.greet.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void greetMe ( ) {

        System.out.println ( "\nShould greet Minentle in French :" );
        Greet greetMin = new Greet ( "French" , "MINENTLE" );
        assertEquals (Language.valueOf ( "FrEncH".toLowerCase () ).getGreet ( "MINENHLE" ), "BONJOUR MINENTLE" );

        System.out.println ( "\nShould greet AYA in English :" );
        Greet gree = new Greet ( "French" , "Aya" );
        assertEquals (Language.valueOf ( "enGlisH".toLowerCase () ).getGreet ( "aya" ), "HEY AYA" );

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
        System.out.println ( "\nShould return 6 for the Counter:\n" + Greet.count ( ) );

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
    public  void greetRemove(){
        System.out.println ( "\nShould return a list of names and counter be 5:\n" );
        Greet.nameS ( "Min" );
        Greet.nameS ( "Minen" );
        Greet.nameS ( "Ayanda" );
        Greet.nameS ( "Ama" );
        Greet.nameS ( "lllll" );
        Greet.nameS ( "Asa" );
        Greet.removeName ();
        Greet.namesGreeted();
        System.out.println ( "\nCounter:\n" + Greet.count () );
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
        Greet.namesGreeted();

        System.out.println ( "\nCounter:\n" + Greet.count () );
    }
}
