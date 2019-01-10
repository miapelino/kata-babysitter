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

    private static final int START_HOUR_17 = 17;
    private static final int JOB_DURATION_2 = 2;
    private static final int JOB_DURATION_5 = 5;
    private static final int JOB_DURATION_9 = 9;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void calculateStandardFamilyAPaymentAddsStandardPaymentAmountToObject() throws Exception {
        Job job = getFamilyAJob(START_HOUR_17,JOB_DURATION_5);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);

        paymentCalculator.calculatePayment(job);

        assertThat(paymentCalculator.getPayment()[0], is(75));
    }

    @Test
    public void calculateStandardPaymentForFamilyAJobReturnsStandardHourlyPay() throws Exception {
        Job job = getFamilyAJob(START_HOUR_17,JOB_DURATION_2);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(30));
    }

    @Test
    public void calculateStandardPaymentForFamilyBJobReturnsStandardHourlyPay() throws Exception {
        Job job = getFamilyBJob();
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(12);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(60));
    }

    @Test
    public void calculateStandardPaymentForFamilyAReturnsExpectedAmount() throws Exception {
        Job job = getFamilyAJob(START_HOUR_17,JOB_DURATION_9);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(90));
    }

    @Test
    public void calculateStandardPaymentForFamilyBReturnsExpectedAmount() throws Exception {
        Job job = getFamilyBJob();
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(12);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(60));
    }

    @Test
    public void calculateStandardPaymentForFamilyCReturnsExpectedAmount() throws Exception {
        Job job = getFamilyCJob();
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(21);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(84));
    }

    private Job getFamilyAJob(int startHour, int jobDuration) throws Exception {
        Job job = new Job();
        job.setStartHour(startHour);
        job.setJobDuration(jobDuration);
        Family familyA = new Family();
        familyA.setLateNightStartHour(23);
        job.setFamily(familyA);
        return job;
    }

    private Job getFamilyBJob() throws Exception {
        Job job = new Job();
        job.setStartHour(17);
        job.setJobDuration(9);
        Family familyB = new Family();
        familyB.setBedtimeStartHour(22);
        familyB.setLateNightStartHour(24);
        job.setFamily(familyB);
        return job;
    }

    private Job getFamilyCJob() throws Exception {
        Job job = new Job();
        job.setStartHour(17);
        job.setJobDuration(9);
        Family familyC = new Family();
        familyC.setBedtimeStartHour(21);
        job.setFamily(familyC);
        return job;
    }
}
