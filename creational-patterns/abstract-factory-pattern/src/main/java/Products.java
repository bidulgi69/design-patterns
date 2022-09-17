interface Cuisine {

}

interface Sauce {

}

class Chimaek implements Cuisine {

    @Override
    public String toString() {
        return "Korean Food: Chimaek";
    }
}

class Okonomiyaki implements Cuisine {

    @Override
    public String toString() {
        return "Japanese Food: Okonomiyaki";
    }
}

class RiceNoodle implements Cuisine {

    @Override
    public String toString() {
        return "Vietnamese Food: Rice Noodle";
    }
}

class Kochujang implements Sauce {

    @Override
    public String toString() {
        return "Korean Sauce: Kochujang";
    }
}

class Teriyaki implements Sauce {

    @Override
    public String toString() {
        return "Japanese Sauce: Teriyaki";
    }
}

class NuocMamGung implements Sauce {

    @Override
    public String toString() {
        return "Vietnamese Sauce: Nuoc Nam Gung";
    }
}