import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MementoTests {

    @Test
    public void test1() throws FieldValueUnAcceptableException {
        final Originator originator = new Originator();
        Originator.Memento memento;
        Person person = new Person("Jeon", 25);

        originator.setState(person);
        memento = originator.save();

        person.setAge(26);
        Assertions.assertEquals(
                26,
                originator.getState().getAge()
        );

        originator.restore(memento);
        Assertions.assertEquals(
                25,
                originator.getState().getAge()
        );
    }

    @Test
    public void test2_rollback_expected() {
        final Originator originator = new Originator();
        Originator.Memento memento = null;
        //  create an entity (new)
        Person person = new Person("Jeon", 25);
        try {
            originator.setState(person);
            //  save into memento class
            memento = originator.save();

            //  change field value
            person.setAge(-1);

        } catch (FieldValueUnAcceptableException e) {
            if (memento != null) {
                originator.restore(memento);
            }
        }
        //  check the age value has been roll backed.
        Assertions.assertEquals(
                25,
                originator.getState().getAge()
        );
    }

    @Test
    public void test3_with_caretaker() throws FieldValueUnAcceptableException {
        final List<Originator.Memento> caretaker = new ArrayList<>(3);
        final Originator originator = new Originator();

        Person person = new Person("Jeon", 21);
        originator.setState(person);

        caretaker.add(originator.save());

        person.setAge(31);
        caretaker.add(originator.save());

        person.setName("George");
        caretaker.add(originator.save());

        originator.restore(caretaker.get(0));
        Assertions.assertEquals(
                new Person("Jeon", 21),
                originator.getState()
        );
    }
}
