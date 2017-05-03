package Projects.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InspectionChecklistTest {
    private InspectionDTO[] arrayOfDTOs = new InspectionDTO[2];
    private InspectionDTO comparisonTarget;
    private InspectionChecklist testCheckList;
    private final InspectionDTO first = new InspectionDTO("same", 1, false, "same");
    private final InspectionDTO second = new InspectionDTO("same", 1, false, "same");


    @Before
    public void setUp() {
        arrayOfDTOs = new InspectionDTO[2];
        testCheckList = new InspectionChecklist(arrayOfDTOs);

    }

    @After
    public void tearDown() {
        testCheckList = null;
    }

    @Test
    public void updateDTOWhenNotMember() {
        comparisonTarget = new InspectionDTO("Steering wheel", 23, false, "123ABC"); // Different from the other 2 DTOs
        arrayOfDTOs[0] = first;
        arrayOfDTOs[1] = second;
        testCheckList.updateInspectionDTO(true, comparisonTarget);
        int x = testCheckList.identifyArrayIndex(comparisonTarget);
        assertEquals("Returns incorrect index", x, -1);
    }

    /**
     *   Attempts to intentionally cause a null pointer exception.
     */
    @Test(expected = NullPointerException.class)
    public void inspectionArrayEmpty() {

        int x = testCheckList.identifyArrayIndex(comparisonTarget);
    }

    @Test
    public void inspectionDTOOccursTwice() {
        //Should return the first match
        comparisonTarget = second; //Same as the first DTO
        arrayOfDTOs[0] = first;
        arrayOfDTOs[1] = second;
        int x = testCheckList.identifyArrayIndex(comparisonTarget);
        assertEquals("Returns incorrect index", x, 0);
    }


}