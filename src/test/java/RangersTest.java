import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class RangersTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void Rangers_instantiateCorrectly_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", "1");
        assertTrue(testRanger instanceof Rangers);
    }

    @Test
    public void Rangers_instantiateWithgetFirstName_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", "1");
        assertEquals("Jackie", testRanger.getFirstName());
    }

    @Test
    public void Rangers_instantiateWithgetSecondName_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", "1");
        assertEquals("Gatwiri", testRanger.getSecondName());
    }

    @Test
    public void Rangers_instantiateWithBadgeNo_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", "1");
        assertEquals("1", testRanger.getBadgeNo());
    }
    @Test
    public void equals_retursTrueNamesAndBadgeNumberAreTheSame_true(){
        Rangers rangerOne = new Rangers("Jackie", "Gatwiri", "1");
        Rangers rangerTwo = new Rangers("Jackie", "Gatwiri", "1");
        assertTrue(rangerOne.equals(rangerTwo));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Ranger() {
        Rangers testPerson = new Rangers("Jackie", "Gatwiri", "1");
        testPerson.save();
        assertEquals(true, Rangers.all().get(0).equals(testPerson));
    }

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Rangers firstPerson = new Rangers("Jackie", "Gatwiri", "1");
        firstPerson.save();
        Rangers secondPerson = new Rangers("Jackie", "Gatwiri","2");
        secondPerson.save();
        assertEquals(true, Rangers.all().get(0).equals(firstPerson));
        assertEquals(true, Rangers.all().get(1).equals(secondPerson));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Rangers firstPerson = new Rangers("Jackie", "Gatwiri", "1");
        firstPerson.save();
        Rangers secondPerson = new Rangers("Jill", "Bates","2");
        secondPerson.save();
        assertEquals(Rangers.find(secondPerson.getId()), secondPerson);
    }
}
