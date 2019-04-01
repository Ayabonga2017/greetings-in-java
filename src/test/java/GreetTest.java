import net.greet.Greeter;
import org.junit.jupiter.api.Test;

public class GreetTest {

    @Test
    public void testMe()
        {
            Greeter greetAya = new Greeter("Ayabonga");
            System.out.println(greetAya.greetMessage());

            Greeter jamesGreeter = new Greeter("james");
            System.out.println(jamesGreeter.greetMessage());
        }
    }
