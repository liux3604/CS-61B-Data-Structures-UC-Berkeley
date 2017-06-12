import java.util.LinkedList;

/**
 * Isn't this solution kinda... cheating? Yes.
 * The aesthete will be especially alarmed by the fact that this
 * supposed ArrayDeque is actually using a LinkedList. SAD!
 */
public class ArrayDequeSolution<Item> extends LinkedList<Item> {
    int size=0;
    public void printDeque() {
        System.out.println("============================");
        for (int i=0; i<size; i++){
            System.out.print(get(i)+" ");
        }
        System.out.println("\n============================");

    }

    public Item getRecursive(int i) {
        return get(i);
    }
    public void addLast(Item item){
        super.add(item);
        size++;
    }
    public void addFirst(Item item){
        super.addFirst(item);
        size++;
    }

    public Item removeFirst() {
        try {
            size--;

            return super.removeFirst();

        } catch (Exception e) {
            return null;
        }
    }

    public Item removeLast() {
        try {
            size--;

            return super.removeLast();

        } catch (Exception e) {
            return null;
        }
    }
}
