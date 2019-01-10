import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FamilyTest {
    private Family family;

    @Before
    public void setup() {
        family = new Family();
    }

    @Test
    public void testGetAndSetTotalKids() {
        int expectedTotalKids = 1;

        family.setTotalKids(expectedTotalKids);

        assertThat(family.getTotalKids(), is(expectedTotalKids));
    }

    @Test
    public void testGetAndSetTotalDogs() {
        int expectedTotalDogs = 1;

        family.setTotalDogs(expectedTotalDogs);

        assertThat(family.getTotalDogs(), is(expectedTotalDogs));
    }

    @Test
    public void testGetAndSetTotalCats() {
        int expectedTotalCats = 1;

        family.setTotalCats(expectedTotalCats);

        assertThat(family.getTotalCats(), is(expectedTotalCats));
    }

    @Test
    public void testGetAndSetIsHaunted() {
        family.setIsHaunted(true);

        assertTrue(family.getIsHaunted());
    }

    @Test
    public void testGetAndSetBedtimeStartHour() {
        int expectedBedtime = 23;

        family.setBedtimeStartHour(expectedBedtime);

        assertThat(family.getBedtimeStartHour(), is(expectedBedtime));
    }

    @Test
    public void testGetAndSetLateNightStartHour() {
        int expectedLateNightStartHour = 26;

        family.setLateNightStartHour(expectedLateNightStartHour);
    }

    @Test
    public void testGetTotalNumberOfPetsAddsThreeCatsAndTwoDogsAndGets5() {
        int cats = 3;
        int dogs = 2;
        family.setTotalCats(cats);
        family.setTotalDogs(dogs);

        assertThat(family.getTotalNumberOfPets(), is(cats + dogs));
    }

    @Test
    public void getStandardHourlyRateUsingFamilyAReturns15() {
        Family familyA = getTestFamilyA();

        int actual = familyA.getStandardHourlyRate();

        assertThat(actual, is(15));
    }

    @Test
    public void getStandardHourlyRateUsingFamilyBReturns12() {
        Family familyB = getTestFamilyB();

        int actual = familyB.getStandardHourlyRate();

        assertThat(actual, is(12));
    }

    @Test
    public void getStandardHourlyRateUsingFamilyCReturns21() {
        Family familyC = getTestFamilyC();

        int actual = familyC.getStandardHourlyRate();

        assertThat(actual, is(21));
    }

    @Test
    public void getBedtimeHourlyRateUsingFamilyBReturns8() {
        Family familyB = getTestFamilyB();

        int actual = familyB.getBedtimeHourlyRate();

        assertThat(actual, is(8));
    }

    @Test
    public void getBedtimeHourlyRateUsingFamilyCReturns15() {
        Family familyC = getTestFamilyC();

        int actual = familyC.getBedtimeHourlyRate();

        assertThat(actual, is(15));
    }

    @Test
    public void getLateNightHourlyRateUsingHauntedFamilyAReturns20() {
        Family familyA = getTestFamilyA();

        int actual = familyA.getLateNightHourlyRate();

        assertThat(actual, is(20));
    }

    @Test
    public void getLateNightHourlyRateUsingFamilyBReturns16() {
        Family familyB = getTestFamilyB();

        int actual = familyB.getLateNightHourlyRate();

        assertThat(actual, is(16));
    }

    @Test
    public void testReturnHoursBetweenStartAndBedtime() {
        family.setBedtimeStartHour(7);

        int actual = family.hoursBetweenStartHourAndBedtime(5);

        assertThat(actual, is(2));
    }

    @Test
    public void testReturnHoursBetweenStartAndLateNight() {
        family.setLateNightStartHour(7);

        int actual = family.hoursBetweenStartHourAndLateNight(5);

        assertThat(actual, is(2));
    }

    @Test
    public void testReturnHoursBetweenBedtimeAndLateNight() {
        family.setLateNightStartHour(7);
        family.setBedtimeStartHour(3);

        int actual = family.hoursBetweenBedtimeAndLateNight();

        assertThat(actual, is(4));
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