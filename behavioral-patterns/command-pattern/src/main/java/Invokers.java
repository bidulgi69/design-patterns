class MusicPlayer {

    private PlayMode playingMode = PlayMode.RANDOM;
    private final String[] musics;
    private int currentMusicIndex = 0;
    private boolean isPlaying = false;

    public MusicPlayer(String[] musics) {
        this.musics = musics;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlayingMode(PlayMode playingMode) {
        this.playingMode = playingMode;
    }

    public void setCurrentMusicIndex(int index) {
        currentMusicIndex = index;
    }

    public String play() {
        if (isPlaying) {
            switch (playingMode) {
                case RANDOM:
                    int rand = (int) (Math.random() * (musics.length));
                    return musics[rand % musics.length];
                case SEQUENTIAL:
                    return musics[currentMusicIndex++ % musics.length];
                default:
                    return musics[currentMusicIndex];
            }
        } else {
            //  not playing...
            return null;
        }
    }

    public void on() {
        isPlaying = true;
    }

    public void off() {
        isPlaying = false;
    }
}

enum PlayMode {
    RANDOM,
    SEQUENTIAL,
    NONE;
}