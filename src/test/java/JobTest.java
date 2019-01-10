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
    public void testGetJobEndTime() throws Exception {
        int jobDuration = 7;
        int startTime = 18;
        int expected = jobDuration + startTime;

        job.setJobDuration(jobDuration);
        job.setStartHour(startTime);

        assertThat(job.getJobEndHour(), is(expected));
    }
}