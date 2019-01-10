import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class PaymentCalculatorTest {
    @InjectMocks
    private PaymentCalculator paymentCalculator;
    @Mock
    private Rate rate;

    private Job job;

    private TestDataHelper familyTestFactory;

    private static final int START_HOUR_17 = 17;
    private static final int START_HOUR_22 = 22;
    private static final int JOB_DURATION_2 = 2;
    private static final int JOB_DURATION_9 = 9;

    @Before
    public void setUp() {
        initMocks(this);
        familyTestFactory = new TestDataHelper();
    }

    @Test
    public void calculateFamilyAPaymentReturnsStandardAndLateNightPaymentsAsTotal() throws Exception {
        Job job = familyTestFactory.getFamilyAJob(START_HOUR_17,JOB_DURATION_9);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);
        when(rate.getBedtimeHourlyRate(job.getFamily())).thenReturn(0);
        when(rate.getLateNightHourlyRate(job.getFamily())).thenReturn(20);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(150));
    }

    @Test
    public void calculateFamilyAPaymentReturnsOnlyStandardPaymentAmount() throws Exception {
        Job job = familyTestFactory.getFamilyAJob(START_HOUR_17,JOB_DURATION_2);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);
        when(rate.getBedtimeHourlyRate(job.getFamily())).thenReturn(0);
        when(rate.getLateNightHourlyRate(job.getFamily())).thenReturn(20);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(30));
    }

    @Test
    public void calculateFamilyBPaymentReturnsStandardAndBedTimePaymentTotals() throws Exception {
        Job job = familyTestFactory.getFamilyBJob(START_HOUR_17,JOB_DURATION_9);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(12);
        when(rate.getBedtimeHourlyRate(job.getFamily())).thenReturn(8);
        when(rate.getLateNightHourlyRate(job.getFamily())).thenReturn(16);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(108));
    }

    @Test
    public void calculateFamilyBPaymentReturnsOnlyStandardTotal() throws Exception {
        Job job = familyTestFactory.getFamilyBJob(START_HOUR_17,JOB_DURATION_2);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(12);
        when(rate.getBedtimeHourlyRate(job.getFamily())).thenReturn(8);
        when(rate.getLateNightHourlyRate(job.getFamily())).thenReturn(16);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(24));
    }

    @Test
    public void calculateFamilyBPaymentJobStartsAfterBedtimeReturnsOnlyBedtimeTotal() throws Exception {
        Job job = familyTestFactory.getFamilyBJob(START_HOUR_22,JOB_DURATION_2);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(12);
        when(rate.getBedtimeHourlyRate(job.getFamily())).thenReturn(8);
        when(rate.getLateNightHourlyRate(job.getFamily())).thenReturn(16);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(16));
    }

    @Test
    public void calculateFamilyCPaymentReturnsStandardAndBedTimePaymentTotals() throws Exception {
        Job job = familyTestFactory.getFamilyCJob(START_HOUR_17,JOB_DURATION_9);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(21);
        when(rate.getBedtimeHourlyRate(job.getFamily())).thenReturn(15);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(159));
    }
}
