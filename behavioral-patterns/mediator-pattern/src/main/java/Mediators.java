import java.time.Duration;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

interface Mediator<T> {

    void notify(Component component, LocalDateTime ldt);
    T[] getComponents();
}

class Reception implements Mediator<LocalDateTime> {
    private final PriorityQueue<LocalDateTime> schedules;
    private LocalDateTime lastSchedule = null;

    public Reception() {
        schedules = new PriorityQueue<>(LocalDateTime::compareTo);
    }

    @Override
    public void notify(Component component, LocalDateTime ldt) {
        LocalDateTime now = LocalDateTime.now();
        schedules.removeIf(schd -> schd.isBefore(now));

        System.out.println("Scheduling request from:: " + component.getCallerName());
        if (ldt.isAfter(now)) {
            if (lastSchedule == null) {
                schedules.add(ldt);
            } else {
                lastSchedule = lastSchedule.plus(Duration.between(lastSchedule, ldt));
                schedules.add(lastSchedule);
            }
        }
    }

    public LocalDateTime[] getComponents() {
        return schedules.toArray(LocalDateTime[]::new);
    }
}