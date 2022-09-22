import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitorTests {

    @Test
    public void test1() {
        try {
            Resources resources = new Resources();

            Element xmlResource = new XmlResource("root-context.xml");
            Element prodYamlResource = new YamlResource("application-prod.yaml");
            Element metadataResource = new JsonResource("metadata.json");
            Element devYamlResource = new YamlResource("application-dev.yaml");

            resources.addResource(xmlResource);
            resources.addResource(prodYamlResource);
            resources.addResource(devYamlResource);
            resources.addResource(metadataResource);

            Visitor classpathLoader = new ClasspathResourceLoader();
            resources.accept(classpathLoader);

            Assertions.assertTrue(xmlResource.isVisited());
            Assertions.assertTrue(prodYamlResource.isVisited());
            Assertions.assertTrue(devYamlResource.isVisited());
            Assertions.assertTrue(metadataResource.isVisited());

            Assertions.assertEquals(1, RootContext.numOfXmlResources);
            Assertions.assertEquals(2, RootContext.numOfYamlResources);
            Assertions.assertEquals(1, RootContext.numOfJsonResources);

        } catch (FileExtensionNotSupportedException ignored) { }
    }
}
