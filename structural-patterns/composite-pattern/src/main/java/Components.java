interface Product {

    int getPrice();
}

class MonsterEnergy implements Product {
    private final int price;

    public MonsterEnergy(int price) {
        this.price = price;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
}

class Cheetos implements Product {
    private final int price;

    public Cheetos(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}

class Nutella implements Product {
    private final int price;

    public Nutella(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}