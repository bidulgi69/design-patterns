interface Investor {

    float getCapital();
    void decide(float[] ticker, int current);
    void setInvestmentStrategy(InvestmentStrategy strategy);
}

class Institution implements Investor {
    private InvestmentStrategy strategy;
    private float capital;

    public Institution(float capital) {
        this.capital = capital;
    }

    @Override
    public float getCapital() {
        return capital;
    }

    @Override
    public void decide(float[] ticker, int current) {
        this.capital += strategy.decide(ticker, current);
    }

    @Override
    public void setInvestmentStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }
}

class Insider implements Investor {
    private InvestmentStrategy strategy;
    private float capital;

    public Insider(float capital) {
        this.capital = capital;
    }

    @Override
    public float getCapital() {
        return capital;
    }

    @Override
    public void decide(float[] ticker, int current) {
        this.capital += strategy.decide(ticker, current);
    }

    @Override
    public void setInvestmentStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }
}

class GeneralInvestor implements Investor {
    private InvestmentStrategy strategy;
    private float capital;

    public GeneralInvestor(float capital) {
        this.capital = capital;
    }

    @Override
    public float getCapital() {
        return capital;
    }

    @Override
    public void decide(float[] ticker, int current) {
        this.capital += strategy.decide(ticker, current);
    }

    @Override
    public void setInvestmentStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }
}