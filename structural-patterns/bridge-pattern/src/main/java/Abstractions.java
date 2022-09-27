abstract class Unit {

    abstract int attack(Unit target);
    abstract UnitSizeType getSize();
    abstract int getArmor();
}

class Ghost extends Unit {
    private final AttackType attackType;
    private final int damage;
    private final int armor;
    private final UnitSizeType size;

    public Ghost(AttackType attackType, int damage, int armor, UnitSizeType size) {
        this.attackType = attackType;
        this.damage = damage;
        this.armor = armor;
        this.size = size;
    }

    @Override
    public int attack(Unit target) {
        return attackType.calcDamage(target.getSize(), target.getArmor(), damage);
    }

    @Override
    public UnitSizeType getSize() {
        return size;
    }

    @Override
    public int getArmor() {
        return armor;
    }
}

class Marine extends Unit {
    private final AttackType attackType;
    private final int damage;
    private final int armor;
    private final UnitSizeType size;

    public Marine(AttackType attackType, int damage, int armor, UnitSizeType size) {
        this.attackType = attackType;
        this.damage = damage;
        this.armor = armor;
        this.size = size;
    }

    @Override
    public int attack(Unit target) {
        return attackType.calcDamage(target.getSize(), target.getArmor(), damage);
    }

    @Override
    public UnitSizeType getSize() {
        return size;
    }

    @Override
    public int getArmor() {
        return armor;
    }
}

class Firebat extends Unit {
    private final AttackType attackType;
    private final int damage;
    private final int armor;
    private final UnitSizeType size;

    public Firebat(AttackType attackType, int damage, int armor, UnitSizeType size) {
        this.attackType = attackType;
        this.damage = damage;
        this.armor = armor;
        this.size = size;
    }

    @Override
    public int attack(Unit target) {
        return attackType.calcDamage(target.getSize(), target.getArmor(), damage);
    }

    @Override
    public UnitSizeType getSize() {
        return size;
    }

    @Override
    public int getArmor() {
        return armor;
    }
}

class Vulture extends Unit {
    private final AttackType attackType;
    private final int damage;
    private final int armor;
    private final UnitSizeType size;

    public Vulture(AttackType attackType, int damage, int armor, UnitSizeType size) {
        this.attackType = attackType;
        this.damage = damage;
        this.armor = armor;
        this.size = size;
    }

    @Override
    public int attack(Unit target) {
        return attackType.calcDamage(target.getSize(), target.getArmor(), damage);
    }

    @Override
    public UnitSizeType getSize() {
        return size;
    }

    @Override
    public int getArmor() {
        return armor;
    }
}