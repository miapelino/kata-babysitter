import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RateTest {
    private Rate rate;

    @Before
    public void setUp() {
        rate = new Rate();
    }

    @Test
    public void getStandardHourlyRateUsingFamilyAReturns15() {
        Family familyA = getTestFamilyA();

        int actual = rate.getStandardHourlyRate(familyA);

        assertThat(actual, is(15));
    }

    private Family getTestFamilyA() {
        Family familyA = new Family();
        familyA.setTotalKids(2);
        familyA.setTotalDogs(0);
        familyA.setTotalCats(0);

        return familyA;
    }



}