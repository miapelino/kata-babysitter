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

        assertThat(startHour, is(job.getStartHour()));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidStartHourThrowsException() throws Exception {
        int startHour = 14;

        job.setStartHour(startHour);
    }

    @Test
    public void testGetAndSetEndHour() throws Exception {
        int endHour = 23;

        job.setEndHour(endHour);

        assertThat(endHour, is(job.getEndHour()));
    }

    @Test(expected = Exception.class)
    public void testSetInvalidEndHourThrowsException() throws Exception {
        int endHour = 29;

        job.setEndHour(endHour);
    }

    @Test
    public void testGetAndSetFamily() {
        Family testFamily = new Family();

        job.setFamily(testFamily);

        assertThat(testFamily, is(job.getFamily()));
    }
}