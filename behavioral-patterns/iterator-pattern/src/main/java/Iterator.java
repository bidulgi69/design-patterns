interface Iterator<T> {
    T next();
    boolean hasNext();
}

class ClassroomIterator implements Iterator<Student> {

    private final Classroom classroom;
    private int offset;

    public ClassroomIterator(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public Student next() {
        return classroom.get(offset++);
    }

    @Override
    public boolean hasNext() {
        return classroom.getLength() > offset;
    }
}
