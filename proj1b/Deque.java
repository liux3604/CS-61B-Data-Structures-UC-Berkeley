/**
 * Created by Song on 6/13/2017.
 */
public interface Deque <Item>{
    public void addFirst(Item item );
    public void addLast(Item item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
    public Item getRecursive(int i);

}
