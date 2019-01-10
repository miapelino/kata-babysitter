import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class JobTest {
    private Job job;

    private FamilyTestFactory familyTestFactory;

    private static final int START_HOUR_14 = 14;
    private static final int START_HOUR_17 = 17;
    private static final int START_HOUR_19 = 19;
    private static final int START_HOUR_20 = 20;
    private static final int START_HOUR_22 = 22;

    private static final int JOB_DURATION_4 = 4;
    private static final int JOB_DURATION_6 = 6;
    private static final int JOB_DURATION_8 = 8;
    private static final int JOB_DURATION_10 = 10;
    private static final int JOB_DURATION_20 = 20;

    @Before
    public void setUp() {
        familyTestFactory = new FamilyTestFactory();
        job = new Job();
    }

    @Test
    public void testGetAndSetStartHour() throws Exception {
        job.setStartHour(START_HOUR_19);

        assertThat(job.getStartHour(), is(START_HOUR_19));
    }

    @Test
    public void testGetAndSetStartHourAfterValidDurationIsSet() throws Exception {
        job.setJobDuration(JOB_DURATION_6);
        job.setStartHour(START_HOUR_19);

        assertThat(job.getStartHour(), is(START_HOUR_19));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidStartHourThrowsException() throws Exception {
        job.setStartHour(START_HOUR_14);
    }

    @Test(expected = Exception.class)
    public void testSetValidStartHourThrowsExceptionWhenDurationSetFirstInvalidatesIt() throws Exception {
        job.setJobDuration(JOB_DURATION_10);
        job.setStartHour(START_HOUR_20);
    }

    @Test
    public void testGetAndSetJobDuration() throws Exception {
        job.setJobDuration(JOB_DURATION_6);

        assertThat(job.getJobDuration(), is(JOB_DURATION_6));
    }

    @Test
    public void testGetAndSetJobDurationAfterValidStartTimeIsSet() throws Exception {
        job.setStartHour(START_HOUR_20);
        job.setJobDuration(JOB_DURATION_6);

        assertThat(job.getJobDuration(), is(JOB_DURATION_6));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidJobDurationWhenJobStartNotYetSetThrowsException() throws Exception {
        job.setJobDuration(JOB_DURATION_20);
    }

    @Test(expected = Exception.class)
    public void testSetInvalidJobDurationWhenJobStartSetThrowsException() throws Exception {
        job.setStartHour(START_HOUR_19);
        job.setJobDuration(JOB_DURATION_10);
    }

    @Test
    public void testGetAndSetFamily() {
        Family testFamily = new Family();

        job.setFamily(testFamily);

        assertThat(job.getFamily(), is(testFamily));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyA() throws Exception {
        job = familyTestFactory.getFamilyAJob(START_HOUR_17,JOB_DURATION_8);

        int actual = job.getNumberOfStandardHours();

        assertThat(actual, is(6));
    }

    @Test
    public void testGetNumberOfStandardHoursSetsCorrectRemainingHoursForFamilyA() throws Exception {
        job = familyTestFactory.getFamilyAJob(START_HOUR_17,JOB_DURATION_8);
        job.getNumberOfStandardHours();

        int actual = job.getRemainingHours();

        assertThat(actual, is(2));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyB() throws Exception {
        job = familyTestFactory.getFamilyBJob(START_HOUR_17,JOB_DURATION_8);

        int actual = job.getNumberOfStandardHours();

        assertThat(actual, is(5));
    }

    @Test
    public void testGetNumberOfStandardHoursSetsCorrectRemainingHoursForFamilyB() throws Exception {
        job = familyTestFactory.getFamilyBJob(START_HOUR_17,JOB_DURATION_8);
        job.getNumberOfStandardHours();

        int actual = job.getRemainingHours();

        assertThat(actual, is(3));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyC() throws Exception {
        job = familyTestFactory.getFamilyCJob(START_HOUR_17,JOB_DURATION_8);

        int actual = job.getNumberOfStandardHours();

        assertThat(actual, is(4));
    }

    @Test
    public void testGetNumberOfStandardHoursSetsCorrectRemainingHoursForFamilyC() throws Exception {
        job = familyTestFactory.getFamilyCJob(START_HOUR_17,JOB_DURATION_8);
        job.getNumberOfStandardHours();

        int actual = job.getRemainingHours();

        assertThat(actual, is(4));
    }

    @Test
    public void testGetNumberOfBedtimeHoursReturnsZeroBedtimeHoursForFamilyA() throws Exception {
        job = familyTestFactory.getFamilyAJob(START_HOUR_17,JOB_DURATION_8);

        int actual = job.getNumberOfBedtimeHours(3);

        assertThat(actual, is(0));
    }

    @Test
    public void testGetNumberOfBedtimeHoursReturnsAllBedtimeHoursForFamilyB() throws Exception {
        job = familyTestFactory.getFamilyBJob(START_HOUR_17,JOB_DURATION_8);

        int actual = job.getNumberOfBedtimeHours(3);

        assertThat(actual, is(2));
    }

    @Test
    public void testGetNumberOfBedtimeHoursSetsCorrectRemainingHoursForFamilyB() throws Exception {
        job = familyTestFactory.getFamilyBJob(START_HOUR_22,JOB_DURATION_4);
        job.getNumberOfBedtimeHours(4);

        int actual = job.getRemainingHours();

        assertThat(actual, is(2));
    }

    @Test
    public void testGetNumberOfBedtimeHoursReturnsAllBedtimeHoursForFamilyC() throws Exception {
        job = familyTestFactory.getFamilyCJob(START_HOUR_17,JOB_DURATION_8);

        int actual = job.getNumberOfBedtimeHours(3);

        assertThat(actual, is(3));
    }

    @Test
    public void testGetNumberOfBedtimeHoursSetsCorrectRemainingHoursForFamilyC() throws Exception {
        job = familyTestFactory.getFamilyCJob(START_HOUR_17,JOB_DURATION_8);
        job.getNumberOfBedtimeHours(3);

        int actual = job.getRemainingHours();

        assertThat(actual, is(0));
    }
}