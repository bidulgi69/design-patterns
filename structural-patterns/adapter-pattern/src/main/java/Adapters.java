import java.util.Map;

/**
 *  Composition(구성) 을 통한 Adapter 구현.
 *  Adaptee 를 상속받아 구현하는 class adapter 방식도 존재한다.
 */
class JsonToXmlAdapter implements IAdapter<Json> {

    private final XmlContentParser adaptee;

    public JsonToXmlAdapter(XmlContentParser parser) {
        this.adaptee = parser;
    }

    @Override
    public Map<String, Object> parse(Json from) {
        return adaptee.parse(
                convert(from)
        );
    }

    private Xml convert(Json json) {
        //  format json to xml
        //  ...
        //  and return
        return new Xml(
                json.getFilename(),
                json.getPath()
        );
    }
}

class CsvToXmlAdapter implements IAdapter<Csv> {

    private final XmlContentParser adaptee;

    public CsvToXmlAdapter(XmlContentParser parser) {
        this.adaptee = parser;
    }

    @Override
    public Map<String, Object> parse(Csv from) {
        return adaptee.parse(
                convert(from)
        );
    }

    private Xml convert(Csv csv) {
        //  format csv to xml
        //  ...
        //  and return
        return new Xml(
                csv.getFilename(),
                csv.getPath()
        );
    }

}

class TextToXmlAdapter implements IAdapter<Text> {

    private final XmlContentParser adaptee;

    public TextToXmlAdapter(XmlContentParser parser) {
        this.adaptee = parser;
    }

    @Override
    public Map<String, Object> parse(Text from) {
        return adaptee.parse(
                convert(from)
        );
    }

    private Xml convert(Text text) {
        //  format text to xml
        //  ...
        //  and return
        return new Xml(
                text.getFilename(),
                text.getPath()
        );
    }
}