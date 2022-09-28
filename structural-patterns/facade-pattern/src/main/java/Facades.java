import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

interface YoutubeConverter {

    void convert(String url) throws IOException;
}

class YoutubeConverterImpl implements YoutubeConverter {

    @Override
    public void convert(String url) throws IOException {
        //  parse url, get video id
        String videoId = YoutubeParser.parse(url);
        //  call youtube api
        YoutubeVideo videoInfo = YoutubeApi.load(url, videoId);
        //  write file
        Path path = Paths.get("");
        Files.write(path, videoInfo.getBytes());
    }
}

class YoutubeParser {

    public static String parse(String url) {
        return url.substring(
                url.indexOf("?id=")
        );
    }
}

class YoutubeApi {

    private final static String apiKey = "9d-afsmgk4d6wn7qo1dkeq2wd";
    public static YoutubeVideo load(String videoUrl, String videoId) throws IOException {
        //  load Youtube video info...
        /*
        URL url = new URL(videoUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setUseCaches(false);
        conn.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
        outputStream.writeBytes("?apiKey=" + apiKey);
        outputStream.close();

        InputStream in = conn.getInputStream();
         */
        //  ... and so on
        return new YoutubeVideo(
                videoId,
                (int) (Math.random() * 1000),
                (int) (Math.random() * 100),
                (int) (Math.random() * 100000),
                new byte[]{}
        );
    }
}

class YoutubeVideo {
    private final String videoId;
    private final int likes;
    private final int dislikes;
    private final int views;
    private final byte[] bytes;
    //  ... and so on

    public YoutubeVideo(String videoId, int likes, int dislikes, int views, byte[] bytes) {
        this.videoId = videoId;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
        this.bytes = bytes;
    }

    public String getVideoId() {
        return videoId;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getViews() {
        return views;
    }

    public byte[] getBytes() {
        return bytes;
    }
}