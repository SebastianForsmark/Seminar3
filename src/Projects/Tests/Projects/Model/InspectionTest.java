package Projects.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InspectionTest {
    private Inspection testInspection;


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        testInspection = null;
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void fetchNonExistentInspection() {
        testInspection = createTestInspection(13); //Length is 2
        testInspection.fetchNextInspection();
        testInspection.fetchNextInspection();
        testInspection.fetchNextInspection();

    }

    @Test
    public void calculateCost() {
        testInspection = createTestInspection(1);
        assertTrue("Cost calculated incorrectly", testInspection.calculateCost() == 2);
    }

    @Test
    public void calculateCostIfZero() {
        testInspection = createTestInspection(0);
        assertTrue("Sum of costs not calculated correctly when costs are 0", testInspection.calculateCost() == 0);
    }

    private Inspection createTestInspection(double cost) {
        InspectionDTO testInspectionOne = new InspectionDTO("Steering wheel", cost, false, "123ABC");
        InspectionDTO testInspectionTwo = new InspectionDTO("Steering wheel", cost, false, "123ABC");
        InspectionDTO[] arrayOfDTOs = {testInspectionOne, testInspectionTwo};
        InspectionChecklist testCheckList = new InspectionChecklist(arrayOfDTOs);
        return testInspection = new Inspection(testCheckList);
    }

}