import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class HashMap <K, V> {
    private MapEntry<K, V>[] arrayOfEntries;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        arrayOfEntries = (MapEntry<K, V>[]) new MapEntry[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashMap() {
        arrayOfEntries = (MapEntry<K, V>[]) new MapEntry[8];
        size = 0;
    }

    /**
     * @param key of the new entry
     * @param value of the new entry
     */
    public void put(K key, V value) {
        MapEntry<K, V> newEntry = new MapEntry<>(key, value);
        int index = index(key);
        if (isFull()) this.expand();
        while(this.arrayOfEntries[index] != null) {
            index++;
            index %= this.arrayOfEntries.length;
        }
        this.arrayOfEntries[index] = newEntry;
        size++;
    }

    /**
     * @param key of the entry
     * @return entry's value
     */
    public V get(K key) {
        int initialIndex = index(key);
        int index = initialIndex;
        while (index != initialIndex - 1) {
            if (this.arrayOfEntries[index] != null && this.arrayOfEntries[index].getKey().equals(key)) {
                return this.arrayOfEntries[index].getValue();
            }
            index++;
            index %= this.arrayOfEntries.length;
        }
        return null;
    }

    /**
     * @param word key
     * @return index of a certain key in HashMap
     */
    private int index (K word) {
        return hashCode(word) & (this.arrayOfEntries.length - 1);
    }

    /**
     * @param word key
     * @return hashcode for the given key
     */
     int hashCode(K word) {
        String str = word.toString();
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * 31 + str.charAt(i);
        }
        return hash;
    }

    /**
     * Expands the existing HashMap twice the size
     * All data is saved and re-hashed to the new map
     */
    @SuppressWarnings("unchecked")
    private void expand() {
        MapEntry<K, V>[] oldEntriesArray = this.arrayOfEntries;
        size = 0;
        this.arrayOfEntries = (MapEntry<K, V>[]) new MapEntry[oldEntriesArray.length * 2];
        for (MapEntry<K, V> oldEntry : oldEntriesArray) {
            if (oldEntry != null) this.put(oldEntry.getKey(), oldEntry.getValue());
        }
    }

    /**
     *
     * @return a String with all contents of the map + it's size
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("HashMap contents:\n");
        for (MapEntry<K, V> entry : this.arrayOfEntries) {
            if (entry == null) {
                output.append("EMPTY\n");
            } else output.append(entry.toString() + "\n");
        }
        output.append("The size is: " + this.size() + "\n");
        return output.toString();
    }

    public boolean isFull() {
        return this.size == this.arrayOfEntries.length;
    }

    public int size() {
        return this.size;
    }

}
