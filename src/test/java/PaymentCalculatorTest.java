import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


public class PaymentCalculatorTest {
    @InjectMocks
    private PaymentCalculator paymentCalculator;
    @Mock
    private Rate rate;

    @Test
    public void calculatePaymentTakesStartAndEndHoursAndReturnsTotalPay() {
        paymentCalculator = new PaymentCalculator();
        int startHour = 17;
        int endHour = 22;

        int actual = paymentCalculator.calculatePayment(startHour, endHour);

        assertThat(actual, is(45));
    }

    @Test
    public void calculatePaymentGetsRateFromRateClass() {
        initMocks(this);
        int startHour = 18;
        int endHour = 23;
        when(rate.getRate()).thenReturn(9);

        paymentCalculator.calculatePayment(startHour, endHour);

        verify(rate, times(1)).getRate();
    }
}
