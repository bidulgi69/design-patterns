interface Aggregate<T> {
    Iterator<T> iterator();
}


class Classroom implements Aggregate<Student> {
    private final Student[] students;
    private int offset;

    public Classroom(int n) {
        students = new Student[n];
        offset = 0;
    }

    public void enter(Student s) throws ArrayIndexOutOfBoundsException {
        students[offset++] = s;
    }

    public Student get(int offset) throws ArrayIndexOutOfBoundsException {
        return students[offset];
    }

    public int getLength() {
        return students.length;
    }

    @Override
    public Iterator<Student> iterator() {
        return new ClassroomIterator(this);
    }
}
