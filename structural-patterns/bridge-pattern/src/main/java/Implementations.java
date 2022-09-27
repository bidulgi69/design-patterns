interface AttackType {

    int calcDamage(UnitSizeType target, int armor, int damage);
}

class Normal implements AttackType {

    @Override
    public int calcDamage(UnitSizeType target, int armor, int damage) {
        return damage - armor;
    }
}

class Explosive implements AttackType {

    @Override
    public int calcDamage(UnitSizeType target, int armor, int damage) {
        int defenseless = damage - armor;
        switch (target) {
            case SMALL: return (int) (defenseless * 0.5);
            case MEDIUM: return (int) (defenseless * 0.75);
            case LARGE:
            default: return defenseless;
        }
    }
}

class Concussive implements AttackType {

    @Override
    public int calcDamage(UnitSizeType target, int armor, int damage) {
        int defenseless = damage - armor;
        switch (target) {
            case MEDIUM: return (int) (defenseless * 0.5);
            case LARGE: return (int) (defenseless * 0.25);
            case SMALL:
            default: return defenseless;
        }
    }
}

enum UnitSizeType {
    SMALL,
    MEDIUM,
    LARGE
}