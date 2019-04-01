import net.greet.Greeter;
import org.junit.jupiter.api.Test;

public class GreetTest {

    @Test
    public void greetMe()
        {
            Greeter greetAya = new Greeter("IsiXhosa","Ayabonga");
            System.out.println(greetAya.greetMessage());

            Greeter ayaGreeter = new Greeter("English","Aya");
            Greeter zeeGreeter = new Greeter("Portuguese","Ziyanda");

            System.out.println(ayaGreeter.greetMessage());
            System.out.println(zeeGreeter.greetMessage());

            Greeter.greeted ();
            Greeter.countUser ();
        }
    }
