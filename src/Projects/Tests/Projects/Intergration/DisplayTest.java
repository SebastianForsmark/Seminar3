package Projects.Intergration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DisplayTest {
    private Display test;

    @Before
    public void setUp() {
        test = test.getDisplay();
    }

    @After
    public void tearDown() {
        test = null;
    }

    @Test
    public void countToHighNumber() {
        int largeCustomerAmount = 1000000;
        for (int i = 0; i < largeCustomerAmount; i++) {
            test.nextNumber();
        }
        int result = test.getQueueNumber();
        assertEquals("Can't count to a high number accurately", largeCustomerAmount, result);

    }

}