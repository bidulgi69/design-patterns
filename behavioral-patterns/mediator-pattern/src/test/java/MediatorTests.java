import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class MediatorTests {

    @Test
    public void test1() {
        try {
            Mediator<LocalDateTime> reception = new Reception();
            //  generate components
            Component nurse1 = new Nurse(reception);
            Component nurse2 = new Nurse(reception);
            Component nurse3 = new Nurse(reception);
            Component frontDesk = new FrontDesk(reception);

            frontDesk.reserve();
            nurse1.reserve();
            nurse2.reserve();

            Thread.sleep(5000);
            nurse3.reserve();

            LocalDateTime[] schedules = reception.getComponents();
            for (LocalDateTime schedule : schedules) {
                System.out.printf("SCHEDULE: %s\n", schedule.toString());
            }

            Assertions.assertEquals(2, schedules.length);
        } catch (InterruptedException ignored) {}
    }

    @Test
    public void test2() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(5);
        pq.add(1);

        System.out.println("PEEK: " + pq.peek());
    }
}
