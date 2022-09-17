import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingletonTests {

    @BeforeEach
    public void initialize() {
        Counter.getInstance().initialize();
    }

    @Test
    public void test1_single_threaded() {
        Counter counter = Counter.getInstance();
        counter.inc();
        Assertions.assertEquals(
                1,
                counter.getCount()
        );

        counter.inc();
        Assertions.assertEquals(
                2,
                counter.getCount()
        );

        counter.dec();
        Assertions.assertEquals(
                1,
                counter.getCount()
        );
    }

    @Test
    public void test2_multi_threaded() {
        Thread t1 = new Thread(new CounterThread(1));
        Thread t2 = new Thread(new CounterThread(2));
        Thread t3 = new Thread(new CounterThread(3));
        Thread t4 = new Thread(new CounterThread(4));
        Thread t5 = new Thread(new CounterThread(5));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(
                Counter.getInstance().getCount(),
                5
        );
    }
}

class CounterThread implements Runnable {

    private final int id;

    public CounterThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Counter counter = Counter.getInstance();
        counter.inc();
        System.out.printf("Job done from Thread(%d)\n", id);
    }
}