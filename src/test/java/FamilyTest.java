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
}