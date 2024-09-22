import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean expectedHasMane;

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int kittens = lion.getKittens();
        //Ожидаем 0, тк мок Feline возвращает значение по умолчанию 0
        assertEquals(0, kittens);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.doesHaveMane();
        assertEquals(expectedHasMane, lion.doesHaveMane());
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
