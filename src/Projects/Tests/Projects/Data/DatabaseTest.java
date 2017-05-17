package Projects.Data;

import Projects.Intergration.RegNoNotFoundException;
import Projects.Model.InspectionChecklist;
import Projects.Model.InspectionDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DatabaseTest {
    private Database testDatabase = new Database();
    private InspectionDTO randomInspectionDTO;
    private double cost;
    private String generatedPart;
    private boolean isPassed;


    @Before
    public void setUp() {
        randomInspectionDTO = testDatabase.randomInspectionDTO("ABC123");
        cost = randomInspectionDTO.getCost();
        generatedPart = randomInspectionDTO.getPartToInspect();
        isPassed = randomInspectionDTO.getPassed();
    }

    @After
    public void tearDown() {
        randomInspectionDTO = null;
    }

    @Test
    public void inspectionGeneratedFalse() {
        assertEquals("Inspection is generated passed", isPassed, false);
    }

    @Test
    public void stringGeneratedCorrectly() {
        assertEquals("String not from list of parts", true, testDatabase.memberOfArray(testDatabase.possibleParts, generatedPart));
    }

    @Test
    public void costWithinBounds() {
        assertTrue("Cost outside of accepted parameters", cost < 1000 && cost > 0);
    }


    @Test(expected = RegNoNotFoundException.class)
    public void regNoExceptionTest() throws RegNoNotFoundException {
        String incorrectRegNo = "000000";
        try {
            testDatabase.fetchInspectionsByRegNo(incorrectRegNo);
        }
        catch(IllegalArgumentException e){
            fail();
        }
        }
}