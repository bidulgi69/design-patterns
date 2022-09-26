import java.util.Map;

interface IAdapter<T> {

    Map<String, Object> parse(T from);
}