import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    private Job job;

    @Before
    public void setUp() {
        job = new Job();
    }

    @Test
    public void testGetAndSetStartHour() throws Exception {
        int startHour = 19;

        job.setStartHour(startHour);

        assertThat(job.getStartHour(), is(startHour));
    }

    @Test
    public void testGetAndSetStartHourAfterValidDurationIsSet() throws Exception {
        int startHour = 19;
        int jobDuration = 6;

        job.setJobDuration(jobDuration);
        job.setStartHour(startHour);

        assertThat(job.getStartHour(), is(startHour));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidStartHourThrowsException() throws Exception {
        int startHour = 14;

        job.setStartHour(startHour);
    }

    @Test(expected = Exception.class)
    public void testSetValidStartHourThrowsExceptionWhenDurationSetFirstInvalidatesIt() throws Exception {
        int startHour = 20;
        int jobDuration = 10;

        job.setJobDuration(jobDuration);
        job.setStartHour(startHour);
    }

    @Test
    public void testGetAndSetJobDuration() throws Exception {
        int jobDuration = 6;

        job.setJobDuration(jobDuration);

        assertThat(job.getJobDuration(), is(jobDuration));
    }

    @Test
    public void testGetAndSetJobDurationAfterValidStartTimeIsSet() throws Exception {
        int startHour = 20;
        int jobDuration = 6;

        job.setStartHour(startHour);
        job.setJobDuration(jobDuration);

        assertThat(job.getJobDuration(), is(jobDuration));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidJobDurationWhenJobStartNotYetSetThrowsException() throws Exception {
        int jobDuration = 20;

        job.setJobDuration(jobDuration);
    }

    @Test(expected = Exception.class)
    public void testSetInvalidJobDurationWhenJobStartSetThrowsException() throws Exception {
        int jobStart = 19;
        int jobDuration = 10;

        job.setStartHour(jobStart);
        job.setJobDuration(jobDuration);
    }

    @Test
    public void testGetAndSetFamily() {
        Family testFamily = new Family();

        job.setFamily(testFamily);

        assertThat(job.getFamily(), is(testFamily));
    }

    @Test
    public void testGetJobEndHour() throws Exception {
        int jobDuration = 7;
        int startTime = 18;
        int expected = jobDuration + startTime;

        job.setJobDuration(jobDuration);
        job.setStartHour(startTime);

        assertThat(job.getJobEndHour(), is(expected));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyA() throws Exception {
        job.setJobDuration(8);
        job.setStartHour(17);
        Family familyA = new Family();
        familyA.setLateNightStartHour(23);
        job.setFamily(familyA);

        int actual = job.getNumberOfStandardHours();

        assertThat(actual, is(6));
    }

    @Test
    public void testGetNumberOfStandardHoursSetsCorrectRemainingHoursForFamilyA() throws Exception {
        job.setJobDuration(8);
        job.setStartHour(17);
        Family familyA = new Family();
        familyA.setLateNightStartHour(23);
        job.setFamily(familyA);
        job.getNumberOfStandardHours();

        int actual = job.getRemainingHours();

        assertThat(actual, is(2));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyB() throws Exception {
        job.setJobDuration(8);
        job.setStartHour(17);
        Family familyB = new Family();
        familyB.setBedtimeStartHour(22);
        familyB.setLateNightStartHour(24);
        job.setFamily(familyB);

        int actual = job.getNumberOfStandardHours();

        assertThat(actual, is(5));
    }

    @Test
    public void testGetNumberOfStandardHoursSetsCorrectRemainingHoursForFamilyB() throws Exception {
        job.setJobDuration(8);
        job.setStartHour(17);
        Family familyB = new Family();
        familyB.setBedtimeStartHour(22);
        familyB.setLateNightStartHour(24);
        job.setFamily(familyB);
        job.getNumberOfStandardHours();

        int actual = job.getRemainingHours();

        assertThat(actual, is(3));
    }

    @Test
    public void testGetNumberOfStandardHoursReturnsAllStandardHoursForFamilyC() throws Exception {
        job.setJobDuration(8);
        job.setStartHour(17);
        Family familyC = new Family();
        familyC.setBedtimeStartHour(21);
        job.setFamily(familyC);

        int actual = job.getNumberOfStandardHours();

        assertThat(actual, is(4));
    }

    @Test
    public void testGetNumberOfStandardHoursSetsCorrectRemainingHoursForFamilyC() throws Exception {
        job.setJobDuration(8);
        job.setStartHour(17);
        Family familyC = new Family();
        familyC.setBedtimeStartHour(21);
        job.setFamily(familyC);
        job.getNumberOfStandardHours();

        int actual = job.getRemainingHours();

        assertThat(actual, is(4));
    }
}