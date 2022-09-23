class Originator {
    private Person state;

    public void restore(Memento memento) {
        try {
            Person mem = memento.getState();
            state.setName(mem.getName());
            state.setAge(mem.getAge());
        } catch (FieldValueUnAcceptableException ignored) {}
    }

    public Memento save() {
        return new Memento(state);
    }

    public void setState(Person person) {
        this.state = person;
    }

    public Person getState() {
        return state;
    }
    static class Memento {
        private final Person state;

        public Memento(Person person) {
            this.state = new Person(
                    person.getName(),
                    person.getAge()
            );
        }

        //  Originator 에서만 호출할 수 있도록 접근 제한자 설정.
        private Person getState() {
            return this.state;
        }

    }
}

