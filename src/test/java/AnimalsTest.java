import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
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
    @Test
    public void equals_returnsTrueIfTheNamesAreEqual_true(){
        Animals firstAnimal = new Animals("Bubbles");
        Animals secondAnimal = new Animals("Bubbles");
        assertTrue(firstAnimal.equals(secondAnimal));
    }
    @Test
    public void save_saveInstanceToTheDatabase(){
        Animals firstAnimal = new Animals("Bubbles");
        firstAnimal.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimal));
    }
    @Test
    public void save_assignsIdToAnimals() {
        Animals testAnimal = new Animals("Bubbles");
        testAnimal.save();
        Animals savedAnimal = Animals.all().get(0);
        assertEquals(savedAnimal.getId(), testAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfAnimals_true() {
        Animals firstAnimal = new Animals("Bubbles");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Spud");
        secondAnimal.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimal));
        assertEquals(true, Animals.all().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animals firstAnimal = new Animals("Bubbles");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Spud");
        secondAnimal.save();
        assertEquals(Animals.find(secondAnimal.getId()), secondAnimal);
    }
    @Test
    public void getsType_Not_Endangered() {
        assertEquals("Not Endangered", Animals.getTYPE());
    }

}
