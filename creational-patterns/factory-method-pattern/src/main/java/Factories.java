interface FruitFactory {

    Fruit getFruit();
}

class GrapeFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Grape();
    }
}

class AppleFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}

class MelonFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Melon();
    }
}

class Wholesaler {
    public static Fruit getFruit(FruitFactory factory) {
        return factory.getFruit();
    }
}