import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class RangersTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Rangers_instantiateCorrectly_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", 1);
        assertTrue(testRanger instanceof Rangers);
    }

    @Test
    public void Rangers_instantiateWithgetFirstName_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", 1);
        assertEquals("Jackie", testRanger.getFirstName());
    }

    @Test
    public void Rangers_instantiateWithgetSecondName_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", 1);
        assertEquals("Gatwiri", testRanger.getSecondName());
    }

    @Test
    public void Rangers_instantiateWithBadgeNo_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", 1);
        assertEquals(1, testRanger.getBadgeNo());
    }
    @Test
    public void equals_retursTrueNamesAndBadgeNumberAreTheSame_true(){
        Rangers rangerOne = new Rangers("Jackie", "Gatwiri", 1);
        Rangers rangerTwo = new Rangers("Jackie", "Gatwiri", 1);
        assertTrue(rangerOne.equals(rangerTwo));
    }
    @Test
    public void save_insertObjectIntoTheDatabase_Rangers(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", 1);
        testRanger.save();
        assertTrue(Rangers.all().get(0).equals(testRanger));
    }


}
