import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTests {

    @Test
    public void test1_create_cuisine() {
        Cuisine koreanFood = Restaurant.getCuisine(new KoreanChefFactory());
        Assertions.assertEquals(
                "Korean Food: Chimaek",
                koreanFood.toString()
        );

        Cuisine japaneseFood = Restaurant.getCuisine(new JapaneseChefFactory());
        Assertions.assertEquals(
                "Japanese Food: Okonomiyaki",
                japaneseFood.toString()
        );

        Cuisine vietnameseFood = Restaurant.getCuisine(new VietnameseChefFactory());
        Assertions.assertEquals(
                "Vietnamese Food: Rice Noodle",
                vietnameseFood.toString()
        );
    }

    @Test
    public void test2_create_sauce() {
        Sauce koreanSauce = Restaurant.getSauce(new KoreanChefFactory());
        Assertions.assertEquals(
                "Korean Sauce: Kochujang",
                koreanSauce.toString()
        );

        Sauce japaneseSauce = Restaurant.getSauce(new JapaneseChefFactory());
        Assertions.assertEquals(
                "Japanese Sauce: Teriyaki",
                japaneseSauce.toString()
        );

        Sauce vietnameseSauce = Restaurant.getSauce(new VietnameseChefFactory());
        Assertions.assertEquals(
                "Vietnamese Sauce: Nuoc Nam Gung",
                vietnameseSauce.toString()
        );
    }
}
