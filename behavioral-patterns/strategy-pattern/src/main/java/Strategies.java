interface InvestmentStrategy {

    float getTargetPrice();
    float getAveragePrice();
    int getQuantity();
    float decide(float[] ticker, int current);  //  strategy method
    float buy(float price, int quantity);
    float sell(float price, int quantity);
}

class ShortInvestment implements InvestmentStrategy {
    private final float targetPrice;
    private float averagePrice;
    private int borrowing;

    public ShortInvestment(float targetPrice) {
        this.targetPrice = targetPrice;
    }

    @Override
    public float getTargetPrice() {
        return targetPrice;
    }

    @Override
    public float getAveragePrice() {
        return averagePrice;
    }

    @Override
    public int getQuantity() {
        return borrowing;
    }


    @Override
    public float decide(float[] ticker, int current) {
        if (ticker[current] <= targetPrice) {
            return buy(ticker[current], -this.borrowing);
        } else {
            float start = ticker[0];
            int raised = 0;
            for (int i = 0; i <= current; i++) {
                if (start < ticker[i]) raised++;
            }

            if (raised > 3) return sell(ticker[current], (int) (Math.random() * 1000));
        }
        return 0f;
    }

    @Override
    public float buy(float price, int quantity) {
        averagePrice = 0;   //  가지고 있는 차용을 모두 상환처리함.
        borrowing = 0;
        return quantity * -price;
    }

    @Override
    public float sell(float price, int quantity) {
        this.borrowing += quantity;
        return price * quantity;
    }
}

class LongInvestment implements InvestmentStrategy {
    private final float targetPrice;
    private float averagePrice;
    private int quantity;

    public LongInvestment(float targetPrice) {
        this.targetPrice = targetPrice;
    }

    @Override
    public float getTargetPrice() {
        return targetPrice;
    }

    @Override
    public float getAveragePrice() {
        return averagePrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public float decide(float[] ticker, int current) {
        if (current == 0) {
            return buy(ticker[current], (int) (Math.random() * 500));
        } else {
            if (ticker[current] / ticker[0] > 1.2f) {
                return buy(ticker[current], (int) (Math.random() * 200));
            }
        }
        return 0f;
    }

    @Override
    public float buy(float price, int quantity) {
        averagePrice = (averagePrice * this.quantity + price * quantity) / (this.quantity + quantity);
        this.quantity += quantity;
        return quantity * -price;
    }

    @Override
    public float sell(float price, int quantity) {
        this.quantity -= quantity;
        return quantity * price;
    }
}

class ScalpingInvestment implements InvestmentStrategy {
    private final float targetPrice;
    private float averagePrice;
    private int quantity;

    private boolean bought = false;

    public ScalpingInvestment(float targetPrice) {
        this.targetPrice = targetPrice;
    }

    @Override
    public float getTargetPrice() {
        return targetPrice;
    }

    @Override
    public float getAveragePrice() {
        return averagePrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public float decide(float[] ticker, int current) {
        if (ticker[current] == targetPrice) {
            return sell(ticker[current], this.quantity);
        } else {
            if (!bought) {
                bought = true;
                return buy(ticker[current], (int) (Math.random() * 500));
            } else {
                if (ticker[current] / averagePrice > 1.03f) {
                    bought = false;
                    return sell(ticker[current], this.quantity);
                }
            }
        }
        return 0f;
    }

    @Override
    public float buy(float price, int quantity) {
        averagePrice = (averagePrice * this.quantity + price * quantity) / (this.quantity + quantity);
        this.quantity += quantity;
        return quantity * -price;
    }

    @Override
    public float sell(float price, int quantity) {
        this.quantity -= quantity;
        return quantity * price;
    }
}

class LowerLimitInvestment implements InvestmentStrategy {
    private final float targetPrice;
    private float averagePrice;
    private int quantity;

    public LowerLimitInvestment(float targetPrice) {
        this.targetPrice = targetPrice;
    }

    @Override
    public float getTargetPrice() {
        return targetPrice;
    }

    @Override
    public float getAveragePrice() {
        return averagePrice;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public float decide(float[] ticker, int current) {
        if (ticker[current] == targetPrice) {
            return sell(ticker[current], this.quantity);
        } else {
            float price = ticker[0];
            int trendLineOffset = 0;
            for (int i = 1; i < ticker.length; i++) {
                if (price < ticker[i]) {
                    trendLineOffset = i;
                    break;
                }
            }

            if (current - 1 == trendLineOffset) {
                return buy(ticker[current], (int) (Math.random() * 500));
            }
        }
        return 0f;
    }

    @Override
    public float buy(float price, int quantity) {
        averagePrice = (averagePrice * this.quantity + price * quantity) / (this.quantity + quantity);
        this.quantity += quantity;
        return quantity * -price;
    }

    @Override
    public float sell(float price, int quantity) {
        this.quantity -= quantity;
        return quantity * price;
    }
}