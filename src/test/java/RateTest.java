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

    @Test
    public void getStandardHourlyRateUsingFamilyBReturns12() {
        Family familyB = getTestFamilyB();

        int actual = rate.getStandardHourlyRate(familyB);

        assertThat(actual, is(12));
    }

    @Test
    public void getStandardHourlyRateUsingFamilyCReturns21() {
        Family familyC = getTestFamilyC();

        int actual = rate.getStandardHourlyRate(familyC);

        assertThat(actual, is(21));
    }

    @Test
    public void getBedtimeHourlyRateUsingFamilyBReturns8() {
        Family familyB = getTestFamilyB();

        int actual = rate.getBedtimeHourlyRate(familyB);

        assertThat(actual, is(8));
    }

    @Test
    public void getBedtimeHourlyRateUsingFamilyCReturns15() {
        Family familyC = getTestFamilyC();

        int actual = rate.getBedtimeHourlyRate(familyC);

        assertThat(actual, is(15));
    }

    @Test
    public void getLateNightHourlyRateUsingHauntedFamilyAReturns20() {
        Family familyA = getTestFamilyA();

        int actual = rate.getLateNightHourlyRate(familyA);

        assertThat(actual, is(20));
    }

    @Test
    public void getLateNightHourlyRateUsingFamilyBReturns16() {
        Family familyB = getTestFamilyB();

        int actual = rate.getLateNightHourlyRate(familyB);

        assertThat(actual, is(16));
    }

    private Family getTestFamilyA() {
        Family familyA = new Family();
        familyA.setTotalKids(2);
        familyA.setTotalDogs(0);
        familyA.setTotalCats(0);
        familyA.setIsHaunted(true);

        return familyA;
    }

    private Family getTestFamilyB() {
        Family familyB = new Family();
        familyB.setTotalKids(1);
        familyB.setTotalDogs(0);
        familyB.setTotalCats(2);
        familyB.setIsHaunted(false);

        return familyB;
    }

    private Family getTestFamilyC() {
        Family familyC = new Family();
        familyC.setTotalKids(2);
        familyC.setTotalDogs(3);
        familyC.setTotalCats(0);

        return familyC;
    }
}
