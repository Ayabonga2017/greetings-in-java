
import net.greet.CommandExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    public void command(){

        System.out.println ("\ngreet command test" );

        CommandExtractor comm =new CommandExtractor ("greet aya english");

        assertEquals (comm.getLang ()+comm.getUser() ,"hey aya" );

    }
    @Test
    public void commandWithFrench(){

        System.out.println ("\ngreet command test French" );

        CommandExtractor comm =new CommandExtractor ("greet aya french");

        assertEquals (comm.getLang ()+ comm.getUser() ,"bonjour aya" );

    }
    @Test
    public void commandWithDiff(){

        System.out.println ("\ngreet command test diff" );

        CommandExtractor comm =new CommandExtractor ("greet aya");

        assertEquals (  comm.getLang ()+ comm.getUser() ,"mholo aya" );

    }
}
