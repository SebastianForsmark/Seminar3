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
        testSubject = Garage.getGarage();
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void tearDown() {
        testSubject.closeDoor();
        testSubject = null;
    }

    /**
     * The test opens the door then attempts to open it again.
     */
    @Test
    public void openDoorWhenOpened() {

        testSubject.openDoor();
        testSubject.openDoor();
        assertEquals("Incorrectly handles opening an open door", "The door is being opened.\r\nThe door is already open.\r\n", outContent.toString());

    }

    /**
     * The test attempts to close an already closed door.
     */
    @Test
    public void closeDoorWhenClosed() {
        testSubject.closeDoor();
        assertEquals("Incorrectly handles closing a closed door", "The door is already closed.\r\n", outContent.toString());
    }

}