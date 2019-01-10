import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RateTest {
    @InjectMocks
    private Rate rate;
    @Mock
    private Family family;

    @Before
    public void setup() {
        initMocks(this);
    }
    @Test
    public void getRateUsingFamilyReturnsNine() {
        when(family.getTotalKids()).thenReturn(1);

        int actual = rate.getRate(family);

        assertThat(actual, is(9));
    }
}