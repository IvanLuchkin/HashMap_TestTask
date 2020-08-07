import java.util.Map;

final public class MapEntry<K, V> implements  Map.Entry <K, V> {
    private final K key;
    private V value;

    MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        return this.value = value;
    }

    @Override
    public String toString() {
        return ("Key –> " + key + "| Value -> " + value);
    }
}
