interface File {

    String getFilename();
    String getPath();
}

class Xml implements File {
    private final String filename;
    private final String path;

    public Xml(String filename, String path) {
        this.filename = filename;
        this.path = path;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public String getPath() {
        return path;
    }
}

class Json implements File {

    private final String filename;
    private final String path;

    public Json(String filename, String path) {
        this.filename = filename;
        this.path = path;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public String getPath() {
        return path;
    }
}

class Csv implements File {

    private final String filename;
    private final String path;

    public Csv(String filename, String path) {
        this.filename = filename;
        this.path = path;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public String getPath() {
        return path;
    }
}

class Text implements File {

    private final String filename;
    private final String path;

    public Text(String filename, String path) {
        this.filename = filename;
        this.path = path;
    }


    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public String getPath() {
        return path;
    }
}