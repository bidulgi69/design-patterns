import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandTests {

    private final String[] musics = {"Call My Name", "Back To May", "Lazy Rooftop", "Like A Fish", "As The World Caves In", "Dialogue"};

    @Test
    public void test1() {
        Cellphone cellphone = new Cellphone();
        MusicPlayer player = new MusicPlayer(musics);

        Command playerOnCommand = new MusicPlayerOnCommand(player);
        Command playerOffCommand = new MusicPlayerOffCommand(player);

        //  test MusicPlayerOnCommand works fine
        Assertions.assertFalse(player.isPlaying());
        Assertions.assertNull(player.play());
        cellphone.setCommand(playerOnCommand);
        cellphone.action(); //  execute command
        Assertions.assertTrue(player.isPlaying());
        Assertions.assertNotNull(player.play());

        //  test MusicPlayerOffCommand works fine
        cellphone.setCommand(playerOffCommand);
        cellphone.action(); //  execute command
        Assertions.assertFalse(player.isPlaying());
        Assertions.assertNull(player.play());
    }

    @Test
    public void test2_music_player() {
        MusicPlayer player = new MusicPlayer(musics);
        player.on();
        player.setPlayingMode(PlayMode.NONE);
        player.setCurrentMusicIndex(3);

        Assertions.assertEquals("Like A Fish", player.play());
    }
}
