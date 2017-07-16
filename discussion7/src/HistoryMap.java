import java.util.HashMap;
import java.util.Stack;

public class HistoryMap<K, V> extends HashMap<K, V> {
    Stack<Operation> history = new Stack<>();
    class Operation { /* Helper class */
        /* Place fields/variables here */
        boolean shouldRemove;
        K key;
        V value;
        /* Place the constructor here */
        Operation (boolean shouldRemove, K key, V value) {
            this.shouldRemove = shouldRemove;
            this.key = key;
            this.value = value;
        }
    }
/** Remember that in a HashMap, a null value is valid */
    @Override
    public V put(K key, V value) {
        history.push(new Operation(!containsKey(key), key, super.get(key)));
        return super.put(key, value);
    }
    @Override
    public V remove(Object key) {
        history.push(new Operation(false, (K) key, super.get(key)));
        return super.remove(key);
    }
// Continues on next page
/**
    @Override
    public boolean containsKey(K key) {
        return super.containsKey(key);
    }
*/
    public void undo() {
        if (history.isEmpty()) {
            return;
        }
        Operation op = history.pop();
        if (op.shouldRemove) {
            super.remove(op.key);
        } else {
            super.put(op.key, op.value);
        }
    }
    public static void main(String[] args) {
        HistoryMap<String, Integer> h = new HistoryMap<>();
        h.put("party", 1);
        h.put("parrot", 2);
        h.put("conga", 4);
        h.put("parrot", 3);
        h.undo();
        h.undo();
        System.out.println(h); // Output: {parrot=2, party=1}
        h.remove("party");
        h.undo();
        System.out.println(h); // Output: {parrot=2, party=1}
    }
}
