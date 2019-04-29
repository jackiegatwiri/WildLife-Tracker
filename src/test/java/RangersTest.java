import org.junit.Test;
import static org.junit.Assert.*;

public class RangersTest {
    @Test
    public void Rangers_instantiateCorrectly_true(){
        Rangers testRanger = new Rangers("Jackie", "Gatwiri", 1);
        assertTrue(testRanger instanceof Rangers);
    }
}
