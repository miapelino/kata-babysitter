import org.junit.Before;
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
    private Job job;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void calculatePaymentTakesHoursFromJobAndUsesRateToReturnTotalPay() throws Exception {
        Family familyA = new Family();
        Job job = new Job();
        job.setFamily(familyA);
        job.setStartHour(17);
        job.setEndHour(22);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(75));
    }

    @Test
    public void calculatePaymentGetsRateFromRateClass() throws Exception {
        Job job = new Job();
        job.setStartHour(18);
        job.setEndHour(23);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(9);

        paymentCalculator.calculatePayment(job);

        verify(rate, times(1)).getStandardHourlyRate(job.getFamily());
    }

}
