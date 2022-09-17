class Cellphone {
    private Command command;

    public Cellphone() {

    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
