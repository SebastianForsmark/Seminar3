package Projects.Intergration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class DatabaseManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private DatabaseManager testDatabaseManager = new DatabaseManager();

    @Before
    public void setUp()   {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown()   {
    }

    @Test(expected = IllegalArgumentException.class)
    public void accidentalLongRegistrationNumber()   {
        testDatabaseManager.findInspectionsByRegNo("ABC123333333");

    }

    @Test(expected = IllegalArgumentException.class)
    public void accidentalShortRegistrationNumber()   {
        testDatabaseManager.findInspectionsByRegNo("23");


    }

}