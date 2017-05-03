package Projects.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InspectionChecklistTest {
    private InspectionDTO[] arrayOfDTOs = new InspectionDTO[2];
    private final InspectionDTO comparisonTarget = new InspectionDTO("Steering wheel",23,false,"123ABC"); // Vehicle for testing.
    private InspectionChecklist testCheckList;

    @Before
    public void setUp()   {
        testCheckList = new InspectionChecklist(arrayOfDTOs);
    }

    @After
    public void tearDown()   {
        arrayOfDTOs = null;
        testCheckList = null;
    }

    @Test(expected = NullPointerException.class)
    public void inspectionArrayEmpty()   {
    int x = testCheckList.identifyArrayIndex(comparisonTarget);
    }

    @Test
    public void inspectionDTOOccursTwice()   {
        InspectionDTO first = new InspectionDTO("same",1,false,"same");
        InspectionDTO second = new InspectionDTO("same",1,false,"same");
        arrayOfDTOs[0]=first;
        arrayOfDTOs[1]=second;
        int x = testCheckList.identifyArrayIndex(comparisonTarget);
        assertEquals("Still returns index",x,-1);
    }

    @Test
    public void updateDTOWhenNotMember()   {
        InspectionDTO first = new InspectionDTO("same",1,false,"same");
        InspectionDTO second = new InspectionDTO("same",1,false,"same");
        arrayOfDTOs[0]=first;
        arrayOfDTOs[1]=second;
        testCheckList.updateInspectionDTO(true,comparisonTarget);
        int x = testCheckList.identifyArrayIndex(comparisonTarget);
        assertEquals("Returns incorrect index",x,-1);
    }

}