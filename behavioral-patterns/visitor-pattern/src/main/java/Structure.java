import java.util.LinkedList;
import java.util.List;

//  object structure
class Resources extends Element {
    private final List<Element> resources;

    public Resources() {
        this.resources = new LinkedList<>();
    }

    public void addResource(Element resource) {
        resources.add(resource);
    }

    @Override
    public void accept(Visitor v) {
        resources.forEach(resource -> resource.accept(v));
    }
}