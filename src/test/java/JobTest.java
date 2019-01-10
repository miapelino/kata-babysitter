import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    private Job job;

    private TestDataHelper testDataHelper;

    @Before
    public void setUp() {
        testDataHelper = new TestDataHelper();
    }

    @Test
    public void testValidConstructorSetsFamilyStartAndDuration() throws Exception {
        Family testFamily = new Family();

        job = new Job(testFamily, 19, 6);

        assertThat(job.getStartHour(), is(19));
        assertThat(job.getJobDuration(), is(6));
        assertThat(job.getFamily(), is(testFamily));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidStartHourInConstructorThrowsException() throws Exception {
        Family testFamily = new Family();

        job = new Job(testFamily, 7, 6);
    }

    @Test(expected = Exception.class)
    public void testSetValidStartHourThrowsExceptionWhenDurationSetFirstInvalidatesIt() throws Exception {
        Family testFamily = new Family();

        job = new Job(testFamily, 20, 10);
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyA() throws Exception {
        job = testDataHelper.getFamilyAJob(17,8);

        int actual = job.determineNumberOfStandardHours();

        assertThat(actual, is(6));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyB() throws Exception {
        job = testDataHelper.getFamilyBJob(17, 8);

        int actual = job.determineNumberOfStandardHours();

        assertThat(actual, is(5));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyC() throws Exception {
        job = testDataHelper.getFamilyCJob(17, 8);

        int actual = job.determineNumberOfStandardHours();

        assertThat(actual, is(4));
    }

    @Test
    public void testGetNumberOfBedtimeHoursReturnsZeroBedtimeHoursForFamilyA() throws Exception {
        job = testDataHelper.getFamilyAJob(17, 8);

        int actual = job.determineNumberOfBedtimeHours(3);

        assertThat(actual, is(0));
    }

    @Test
    public void testGetNumberOfBedtimeHoursReturnsAllBedtimeHoursForFamilyB() throws Exception {
        job = testDataHelper.getFamilyBJob(17, 8);

        int actual = job.determineNumberOfBedtimeHours(3);

        assertThat(actual, is(2));
    }

    @Test
    public void testGetNumberOfBedtimeHoursReturnsAllBedtimeHoursForFamilyC() throws Exception {
        job = testDataHelper.getFamilyCJob(17, 7);

        int actual = job.determineNumberOfBedtimeHours(3);

        assertThat(actual, is(3));
    }
}