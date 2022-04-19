package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestBurger {

    //Переменные для теста
    String bunName = "тестовая булка";
    float bunPrice = 6.66F;
    String firstIngredientName = "тестовый соус";
    float firstIngredientPrice = 7.77F;
    String secondIngredientName = "тестовая котлета";
    float secondIngredientPrice = 8.88F;
    //Объекты для теста
    Burger burger;
    IngredientType sauce = IngredientType.SAUCE;
    IngredientType filling = IngredientType.FILLING;
    Ingredient firstIngredient = new Ingredient(sauce, firstIngredientName, firstIngredientPrice);
    Ingredient secondIngredient = new Ingredient(filling, secondIngredientName, secondIngredientPrice);
    Bun bun = new Bun(bunName, bunPrice);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    //Проверяем, что можно указать булку для бургера
    @Test
    public void checkSettingTheBun() {
        burger.setBuns(bun);
        String actual = burger.bun.getName();
        assertEquals("The bun name is not set!", actual, bunName);
    }
    //Проверяем, что можно добавить ингредиент в бургер
    @Test
    public void checkOfAddingTheIngredient() {
        burger.addIngredient(firstIngredient);
        assertFalse("The ingredient was not added!", burger.ingredients.isEmpty());
    }
    //Проверяем, что ингредиент можно убрать из бургера
    @Test
    public void checkOfRemovingTheIngredient() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("The ingredient was not removed!", burger.ingredients.isEmpty());
    }
    //Проверяем, что ингредиенты бургера можно менять местами в списке
    @Test
    public void checkOfMovingTheIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1, 0);
        assertEquals("The ingredient has not been moved!", burger.ingredients.indexOf(firstIngredient), 1);
    }
    //Проверяем, что после выбора булки и ингредиента цена бургера !=0
    @Test
    public void checkGetOfPriceTheBurger() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        float correctPrice = bunPrice * 2 + firstIngredientPrice;
        assertEquals("Incorrect price!", burger.getPrice(), correctPrice, 0);
        System.out.println(burger.getPrice());
    }
    //Проверяем формат чека бургера
    @Test
    public void checkTheFormatOfTheBurgerReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        String expectedFormat =
                String.format("(==== %s ====)%n", bunName) +
                        String.format("= %s %s =%n", "sauce", firstIngredientName) +
                        String.format("= %s %s =%n", "filling", secondIngredientName) +
                        String.format("(==== %s ====)%n", bunName) +
                        String.format("%nPrice: %f%n", (bunPrice * 2 + firstIngredientPrice + secondIngredientPrice));
        assertEquals(expectedFormat, burger.getReceipt());
    }

}
