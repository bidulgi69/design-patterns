import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrategyTests {

    @Test
    public void test1() {
        Investor institution = new Institution(100f);
        Investor bystander = new Insider(30f);
        Investor me = new GeneralInvestor(10f);

        institution.setInvestmentStrategy(new ShortInvestment(1.98f));
        bystander.setInvestmentStrategy(new LongInvestment(2.36f));
        me.setInvestmentStrategy(new ScalpingInvestment(2.11f));

        final float[] APLD = new float[]{ 2.08f, 2.09f, 2.10f, 2.11f, 2.12f, 2.10f, 2.06f, 2.04f, 1.98f, 2.0f };
        for (int i = 1; i < APLD.length; i++) {
            institution.decide(APLD, i);
            bystander.decide(APLD, i);
            me.decide(APLD, i);
        }

        System.out.printf("Institution: %f\n", institution.getCapital());
        System.out.printf("Insider: %f\n", bystander.getCapital());
        System.out.printf("Me: %f\n", me.getCapital());

        //  APES CAN NEVER WIN AGAINST INSTITUTION
        Assertions.assertTrue(me.getCapital() < institution.getCapital());
    }
}
