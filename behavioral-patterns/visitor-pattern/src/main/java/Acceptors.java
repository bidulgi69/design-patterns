abstract class Element {

    //  로직 실행(구현)을 Visitor 에게 위임함.
    abstract void accept(Visitor v);
    String getFilename() {
        return null;
    }

    boolean isVisited() {
        return false;
    }
}

class XmlResource extends Element {
    private final String filename;
    private boolean isVisited = false;

    public XmlResource(String filename) throws FileExtensionNotSupportedException {
        if (filename.endsWith(".xml") || filename.endsWith(".xmlns")) this.filename = filename;
        else throw new FileExtensionNotSupportedException(
                "Extension: " + filename.substring(filename.lastIndexOf('.')) + " is not supported."
        );
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
        isVisited = true;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public boolean isVisited() {
        return isVisited;
    }
}

class YamlResource extends Element {
    private final String filename;
    private boolean isVisited = false;

    public YamlResource(String filename) throws FileExtensionNotSupportedException {
        if (filename.endsWith(".yaml") || filename.endsWith(".yml")) this.filename = filename;
        else throw new FileExtensionNotSupportedException(
                "Extension: " + filename.substring(filename.lastIndexOf('.')) + " is not supported."
        );
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
        isVisited = true;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public boolean isVisited() {
        return isVisited;
    }
}

class JsonResource extends Element {
    private final String filename;
    private boolean isVisited = false;

    public JsonResource(String filename) throws FileExtensionNotSupportedException {
        if (filename.endsWith(".json")) this.filename = filename;
        else throw new FileExtensionNotSupportedException(
                "Extension: " + filename.substring(filename.lastIndexOf('.')) + " is not supported."
        );
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        isVisited = true;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public boolean isVisited() {
        return isVisited;
    }
}