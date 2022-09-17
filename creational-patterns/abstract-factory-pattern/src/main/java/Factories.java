interface AbstractChefFactory {
    Cuisine createCuisine();
    Sauce createSauce();
}

class KoreanChefFactory implements AbstractChefFactory {

    @Override
    public Cuisine createCuisine() {
        return new Chimaek();
    }

    @Override
    public Sauce createSauce() {
        return new Kochujang();
    }
}

class JapaneseChefFactory implements AbstractChefFactory {

    @Override
    public Cuisine createCuisine() {
        return new Okonomiyaki();
    }

    @Override
    public Sauce createSauce() {
        return new Teriyaki();
    }
}

class VietnameseChefFactory implements AbstractChefFactory {

    @Override
    public Cuisine createCuisine() {
        return new RiceNoodle();
    }

    @Override
    public Sauce createSauce() {
        return new NuocMamGung();
    }
}

class Restaurant {
    public static Cuisine getCuisine(AbstractChefFactory factory) {
        return factory.createCuisine();
    }

    public static Sauce getSauce(AbstractChefFactory factory) {
        return factory.createSauce();
    }
}