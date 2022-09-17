import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class TerranBionicUnit implements Cloneable {
    private final String name;
    private final int hp;
    private final int mp;
    private final int attack;
    private final float attackSpeed;
    private final int armor;
    private final int attackIncrementalValue;
    private final int armorIncrementalValue;
    private final float moveSpeed;
    private final int trainTime;
    private final AttackType attackType;
    private final UnitSize size;

    public TerranBionicUnit(
            String name,
            int hp,
            int mp,
            int attack,
            float attackSpeed,
            int armor,
            int attackIncrementalValue,
            int armorIncrementalValue,
            float moveSpeed,
            int trainTime,
            AttackType attackType,
            UnitSize size
    ) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
        this.armor = armor;
        this.attackIncrementalValue = attackIncrementalValue;
        this.armorIncrementalValue = armorIncrementalValue;
        this.moveSpeed = moveSpeed;
        this.trainTime = trainTime;
        this.attackType = attackType;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Terran Bionic unit(%s): " +
                        "[hp: %d, mp: %d, attack: %d, attackSpeed: %f, armor: %d, attackIncrementalValue: %d, armorIncrementalValue: %d, moveSpeed: %f, trainTime: %d, attackType: %s, unitSize: %s\n",
                name,
                hp,
                mp,
                attack,
                attackSpeed,
                armor,
                attackIncrementalValue,
                armorIncrementalValue,
                moveSpeed,
                trainTime,
                attackType.toString(),
                size
        );
    }

    @Override
    public TerranBionicUnit clone() {
        return new TerranBionicUnit(
                name,
                hp,
                mp,
                attack,
                attackSpeed,
                armor,
                attackIncrementalValue,
                armorIncrementalValue,
                moveSpeed,
                trainTime,
                attackType,
                size
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                hp,
                mp,
                attack,
                attackSpeed,
                armor,
                attackIncrementalValue,
                armorIncrementalValue,
                moveSpeed,
                trainTime,
                attackType,
                size
        );
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getAttack() {
        return attack;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public int getArmor() {
        return armor;
    }

    public int getAttackIncrementalValue() {
        return attackIncrementalValue;
    }

    public int getArmorIncrementalValue() {
        return armorIncrementalValue;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public int getTrainTime() {
        return trainTime;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public UnitSize getSize() {
        return size;
    }
}

class Barrack {
    private final Queue<TerranBionicUnit> barracks;

    public Barrack() {
        this.barracks = new LinkedList<>();
    }

    public void train(TerranBionicUnit unit) {
        if (barracks.size() < 5) {
            barracks.add(unit);
        }
    }

    public TerranBionicUnit emit() {
        return barracks.poll();
    }

    public void clear() {
        barracks.clear();
    }

    public int getSize() {
        return barracks.size();
    }

    public TerranBionicUnit getPeek() {
        return barracks.peek();
    }
}

enum UnitSize {
    SMALL,
    MEDIUM,
    LARGE
}

enum AttackType {
    NORMAL,
    EXPLOSIVE,
    CONCUSSIVE,
    SPELL
}