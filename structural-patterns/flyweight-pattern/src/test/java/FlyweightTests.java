import org.junit.jupiter.api.Test;

public class FlyweightTests {

    static final String signal = "signal";
    static final String qm = "qm";
    static final String infantry = "infantry";

    @Test
    public void test1() {
        Squad squad = new Squad();
        squad.train(signal, "Jack");
        squad.train(infantry, "Llois");
        squad.train(infantry, "Peggy");
        squad.train(infantry, "Kevin");
        squad.train(qm, "Trois");
        squad.train(qm, "Aaron");
        squad.train(qm, "Devon");

        squad.doAction();
    }
}
