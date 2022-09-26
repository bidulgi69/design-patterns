import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AdapterTests {

    @Test
    public void test1() {
        //  create adaptee
        XmlContentParser adaptee = new XmlContentParser();

        //  load file that I want to apply `parse()` function.
        final String filename = "web";
        final String path = "usr/bin";
        Json json = new Json(filename, path);
        //  create xml file with same context.
        Xml xml = new Xml(filename, path);

        //  create target
        IAdapter<Json> target = new JsonToXmlAdapter(adaptee);

        //  client requests to target interface
        Map<String, Object> jsonParseResult = target.parse(json);
        //  compare with result through adapter.
        Map<String, Object> xmlParseResult = adaptee.parse(xml);

        //  verify
        Assertions.assertEquals(
                filename,
                jsonParseResult.getOrDefault("filename", "")
        );
        Assertions.assertEquals(
                path,
                jsonParseResult.getOrDefault("path", "")
        );

        Assertions.assertEquals(
                jsonParseResult.get("filename"),
                xmlParseResult.get("filename")
        );
        Assertions.assertEquals(
                jsonParseResult.get("path"),
                xmlParseResult.get("path")
        );
    }
}
