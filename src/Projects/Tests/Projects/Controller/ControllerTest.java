package Projects.Controller;

import Projects.Intergration.DatabaseManager;
import Projects.Model.Inspection;
import Projects.Model.InspectionChecklist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ControllerTest {

    private DatabaseManager testDatabaseManager;
    private String regNo;
    Inspection testInspection;

    @Before
    public void setUp()  {
        testDatabaseManager = new DatabaseManager();
        regNo = "123ABC";
    }

    @After
    public void tearDown()  {
    }

    @Test
    public void enterRegNoReturnsACost()  {
        InspectionChecklist testInspectionChecklist =  testDatabaseManager.FindInspectionsByRegNo(regNo);
        Inspection testInspection = new Inspection(testInspectionChecklist);
        assertTrue("cost is below 0",testInspection.getCost() > 0);

    }

    @Test
    public void enterRegNoDifferentString()  {
        regNo = "333PPP";
        InspectionChecklist testInspectionChecklist =  testDatabaseManager.FindInspectionsByRegNo(regNo);
        Inspection testInspection = new Inspection(testInspectionChecklist);
        assertTrue("cost is below 0 for string other than 123ABC",testInspection.getCost() > 0);

    }
}