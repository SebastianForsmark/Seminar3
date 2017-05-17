package Projects.Intergration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class SystemHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private SystemHandler testSystemHandler = new SystemHandler();

    @Before
    public void setUp()   {
        System.setOut(new PrintStream(outContent));
        testSystemHandler.numberDisplay.resetDisplay();
    }

    @After
    public void tearDown()   {
    }

    @Test
    public void inspectionAfterInspection()   {
        testSystemHandler.nextInspection();
        testSystemHandler.nextInspection();
        testSystemHandler.nextInspection();
        System.out.println(testSystemHandler.numberDisplay.getQueueNumber());
        assertEquals("Does not handle several nextInspection calls correctly","The door is being opened.\r\nThe door is already open.\r\nThe door is already open.\r\n3\r\n", outContent.toString());

    }

}