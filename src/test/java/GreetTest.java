import net.greet.Greet;
import net.greet.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void greetMe ( ) {
        System.out.println ( "\nShould greet Minentle in Portugues :" );
        Greet greetMin = new Greet ( "Portuguese" , "MINENTLE" );

        assertEquals ( Language.langInSwitch ( Language.LangType.Portuguese ) , "OLÀ MINENTLE !" );

        System.out.println ( "\nShould greet Aya in French :" );
        Greet greetAya = new Greet ( "French" , "Aya" );

        assertEquals ( Language.langInSwitch ( Language.LangType.French ) , "BONJOUR AYA !" );

        System.out.println ( "\nShould greet ZEE in default Language :" );
        Greet greet = new Greet ( "" , "Aya" );

        assertEquals (Language.langInSwitch (Language.LangType.English), "Hey AYA ! " );
    }

    @Test
    public  void greetCounter(){

        Greet.nameS ( "Min" );
        Greet.nameS ( "Minen" );
        Greet.nameS ( "Ayanda" );
        Greet.nameS ( "Ama" );
        Greet.nameS ( "lllll" );
        Greet.nameS ( "Asa" );
        System.out.println ( "\nShould return 6 for the Counter:\n" + Greet.count ( ) );

    }

    @Test
    public  void greetedNames(){
        Greet greetAya = new Greet ( "French" , "Aya" );

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
