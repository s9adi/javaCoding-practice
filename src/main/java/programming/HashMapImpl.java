package programming;

import java.util.NoSuchElementException;

public class HashMapImpl {


}


class Node {
    Integer Key;
    Integer Value;
    Node next;

    Node(Integer key, Integer value) {
        this.Key = key;
        this.Value = value;
    }
}

class HashMap {

    private Node[] buckets;
    private final int CAPACITY = 16;
    private int SIZE = 0;

    public HashMap() {
        buckets = new Node[CAPACITY];
    }

    public static int getIndex(Integer Key) {
        return Key.hashCode() % 16;
    }

    public Integer put(Integer key, Integer value) {
        Integer index = getIndex(key);
        if (buckets[index] == null) {
            Node node = new Node(key, value);
            buckets[index] = node;
            return null; // No previous value
        } else {
            Node traverse = buckets[index];
            Node prev = null;
            while (traverse != null) {
                if (traverse.Key.equals(key)) {
                    Integer oldValue = traverse.Value;
                    traverse.Value = value;
                    return oldValue; // Return the old value
                }
                prev = traverse;
                traverse = traverse.next;
            }
            Node newNode = new Node(key, value);
            prev.next = newNode; // Append the new node
            return null; // No previous value
        }
    }

    public Integer remove(Integer Key) {
        // we have to remove this key
        // find the key using the getIndex
        int index = getIndex(Key);
        if (buckets[index] == null) {
            throw new NoSuchElementException("No Key present");
        }
        Node node = buckets[index];
        Node prev = null;
        while (node != null) {
            if (node.Key.equals(Key)) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    buckets[index] = node.next;
                }
                return node.Value;
            }
            prev = node;
            node = node.next;
        }
        throw new NoSuchElementException("No Key present");
    }



}