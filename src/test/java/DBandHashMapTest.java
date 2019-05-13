
import net.greet.GreetWithDatabase;
import net.greet.GreetWithHashMap;
import net.greet.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBandHashMapTest {

  // GreetWithHashMap greetMap = new GreetWithHashMap ();
    GreetWithDatabase greetMap = new GreetWithDatabase ();

    @BeforeEach
    public  void cleanMap(){
        greetMap.clearNames ();
         }
    @Test
    public void greetMe ( ){

        String userName = "MINENHLE";
        greetMap.names ( userName );

        String language =Language.valueOf ( "french".toLowerCase () ).getValue ();
        assertEquals (language + userName, "bonjour MINENHLE" );

    }
    @Test
    public  void greetCounter() throws SQLException {

        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );
        greetMap.names ( "Asa" );

        assertEquals (6,greetMap.count ( ));
    }
    @Test
    public  void greetedNames() throws SQLException {

        greetMap.names ( "Min" );
        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );

        assertEquals (  greetMap.namesGreeted().toString(),"{min=2, ama=1, lllll=1, minen=1, ayanda=1, asa=1}" );

    }
    @Test
    public  void greetRemoveUserName() {

        greetMap.names ( "min" );
        greetMap.names ( "ainen" );
        greetMap.names ( "ayanda" );
        greetMap.names ( "ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "asa" );

        assertEquals ( greetMap.removeName ("asa"),"\nasa was removed successfully!");
    }
    @Test
    public  void greetClear(){

        greetMap.names ( "Min" );
        greetMap.names ( "Minen" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );
        greetMap.names ( "Asa" );

        assertEquals ( greetMap.clearNames (),"deleted all users" );
    }
    @Test
    public  void countName() throws SQLException {

        greetMap.names ( "Min" );
        greetMap.names ( "asa" );
        greetMap.names ( "Ayanda" );
        greetMap.names ( "Ama" );
        greetMap.names ( "lllll" );

        assertEquals ( greetMap.countName ( "asa" ),1 );
    }

}
