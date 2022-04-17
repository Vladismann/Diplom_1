package praktikum;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBun {

    //Указываем передоваемое тестовое имя и цену
    private final String EXPECTED_NAME = "Тестовая Булка";
    private final float EXPECTED_PRICE = 6.66F;
    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(EXPECTED_NAME, EXPECTED_PRICE);
    }

    //Проверяем, что метод getName возвращает имя указанное в конструкторе
    @Test
    public void getNameOfBun() {
        String actual = bun.getName();
        assertEquals("The name does not match the specified!", actual, EXPECTED_NAME);
    }
    @Test
    public void getPriceOfBun() {
        float actual = bun.getPrice();
        assertEquals("The price does not match the specified!", actual, EXPECTED_PRICE, 0);
    }

}
