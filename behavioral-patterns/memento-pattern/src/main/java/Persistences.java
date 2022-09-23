import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) throws FieldValueUnAcceptableException {
        if (name.isBlank()) {
            throw new FieldValueUnAcceptableException("Name: " + name + " is not acceptable.");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) throws FieldValueUnAcceptableException {
        if (age < 0) {
            throw new FieldValueUnAcceptableException("Age: " + age + " is not acceptable.");
        } else {
            this.age = age;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person o = (Person) obj;
            return this.name.equals(o.name) && this.age == o.age;
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "[Person: " + name + ", " + age + "]";
    }
}

class FieldValueUnAcceptableException extends Throwable {
    public FieldValueUnAcceptableException(String message) {
        super(message);
    }
}