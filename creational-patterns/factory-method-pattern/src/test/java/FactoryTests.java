import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTests {

    @Test
    public void test1() {
        Fruit grape = Wholesaler.getFruit(new GrapeFactory());
        Assertions.assertTrue(
                grape instanceof Grape
        );

        Fruit apple = Wholesaler.getFruit(new AppleFactory());
        Assertions.assertTrue(
                apple instanceof Apple
        );

        Fruit melon = Wholesaler.getFruit(new MelonFactory());
        Assertions.assertTrue(
                melon instanceof Melon
        );
    }
}
