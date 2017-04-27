package Projects.Intergration;

import Projects.Model.Receipt;
import Projects.Util.Amount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrinterTest {

    private Printer testSubject = new Printer();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Receipt newReceipt;

    @Before
    public void setUp()  {
        newReceipt = createReceipt();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown()  {
        newReceipt = null;
    }

    @Test
    public void printReceipt()  {
        testSubject.printReceipt(newReceipt);
        assertEquals("Receipt has been printed!\r\n",outContent.toString());
    }

    @Test
    public void printInspectionResult()  {
    }

private Receipt createReceipt(){
    Amount testAmount = new Amount(200,"SEK");
    return new Receipt(testAmount,true);
}

}