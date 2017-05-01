package Projects.Intergration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PaymentAuthorizationTest {
    private PaymentAuthorization testPaymentauthorization;
    private CreditCard creditCard;
    private double cost;

    @Before
    public void setUp() {
        creditCard = new CreditCard(1234,"894583054","John Smith","2018/09",231);
        cost = 499.99;
        testPaymentauthorization = new PaymentAuthorization();
    }

    @After
    public void tearDown()   {
        creditCard = null;
        testPaymentauthorization = null;
    }

    @Test
    public void paymentIsAuthorized()   {
        assertTrue("Payment is not authorized",testPaymentauthorization.authorizePayment(creditCard,cost));
    }

}