import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PaymentCalculatorTest {

    @Test
    public void calculatePaymentTakesNumberOfHoursAndReturnsTotalPay() {
        PaymentCalculator paymentCalculator = new PaymentCalculator();
        int hoursWorked = 5;

        double actual = paymentCalculator.calculatePayment(hoursWorked);

        assertThat(actual, is(50.00));
    }
}
