import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;


public class LionTest {

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int kittens = lion.getKittens();
        //Ожидаем 0, тк мок Feline возвращает значение по умолчанию 0
        assertEquals(0, kittens);
    }

    @Test
    public void testDoesHaveManeException() {
        String invalidSex = "Лев";
        Assert.assertThrows(Exception.class, () -> new Lion(invalidSex, feline));
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
