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

        assertThat(expectedTotalKids, is(family.getTotalKids()));
    }

    @Test
    public void testGetAndSetTotalDogs() {
        int expectedTotalDogs = 1;

        family.setTotalDogs(expectedTotalDogs);

        assertThat(expectedTotalDogs, is(family.getTotalDogs()));
    }

    @Test
    public void testGetAndSetTotalCats() {
        int expectedTotalCats = 1;

        family.setTotalCats(expectedTotalCats);

        assertThat(expectedTotalCats, is(family.getTotalCats()));
    }
}