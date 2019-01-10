import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class PaymentCalculatorTest {
    @InjectMocks
    private PaymentCalculator paymentCalculator;
    @Mock
    private Family family;
    @Mock
    private Job job;

    private TestDataHelper testDataHelper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        testDataHelper = new TestDataHelper();
    }

    @Test
    public void calculateFamilyAPaymentReturnsStandardAndLateNightPaymentsAsTotal() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(15);
        when(family.getBedtimeHourlyRate()).thenReturn(0);
        when(family.getLateNightHourlyRate()).thenReturn(20);
        when(job.getJobDuration()).thenReturn(9);
        when(job.determineNumberOfStandardHours()).thenReturn(6);
        doNothing().when(job).setStandardHoursWorked(6);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(3)).thenReturn(0);
        when(job.getRemainingHours()).thenReturn(3);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(150));
    }

    @Test
    public void calculateFamilyAPaymentReturnsOnlyStandardPaymentAmount() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(15);
        when(family.getBedtimeHourlyRate()).thenReturn(0);
        when(family.getLateNightHourlyRate()).thenReturn(20);
        when(job.getJobDuration()).thenReturn(2);
        when(job.determineNumberOfStandardHours()).thenReturn(2);
        doNothing().when(job).setStandardHoursWorked(2);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(3)).thenReturn(0);
        when(job.getRemainingHours()).thenReturn(0);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(30));
    }

    @Test
    public void calculateFamilyBPaymentReturnsStandardAndBedTimePaymentTotals() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(12);
        when(family.getBedtimeHourlyRate()).thenReturn(8);
        when(family.getLateNightHourlyRate()).thenReturn(16);
        when(job.getJobDuration()).thenReturn(9);
        when(job.determineNumberOfStandardHours()).thenReturn(5);
        doNothing().when(job).setStandardHoursWorked(5);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(4)).thenReturn(2);
        when(job.getRemainingHours()).thenReturn(4,4,2);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(108));
    }

    @Test
    public void calculateFamilyBPaymentReturnsOnlyStandardTotal() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(12);
        when(family.getBedtimeHourlyRate()).thenReturn(8);
        when(family.getLateNightHourlyRate()).thenReturn(16);
        when(job.getJobDuration()).thenReturn(2);
        when(job.determineNumberOfStandardHours()).thenReturn(2);
        doNothing().when(job).setStandardHoursWorked(2);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(0)).thenReturn(0);
        when(job.getRemainingHours()).thenReturn(0,0,0);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(24));
    }

    @Test
    public void calculateFamilyBPaymentJobStartsAfterBedtimeReturnsOnlyBedtimeTotal() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(12);
        when(family.getBedtimeHourlyRate()).thenReturn(8);
        when(family.getLateNightHourlyRate()).thenReturn(16);
        when(job.getJobDuration()).thenReturn(2);
        when(job.determineNumberOfStandardHours()).thenReturn(0);
        doNothing().when(job).setStandardHoursWorked(0);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(2)).thenReturn(2);
        when(job.getRemainingHours()).thenReturn(2,2,0);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(16));
    }

    @Test
    public void calculateFamilyCPaymentReturnsStandardAndBedTimePaymentTotals() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(21);
        when(family.getBedtimeHourlyRate()).thenReturn(15);
        when(job.getJobDuration()).thenReturn(9);
        when(job.determineNumberOfStandardHours()).thenReturn(4);
        doNothing().when(job).setStandardHoursWorked(4);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(5)).thenReturn(5);
        when(job.getRemainingHours()).thenReturn(5,5,0);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(159));
    }

    @Test
    public void calculateFamilyCPaymentReturnsStandardOnlyPaymentTotal() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(21);
        when(family.getBedtimeHourlyRate()).thenReturn(15);
        when(job.getJobDuration()).thenReturn(4);
        when(job.determineNumberOfStandardHours()).thenReturn(4);
        doNothing().when(job).setStandardHoursWorked(4);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(0)).thenReturn(0);
        when(job.getRemainingHours()).thenReturn(0,0,0);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(84));
    }

    @Test
    public void calculateFamilyCPaymentReturnsBedtimeOnlyPaymentTotal() throws Exception {
        when(job.getFamily()).thenReturn(family);
        when(family.getStandardHourlyRate()).thenReturn(21);
        when(family.getBedtimeHourlyRate()).thenReturn(15);
        when(job.getJobDuration()).thenReturn(5);
        when(job.determineNumberOfStandardHours()).thenReturn(0);
        doNothing().when(job).setStandardHoursWorked(0);
        doNothing().when(job).setRemainingHours(any(Integer.class));
        when(job.determineNumberOfBedtimeHours(5)).thenReturn(5);
        when(job.getRemainingHours()).thenReturn(5, 5, 0);

        int actual = paymentCalculator.calculatePayment(job);

        assertThat(actual, is(75));
    }
}
