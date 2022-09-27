import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompositeTests {

    @Test
    public void test1() {
        Cart cart = new Cart();

        Product nutella = new Nutella(20);
        Product cheetos = new Cheetos(3);
        Product monsterEnergy = new MonsterEnergy(1);

        cart.add(cheetos);
        Assertions.assertEquals(
                3,
                cart.getPrice()
        );

        for (int i = 0; i < 5; i++) cart.add(monsterEnergy);
        Assertions.assertEquals(
                8,
                cart.getPrice()
        );

        cart.add(nutella);
        Assertions.assertEquals(
                28,
                cart.getPrice()
        );

        cart.remove(monsterEnergy);
        Assertions.assertEquals(
                27,
                cart.getPrice()
        );
    }
}
