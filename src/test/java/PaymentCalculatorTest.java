import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PaymentCalculatorTest {

    @Test
    public void calculatePaymentTakesStartAndEndHoursAndReturnsTotalPay() {
        PaymentCalculator paymentCalculator = new PaymentCalculator();
        int startHour = 17;
        int endHour = 22;

        int actual = paymentCalculator.calculatePayment(startHour, endHour);

        assertThat(actual, is(45));
    }
}
