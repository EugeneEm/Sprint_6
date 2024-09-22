import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testGetFamily()  {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter(){
        assertEquals(5, feline.getKittens(5));
    }
}
