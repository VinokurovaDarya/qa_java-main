import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {
    private Lion lionMale;
    private Lion lionFemale;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);


        when(felineMock.getKittens()).thenReturn(3);
        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы"));

        lionMale = new Lion("Самец", felineMock);
        lionFemale = new Lion("Самка", felineMock);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> food = lionMale.getFood();
        assertEquals(expectedFood, food);
    }

    @Test(expected = Exception.class)
    public void testLionConstructorInvalidSex() throws Exception {
        new Lion("Некорректный", felineMock);
    }
}