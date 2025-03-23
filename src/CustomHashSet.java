import java.util.LinkedList;

public class CustomHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<T>[] buckets;
    private int size;

    public CustomHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(T key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void add(T key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
            size++;
            if ((double) size / buckets.length > LOAD_FACTOR) {
                resize();
            }
        }
    }

    public void remove(T key) {
        int index = hash(key);
        if (buckets[index] != null && buckets[index].remove(key)) {
            size--;
        }
    }

    public boolean contains(T key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].contains(key);
    }

    private void resize() {
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T key : bucket) {
                    add(key);
                }
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T key : bucket) {
                    sb.append(key).append(", ");
                }
            }
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
