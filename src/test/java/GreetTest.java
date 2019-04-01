import net.greet.Greet;
import org.junit.jupiter.api.Test;

public class GreetTest {

    @Test
    public void greetMe()
        {
            Greet greetMin = new Greet("Portuguese","Minentle");
            System.out.println(greetMin.greetMessage());

            Greet greetAya = new Greet("IsiXhosa"," Ayabonga");
            System.out.println(greetAya.greetMessage());

            System.out.println(Greet.name () + " was greeted in "+ Greet.lang () );

            System.out.println ("Counter:\n" + Greet.count () );
        }
    }
