interface Command {
    void execute();
}

class MusicPlayerOnCommand implements Command {
    private final MusicPlayer player;

    public MusicPlayerOnCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.on();
    }
}

class MusicPlayerOffCommand implements Command {
    private final MusicPlayer player;

    public MusicPlayerOffCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.off();
    }
}