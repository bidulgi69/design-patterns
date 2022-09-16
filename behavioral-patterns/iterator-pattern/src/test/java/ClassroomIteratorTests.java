import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassroomIteratorTests {

    @Test
    public void test1() {
        Classroom classroom = new Classroom(3);
        classroom.enter(new Student("Joe", 18));
        classroom.enter(new Student("Hue", 16));
        classroom.enter(new Student("Aaron", 19));

        Iterator<Student> it = classroom.iterator();
        int iterated = 0;
        while (it.hasNext()) {
            iterated++;
            System.out.println(it.next());
        }

        Assertions.assertEquals(3, iterated);
    }
}
