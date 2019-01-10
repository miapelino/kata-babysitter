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
    public void testGetAndSetStartHour() {
        int startHour = 19;

        job.setStartHour(startHour);

        assertThat(startHour, is(job.getStartHour()));
    }

    @Test
    public void testGetAndSetEndHour() {
        int endHour = 23;

        job.setEndHour(endHour);

        assertThat(endHour, is(job.getEndHour()));
    }

    @Test
    public void testGetAndSetFamily() {
        Family testFamily = new Family();

        job.setFamily(testFamily);

        assertThat(testFamily, is(job.getFamily()));
    }
}