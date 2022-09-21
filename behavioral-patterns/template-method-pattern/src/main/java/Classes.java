abstract class DailyRoutine {

    void routine() {
        try {
            shower();
            rest();
            work();
            rest();
            shower();
            sleep();
        } catch (InterruptedException ignored) {}
    }

    abstract void shower() throws InterruptedException;
    abstract void rest() throws InterruptedException;
    abstract void work() throws InterruptedException;
    abstract void sleep() throws InterruptedException;

    abstract String[] getRoutines();
}

class WeekendRoutine extends DailyRoutine {

    private final String[] routines = new String[6];
    private int offset = 0;

    @Override
    void shower() throws InterruptedException {
        System.out.println("Taking a shower...");
        Thread.sleep(500);
        System.out.println("Shower done!");
        routines[offset] = offset++ + "shower";
    }

    @Override
    void rest() throws InterruptedException {
        System.out.println("Rest...");
        Thread.sleep(1000);
        System.out.println("Done!");
        routines[offset] = offset++ + "rest";
    }

    @Override
    void work() {
        System.out.println("I don't work on weekends!");
        routines[offset] = offset++ + "work";
    }

    @Override
    void sleep() throws InterruptedException {
        System.out.println("Going to bed...");
        Thread.sleep(3000);
        System.out.println("I wake up!");
        routines[offset] = offset++ + "sleep";
    }

    @Override
    String[] getRoutines() {
        return routines;
    }
}

class WeekdayRoutine extends DailyRoutine {

    private final String[] routines = new String[6];
    private int offset;

    @Override
    void shower() throws InterruptedException {
        System.out.println("Taking a shower...");
        Thread.sleep(500);
        System.out.println("Shower done!");
        routines[offset] = offset++ + "shower";
    }

    @Override
    void rest() throws InterruptedException {
        System.out.println("Rest...");
        Thread.sleep(500);
        System.out.println("Done!");
        routines[offset] = offset++ + "rest";
    }

    @Override
    void work() throws InterruptedException {
        System.out.println("Start to work...");
        Thread.sleep(1500);
        System.out.println("Get off work!");
        routines[offset] = offset++ + "work";
    }

    @Override
    void sleep() throws InterruptedException {
        System.out.println("Going to bed...");
        Thread.sleep(2000);
        System.out.println("I wake up!");
        routines[offset] = offset++ + "sleep";
    }

    @Override
    String[] getRoutines() {
        return routines;
    }
}