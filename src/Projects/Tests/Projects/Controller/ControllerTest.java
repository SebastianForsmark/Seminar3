package Projects.Controller;

import Projects.Intergration.*;
import Projects.Model.Inspection;
import Projects.Model.InspectionChecklist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class ControllerTest {

    private DatabaseManager testDatabaseManager;
    private String regNo;
    private Inspection testInspection;
    private PaymentAuthorization paymentAuthorization;
    private SystemHandler systemHandler;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        testDatabaseManager = new DatabaseManager();
        regNo = "ABC123";
        paymentAuthorization = new PaymentAuthorization();
        systemHandler = new SystemHandler();
        CreditCard creditCard = new CreditCard(1234, "894583054", "John Smith", "2018/09", 231);
        double cost = 499.99;
        System.setOut(new PrintStream(outContent));
        Controller testController = new Controller();
    }

    @After
    public void tearDown() {
        testDatabaseManager = null;
        regNo = null;
        paymentAuthorization = null;
        systemHandler = null;
        testInspection = null;
    }

    @Test
    public void enterRegNoReturnsACost() {
        testInspection = createTestInspection();
        assertTrue("cost is below 0", testInspection.getCost() > 0);

    }

    @Test
    public void nonExistingRegNo() {
        regNo = "333PPP";
        testInspection = createTestInspection();
        assertTrue("Non existing regNo returns inspection", testInspection == null);
    }


    private Inspection createTestInspection() {
        try {
            InspectionChecklist testList = testDatabaseManager.findInspectionsByRegNo(regNo);
            return new Inspection(testList);
        }
        catch (RegNoNotFoundException e){
            return null;
        }
    }

}