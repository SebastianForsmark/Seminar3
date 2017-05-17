package Projects.Intergration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


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
        try {
            testDatabaseManager.findInspectionsByRegNo("ABC123333333");
        }
        catch (RegNoNotFoundException e){
            fail();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void accidentalShortRegistrationNumber()   {
        try {
            testDatabaseManager.findInspectionsByRegNo("23");
        }
        catch (RegNoNotFoundException e){
            fail();
        }

    }

}