interface Observer {
    void notify(String changed);
}

class Subscriber implements Observer {
    private final int id;

    public Subscriber(int id) {
        this.id = id;
    }

    @Override
    public void notify(String changed) {
        System.out.printf("Subscriber(%d):\tSubscribe a message from publisher: %s\n", id, changed);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subscriber) {
            return obj == this;
        } else return false;
    }
}
