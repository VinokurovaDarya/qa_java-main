import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class LionParameterTest {
    private Lion lion;
    private Feline felineMock;

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Parameterized.Parameter(2)
    public int expectedKittens;

    // Параметризованный набор данных
    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, 3},
                {"Самка", false, 3}
        });
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(expectedKittens);
        lion = new Lion(sex, felineMock);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        assertEquals(expectedKittens, lion.getKittens());
    }
}