import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeTests {

    @Test
    public void test1() {
        AttackType normal = new Normal();
        AttackType explosive = new Explosive();
        AttackType concussive = new Concussive();
        
        Unit marine = new Marine(
                normal,
                6,
                0,
                UnitSizeType.SMALL
        );

        Unit vulture = new Vulture(
                concussive,
                20,
                0,
                UnitSizeType.MEDIUM
        );

        Unit firebat = new Firebat(
                explosive,
                16,
                1,
                UnitSizeType.SMALL
        );

        Assertions.assertEquals(
                6,
                marine.attack(vulture)
        );
        Assertions.assertEquals(
                10,
                vulture.attack(vulture)
        );
        Assertions.assertEquals(
                8,
                firebat.attack(marine)
        );
    }
}
