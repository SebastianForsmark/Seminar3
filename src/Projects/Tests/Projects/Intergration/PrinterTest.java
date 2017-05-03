package Projects.Intergration;

import Projects.Model.InspectionChecklist;
import Projects.Model.InspectionDTO;
import Projects.Model.Receipt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrinterTest {

    private Printer testPrinter = new Printer();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Receipt newReceipt;

    @Before
    public void setUp() {
        newReceipt = createReceipt();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        newReceipt = null;
    }

    @Test
    public void printReceipt() {
        testPrinter.printReceipt(newReceipt);
        assertEquals("Prints receipt incorrectly.","Receipt has been printed!\r\nPayment was approved: true\r\nAmount paid: 5\r\n", outContent.toString());
    }

    @Test
    public void printInspectionResult() {
        InspectionDTO[] testInspections = new InspectionDTO[2];
        InspectionChecklist testInspectionChecklist = createInspectionResult();
        testPrinter.printInspectionResult(testInspectionChecklist);
        assertEquals("Prints inspections results incorrectly.","*-----------------*\r\nPart: Right tire\r\nResult: Failed!\r\n*-----------------*\r\nPart: Spoiler\r\nResult: Failed!\r\n*-----------------*\r\n", outContent.toString());
    }

    private Receipt createReceipt() {
        double cost = 5;
        return new Receipt(cost, true);
    }
    private InspectionChecklist createInspectionResult(){
        InspectionDTO first = new InspectionDTO("Right tire",113,false,"AAA111");
        InspectionDTO second = new InspectionDTO("Spoiler",1000,false,"BBB222");
        InspectionDTO[] testInspections = {first,second};
        return new InspectionChecklist(testInspections);
    }
}