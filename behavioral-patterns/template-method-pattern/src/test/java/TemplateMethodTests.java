import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemplateMethodTests {

    @Test
    public void test1_weekend_routine() {
        DailyRoutine weekendRoutine = new WeekendRoutine();
        long start = System.currentTimeMillis();
        //  total slept time: 4500ms
        weekendRoutine.routine();
        long end = System.currentTimeMillis();

        Assertions.assertTrue(
                end - start > 4500
        );
    }

    @Test
    public void test2_weekday_routine() {
        DailyRoutine weekdayRoutine = new WeekdayRoutine();
        long start = System.currentTimeMillis();
        //  total slept time: 4500ms
        weekdayRoutine.routine();
        long end = System.currentTimeMillis();

        Assertions.assertTrue(
                end - start > 4500
        );
    }

    @Test
    public void test3_routine_equals() {
        DailyRoutine weekendRoutine = new WeekendRoutine();
        DailyRoutine weekdayRoutine = new WeekdayRoutine();

        weekendRoutine.routine();
        weekdayRoutine.routine();

        String[] weekendRoutines = weekendRoutine.getRoutines();
        String[] weekdayRoutines = weekdayRoutine.getRoutines();
        //  templateMethod 를 통해 순서가 정해지기 때문에,
        //  두 ConcreteClass 의 함수 호출 순서는 동일해야 한다.
        for (int i = 0; i < weekdayRoutines.length; i++) {
            Assertions.assertEquals(
                    weekendRoutines[i],
                    weekdayRoutines[i]
            );
        }
    }
}
