import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PaymentCalculatorTest {

    @Test
    public void calculatePaymentReturnsTotalPay() {
        PaymentCalculator paymentCalculator = new PaymentCalculator();

        double actual = paymentCalculator.calculatePayment();

        assertThat(actual, is(50.00));
    }

}