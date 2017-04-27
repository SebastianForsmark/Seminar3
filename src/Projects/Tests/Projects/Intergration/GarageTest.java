package Projects.Intergration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GarageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Garage testSubject;

    @Before
    public void setUp() {
        testSubject = new Garage();
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void tearDown() {
        testSubject = null;
    }

    @Test
    public void openDoorWhenOpened()  {
        //The test opens the door then attempts to open it again.
        testSubject.openDoor();
        testSubject.openDoor();
        assertEquals("The door is being opened.\r\nThe door is already open.\r\n", outContent.toString());

    }

    @Test
    public void closeDoorWhenClosed() {
        //The test attempts to close an already closed door.
        testSubject.closeDoor();
        assertEquals("The door is already closed.\r\n", outContent.toString());
    }

}