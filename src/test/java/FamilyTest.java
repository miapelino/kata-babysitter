import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FamilyTest {
    private Family family;

    @Test
    public void testGetAndSetTotalKids() {
        family = new Family();
        int expectedTotalKids = 1;
        family.setTotalKids(expectedTotalKids);
        assertThat(expectedTotalKids, is(family.getTotalKids()));
    }
}