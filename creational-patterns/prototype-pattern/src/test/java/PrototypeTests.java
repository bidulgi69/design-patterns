import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class PrototypeTests {

    private final Barrack barrack = new Barrack();

    @BeforeEach
    public void setup() {
        barrack.clear();
    }

    @Test
    public void test0_barrack() {
        TerranBionicUnit marine = new TerranBionicUnit(
                "Marine",
                40,
                0,
                6,
                1.2f,
                0,
                1,
                1,
                1f,
                24,
                AttackType.NORMAL,
                UnitSize.SMALL
        );
        barrack.train(marine);

        Assertions.assertEquals(
                1,
                barrack.getSize()
        );
        Assertions.assertEquals(
                marine,
                barrack.getPeek()
        );
        Assertions.assertEquals(
                marine,
                barrack.emit()
        );
        Assertions.assertEquals(
                0,
                barrack.getSize()
        );
    }

    @Test
    public void test1() {
        TerranBionicUnit marine = new TerranBionicUnit(
                "Marine",
                40,
                0,
                6,
                1.2f,
                0,
                1,
                1,
                1f,
                24,
                AttackType.NORMAL,
                UnitSize.SMALL
        );
        barrack.train(marine);

        //  배럭에서 또 다른 마린을 생산하고자 할 때
        //  생성자를 통해 생성하는 것은 인자 값이 많아서 어려움.
        //  새로운 레퍼런스를 갖기 위해 clone() 메소드를 호출할 수 있다.
        TerranBionicUnit marine2 = marine.clone();
        barrack.train(marine2);

        //  서로 다른 레퍼런스이다.
        Assertions.assertNotEquals(
                marine,
                marine2
        );
        //  필드 값은 동일하다.
        Assertions.assertTrue(
                marine.getName().equals(marine2.getName())
                        && marine.getHp() == marine2.getHp()
                        && marine.getMp() == marine2.getMp()
                        && marine.getAttack() == marine2.getAttack()
                        && marine.getAttackSpeed() == marine2.getAttackSpeed()
                        && marine.getArmor() == marine2.getArmor()
                        && marine.getAttackIncrementalValue() == marine2.getAttackIncrementalValue()
                        && marine.getArmorIncrementalValue() == marine2.getArmorIncrementalValue()
                        && marine.getMoveSpeed() == marine2.getMoveSpeed()
                        && marine.getTrainTime() == marine2.getTrainTime()
                        && marine.getAttackType() == marine2.getAttackType()
                        && marine.getSize() == marine2.getSize()
        );
    }
}
