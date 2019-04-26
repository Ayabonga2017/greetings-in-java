
import net.greet.CommandExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    public void command(){

        System.out.println ("\ngreet command test" );

        CommandExtractor comm =new CommandExtractor ("greet");


        assertEquals (comm.getCommand () +comm.getLang ()+comm.getUser() ,"greet aya english" );

    }
}
