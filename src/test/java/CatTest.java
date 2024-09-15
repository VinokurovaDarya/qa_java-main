import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class CatTest {
    private Cat cat;
    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {

        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы"));

        List<String> food = cat.getFood();
        assertEquals(Arrays.asList("Животные", "Птицы"), food);
    }

    @Test
    public void testGetFoodWithException() throws Exception {

        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));

        Exception exception = assertThrows(Exception.class, () -> {
            cat.getFood();
        });

        assertEquals("Ошибка получения еды", exception.getMessage());
    }

    @Test
    public void testGetFamilyFromFeline() throws Exception {

        when(felineMock.getFamily()).thenReturn("Кошачьи");

        assertEquals("Кошачьи", felineMock.getFamily());
    }
}
