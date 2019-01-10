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
    private static final int END_HOUR_22 = 22;
    private static final int END_HOUR_26 = 26;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void calculateFamilyAPaymentAddsStandardPaymentAmountToObject() throws Exception {
        Job job = getFamilyAJob(START_HOUR_17,END_HOUR_22);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);

        paymentCalculator.calculatePayment(job);

        assertThat(paymentCalculator.getPayment()[0], is(90));
    }

    @Test
    public void getNumberOfStandardHoursForFamilyAJobReturnsExpectedNumber() throws Exception {
        Job job = getFamilyAJob(START_HOUR_17,END_HOUR_26);

        int actual = paymentCalculator.getNumberOfStandardHours(job);

        assertThat(actual, is(6));
    }

    @Test
    public void getNumberOfStandardHoursForFamilyBJobReturnsExpectedNumber() throws Exception {
        Job job = getFamilyBJob();

        int actual = paymentCalculator.getNumberOfStandardHours(job);

        assertThat(actual, is(5));
    }

    @Test
    public void getNumberOfStandardHoursForFamilyCJobReturnsExpectedNumber() throws Exception {
        Job job = getFamilyCJob();

        int actual = paymentCalculator.getNumberOfStandardHours(job);

        assertThat(actual, is(4));
    }

    @Test
    public void calculateStandardPaymentForFamilyAReturnsExpectedAmount() throws Exception {
        Job job = getFamilyAJob(START_HOUR_17,END_HOUR_26);
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(15);

        int actual = paymentCalculator.calculateStandardPayment(job);

        assertThat(actual, is(90));
    }

    @Test
    public void calculateStandardPaymentForFamilyBReturnsExpectedAmount() throws Exception {
        Job job = getFamilyBJob();
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(12);

        int actual = paymentCalculator.calculateStandardPayment(job);

        assertThat(actual, is(60));
    }

    @Test
    public void calculateStandardPaymentForFamilyCReturnsExpectedAmount() throws Exception {
        Job job = getFamilyCJob();
        when(rate.getStandardHourlyRate(job.getFamily())).thenReturn(21);

        int actual = paymentCalculator.calculateStandardPayment(job);

        assertThat(actual, is(84));
    }

    private Job getFamilyAJob(int startHour, int endHour) throws Exception {
        Job job = new Job();
        job.setStartHour(startHour);
        job.setEndHour(endHour);
        Family familyA = new Family();
        familyA.setBedtimeStartHour(23);
        job.setFamily(familyA);
        return job;
    }

    private Job getFamilyBJob() throws Exception {
        Job job = new Job();
        job.setStartHour(17);
        job.setEndHour(26);
        Family familyB = new Family();
        familyB.setBedtimeStartHour(22);
        job.setFamily(familyB);
        return job;
    }

    private Job getFamilyCJob() throws Exception {
        Job job = new Job();
        job.setStartHour(17);
        job.setEndHour(26);
        Family familyC = new Family();
        familyC.setLateNightStartHour(21);
        job.setFamily(familyC);
        return job;
    }
}
