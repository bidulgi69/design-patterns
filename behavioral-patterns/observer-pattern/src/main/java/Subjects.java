import java.util.Vector;

interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}

class Publisher implements Subject {
    private final Vector<Observer> observerCollection;
    private String state;

    public Publisher(int n) {
        observerCollection = new Vector<>(n);
    }

    @Override
    public void registerObserver(Observer observer) {
        observerCollection.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerCollection.remove(observer);
    }

    public void setState(String state) {
        this.state = state;
        this.notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerCollection) {
            observer.notify(state);
        }
    }
}
