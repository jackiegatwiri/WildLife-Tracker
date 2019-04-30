import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Animals_intantiatesCorrectly_true(){
        EndangeredAnimals  testAnimal = new EndangeredAnimals ("Rhino" ,"okay", "20" );
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void Animals_instantiatesWithName_String() {
        EndangeredAnimals  testAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        assertEquals("Bubbles", testAnimal.getName());
    }
    @Test
    public void Animals_instantiatesWithHealth_String() {
        EndangeredAnimals  testAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        assertEquals("okay", testAnimal.getHealth());
    }
    @Test
    public void Animals_instantiatesWithAge_String() {
        EndangeredAnimals  testAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        assertEquals("20", testAnimal.getAge());
    }
    @Test
    public void equals_returnsTrueIfTheNamesAreEqual_true(){
        EndangeredAnimals  firstAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        EndangeredAnimals  secondAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        assertTrue(firstAnimal.equals(secondAnimal));
    }
    @Test
    public void save_saveInstanceToTheDatabase(){
        EndangeredAnimals firstAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        firstAnimal.save();
        assertEquals(true, EndangeredAnimals .allEndangeredAnimals().get(0).equals(firstAnimal));
    }
    @Test
    public void save_assignsIdToAnimals() {
        EndangeredAnimals  testAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        testAnimal.save();
        EndangeredAnimals  savedAnimal = EndangeredAnimals .allEndangeredAnimals().get(0);
        assertEquals(savedAnimal.getId(), testAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfAnimals_true() {
        EndangeredAnimals  firstAnimal = new EndangeredAnimals ("Bubbles" ,"okay", "20" );
        firstAnimal.save();
        EndangeredAnimals  secondAnimal = new EndangeredAnimals ("Spud" ,"okay", "20" );
        secondAnimal.save();
        assertEquals(true, EndangeredAnimals .allEndangeredAnimals().get(0).equals(firstAnimal));
        assertEquals(true, EndangeredAnimals .allEndangeredAnimals().get(1).equals(secondAnimal));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        EndangeredAnimals  firstAnimal = new EndangeredAnimals("Bubbles", "okay", "20" );
        firstAnimal.save();
        EndangeredAnimals  secondAnimal = new EndangeredAnimals("Spud", "okay", "20" );
        secondAnimal.save();
        assertEquals(EndangeredAnimals.find(secondAnimal.getId()), secondAnimal);
    }
    @Test
    public void getsType_Endangered() {
        assertEquals("Endangered", EndangeredAnimals.getTYPE());
    }

}
