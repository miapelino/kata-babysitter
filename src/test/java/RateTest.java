import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RateTest {
    private Rate rate;

    @Test
    public void getRateReturnsNine() {
        rate = new Rate();

        int actual = rate.getRate();

        assertThat(actual, is(9));
    }
}