import net.greet.CommandExtracor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    public void command(){

        System.out.println ("\ngreet command test" );

        CommandExtracor comm =new CommandExtracor ("greet","aya","english" );
        assertEquals (comm.getCommand () ,"greet" );
    }
}
