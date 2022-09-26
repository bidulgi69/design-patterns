import java.util.HashMap;
import java.util.Map;

//  adaptee
final class XmlContentParser {

    public Map<String, Object> parse(Xml content) {
        final Map<String, Object> result = new HashMap<>();
        result.put("filename",  content.getFilename());
        result.put("path", content.getPath());
        //  ...
        return result;
    }
}