import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Animals_intantiatesCorrectly_true(){
        Animals testAnimal = new Animals("Rhino");
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void Animals_instantiatesWithName_String() {
        Animals testAnimal = new Animals("Bubbles");
        assertEquals("Bubbles", testAnimal.getName());
    }
}
