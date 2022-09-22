import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

interface Component {

    void reserve();
    String getCallerName();
}

class Nurse implements Component {
    private final Mediator<LocalDateTime> mediator;

    public Nurse(Mediator<LocalDateTime> mediator) {
        this.mediator = mediator;
    }

    @Override
    public void reserve() {
        mediator.notify(this, LocalDateTime.now().plus(5, ChronoUnit.SECONDS));
    }

    @Override
    public String getCallerName() {
        return "Nurse";
    }
}

class FrontDesk implements Component {
    private final Mediator<LocalDateTime> mediator;

    public FrontDesk(Mediator<LocalDateTime> mediator) {
        this.mediator = mediator;
    }

    @Override
    public void reserve() {
        mediator.notify(this, LocalDateTime.now().plus(10, ChronoUnit.MINUTES));
    }

    @Override
    public String getCallerName() {
        return "FrontDesk";
    }
}