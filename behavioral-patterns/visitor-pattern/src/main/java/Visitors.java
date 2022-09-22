interface Visitor {

    void visit(XmlResource resource);
    void visit(YamlResource resource);
    void visit(JsonResource resource);
}

//  acceptor 를 방문하면서, 실제 로직을 적용시킴.
class ClasspathResourceLoader implements Visitor {

    @Override
    public void visit(XmlResource resource) {
        System.out.println("Load Xml resource...: " + resource.getFilename());
        RootContext.numOfXmlResources++;
    }

    @Override
    public void visit(YamlResource resource) {
        System.out.println("Load Yaml resource...: " + resource.getFilename());
        RootContext.numOfYamlResources++;
    }

    @Override
    public void visit(JsonResource resource) {
        System.out.println("Load Json resource...: " + resource.getFilename());
        RootContext.numOfJsonResources++;
    }
}

final class RootContext {
    static int numOfXmlResources = 0;
    static int numOfYamlResources = 0;
    static int numOfJsonResources = 0;
}