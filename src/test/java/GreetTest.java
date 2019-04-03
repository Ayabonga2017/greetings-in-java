import net.greet.Greet;
import net.greet.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    @Test
    public void greetMe()
        {
            System.out.println ( "\nShould greet Minentle in Portugues :" );

            Greet greetMin = new Greet("Portuguese","MINENTLE");
            assertEquals (Language.enumInSwitch ( Language.LangType.Portuguese ) ,"OLÀ MINENTLE !" );
            greetMin.getName ();
            Greet greet = new Greet("Portuguese","Aya");

            Greet.nameS (greet.getName ());
            Greet.nameS ("Ayabnga");
            Greet.nameS ("Ayaboga");
            Greet.nameS ("Ayaboa");
            Greet.nameS ("Ayaboa");

            assertEquals (Language.enumInSwitch ( Language.LangType.Portuguese ) ,"OLÀ AYA !" );

            System.out.println ("\nCounter:\n" + Greet.count () );
        }
    }
