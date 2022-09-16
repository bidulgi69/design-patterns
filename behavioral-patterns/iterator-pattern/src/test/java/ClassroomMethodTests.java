import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassroomMethodTests {

    @Test
    public void enter_and_get_test() {
        Classroom classroom = new Classroom(1);
        Student student = new Student("Joe", 18);
        classroom.enter(student);

        Assertions.assertEquals(student, classroom.get(0));
    }

    @Test
    public void enter_expects_iob_exception() {
        Classroom classroom = new Classroom(1);
        classroom.enter(new Student("Joe", 18));
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> classroom.enter(new Student("Joe", 18)));
    }

    @Test
    public void get_expects_iob_exception() {
        Classroom classroom = new Classroom(1);
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> classroom.get(1));
    }
}
