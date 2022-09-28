interface HeavyObject {
    void process() throws InterruptedException;
}

class HeavyObjectImpl implements HeavyObject {

    public HeavyObjectImpl() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Initialization succeeds.");
    }

    @Override
    public void process() {
        System.out.println("Processing...");
    }
}

class LazyInitProxy implements HeavyObject {

    private HeavyObject heavyObject = null;

    @Override
    public void process() throws InterruptedException {
        //  프록시를 통해 복잡하거나 무거운 객체를 사용할 때 생성하도록 함. (lazy init)
        if (heavyObject == null) {
            heavyObject = new HeavyObjectImpl();
        }
        heavyObject.process();
    }
}