class Counter {
    //  singleton instance
    private static final Counter counter = new Counter();
    private int count;

    private Counter() {
        count = 0;
    }

    public static Counter getInstance() {
        return counter;
    }

    //  multi-thread 환경에서 안전하게 동작할 수 있도록 synchronized 키워드 사용.
    public synchronized void inc() {
        this.count++;
    }

    public synchronized void dec() {
        this.count--;
    }

    public void initialize() {
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }
}