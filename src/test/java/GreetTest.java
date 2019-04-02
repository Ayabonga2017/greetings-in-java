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

            System.out.println ( Language.enumInSwitch ( Language.LangType.Portuguese  ));
            assertEquals (Language.enumInSwitch ( Language.LangType.Portuguese ) ,"OLÀ MINENTLE !" );
            Greet.nameS (greetMin.getName ());

            Greet greet = new Greet("Portuguese","Aya");

            System.out.println ( Language.enumInSwitch ( Language.LangType.Portuguese  ));
            assertEquals (Language.enumInSwitch ( Language.LangType.Portuguese ) ,"OLÀ AYA !" );
            Greet.nameS (greet.getName ());

            Greet gret = new Greet("Portuguese","Aya");

            System.out.println ( Language.enumInSwitch ( Language.LangType.Portuguese  ));

            assertEquals (Language.enumInSwitch ( Language.LangType.Portuguese ) ,"OLÀ AYA !" );
            Greet.nameS ("Ayabnga");
            Greet.nameS ("Ayaboga");
            Greet.nameS ("Ayaboa");

            System.out.println ("\nCounter:\n" + Greet.count () );
        }
    }
