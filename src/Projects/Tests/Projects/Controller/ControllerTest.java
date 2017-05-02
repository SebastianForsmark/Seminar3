package Projects.Controller;

import Projects.Intergration.CreditCard;
import Projects.Intergration.DatabaseManager;
import Projects.Intergration.PaymentAuthorization;
import Projects.Intergration.SystemHandler;
import Projects.Model.Inspection;
import Projects.Model.InspectionChecklist;
import Projects.Model.Receipt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.YearMonth;

import static org.junit.Assert.*;


public class ControllerTest {

    private DatabaseManager testDatabaseManager;
    private String regNo;
    private Inspection testInspection;
    private PaymentAuthorization paymentAuthorization;
    private SystemHandler systemHandler;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private CreditCard creditCard;
    private double cost;
    private Controller testController;

    @Before
    public void setUp() {
        testDatabaseManager = new DatabaseManager();
        regNo = "123ABC";
        paymentAuthorization = new PaymentAuthorization();
        systemHandler = new SystemHandler();
        creditCard = new CreditCard(1234,"894583054","John Smith","2018/09",231);
        cost = 499.99;
        System.setOut(new PrintStream(outContent));
        testController = new Controller();
    }

    @After
    public void tearDown()  {
        testDatabaseManager = null;
        regNo = null;
        paymentAuthorization = null;
        systemHandler = null;
        testInspection = null;
    }

    @Test
    public void enterRegNoReturnsACost()  {
        testInspection = createTestInspection();
        assertTrue("cost is below 0",testInspection.getCost() > 0);

    }

    @Test
    public void enterRegNoDifferentString()  {
        regNo = "333PPP";
        testInspection = createTestInspection();
        assertTrue("cost is below 0 for string other than 123ABC",testInspection.getCost() > 0);
    }

    @Test
    public void paymentRegistersAndPrints() {
            testController.registerPayment(creditCard,  cost);
            assertEquals("Receipt not printed", "Receipt has been printed!\r\n", outContent.toString());
    }

    private Inspection createTestInspection(){
        InspectionChecklist testList =  testDatabaseManager.FindInspectionsByRegNo(regNo);
        return new Inspection(testList);
    }
}