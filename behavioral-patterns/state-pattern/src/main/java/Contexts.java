import java.util.LinkedList;
import java.util.Queue;

interface Context {
    void setState(State state);
    State getState();
    Color[] transition();
}

class TrafficLight implements Context {
    private State state;

    public TrafficLight() {
        this.state = new RedLight();
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Color[] transition() {
        return state.transition(this);
    }
}

final class Traffic {
    static Queue<Movable> cars = new LinkedList<>();
    static Queue<Movable> pedestrians = new LinkedList<>();

    public Traffic() {
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        pedestrians.add(new Pedestrian());
        pedestrians.add(new Pedestrian());
        pedestrians.add(new Pedestrian());
    }
}

interface Movable {
    void stop();
    void move();
    void ready();
    //  0: 정지
    //  1: 서행, 대기
    //  2: 움직이는 중
    int getMovingStep();
}

class Pedestrian implements Movable {
    private int movingStep = 0;

    @Override
    public void stop() {
        movingStep = 0;
    }

    @Override
    public void move() {
        movingStep = 2;
    }

    @Override
    public void ready() {
        movingStep = 1;
    }

    @Override
    public int getMovingStep() {
        return movingStep;
    }
}

class Car implements Movable {
    private int movingStep = 2;

    @Override
    public void stop() {
        movingStep = 0;
    }

    @Override
    public void move() {
        movingStep = 2;
    }

    @Override
    public void ready() {
        movingStep = 1;
    }

    @Override
    public int getMovingStep() {
        return movingStep;
    }
}