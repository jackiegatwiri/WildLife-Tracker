import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Sighting_intantiatesCorrectly_true(){
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        assertEquals(true, testSighting instanceof Sighting);
    }
    @Test
    public void Sighting_instantiatesWithAnimalId_String() {
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        assertEquals(1, testSighting.getAnimalId());
    }
    @Test
    public void Sighting_instantiatesWithLocation_String() {
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        assertEquals("kenya", testSighting.getLocation());
    }
    @Test
    public void Sighting_instantiatesWithRangerNAme_String() {
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        assertEquals("mark", testSighting.getRangerName());
    }
    @Test
    public void equals_returnsTrueIfTheNamesAreEqual_true(){
        Sighting firstSighting = new Sighting(1, "kenya", "mark");
        Sighting secondSighting = new Sighting(1, "kenya", "mark");
        assertTrue(firstSighting.equals(secondSighting));
    }
    @Test
    public void save_saveInstanceToTheDatabase(){
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        testSighting.save();
        assertEquals(true, Sighting.allSighting().get(0).equals(testSighting));
    }
    @Test
    public void save_assignsIdToAnimals() {
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        testSighting.save();
        Sighting savedSighting = Sighting.allSighting().get(0);
        assertEquals(savedSighting.getId(), testSighting.getId());
    }
    @Test
    public void all_returnsAllInstancesOfAnimals_true() {
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        testSighting.save();
        Sighting testSighting2 = new Sighting(1, "kenya", "mark");
        testSighting2.save();
        assertEquals(true, Sighting.allSighting().get(0).equals(testSighting));
        assertEquals(true, Sighting.allSighting().get(1).equals(testSighting2));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Sighting testSighting = new Sighting(1, "kenya", "mark");
        testSighting.save();
        Sighting testSighting2 = new Sighting(1, "kenya", "mark");
        testSighting2.save();
        assertEquals(Sighting.find(testSighting.getId()), testSighting);
    }


}
