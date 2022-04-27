package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class TestIngredientType {

    //Переменные для параметризации
    private final int index;
    private final IngredientType type;
    private final boolean expectedResult;

    public TestIngredientType(int index, IngredientType type, boolean expectedResult) {
        this.index = index;
        this.type = type;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Check the ingredient type: {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {0, SAUCE, true},
                {1, FILLING, true},
        };
    }

    //Тест проверяет, что по индексу в ingredient type enum находится корректное значение
    @Test
    public void checkTheCorrectTypeOfIngredient() {
        assertEquals("No such ingredient",
                IngredientType.values()[index].equals(type), expectedResult);
    }

}
