import sun.plugin2.jvm.CircularByteBuffer;

/**
 * Created by Song on 5/20/2017.
 */
public class LinkedListDeque<Item> {

    private class ItemNode{
        ItemNode prev;
        ItemNode next;
        Item key;
    }

    private ItemNode circularSentinel;
    private int size;

    public LinkedListDeque(){
        circularSentinel= new ItemNode();
        circularSentinel.next=circularSentinel;
        circularSentinel.prev=circularSentinel;
        size=0;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void addFirst(Item x){
        ItemNode newNode= new ItemNode();
        newNode.key= x;
        newNode.next=circularSentinel.next;
        newNode.prev=circularSentinel;
        circularSentinel.next.prev=newNode;
        circularSentinel.next=newNode;
        size++;
    }

    public void addLast(Item x){
        ItemNode newNode= new ItemNode();
        newNode.key=x;
        newNode.next=circularSentinel;
        newNode.prev=circularSentinel.prev;
        circularSentinel.prev.next=newNode;
        circularSentinel.prev=newNode;
        size++;
    }


    public void printDeque(){
        ItemNode pointer= circularSentinel;
        System.out.println("===================");
        for(int i=0;i<size;i++){
            System.out.print(pointer.next.key + " ");
            pointer=pointer.next;
        }
        System.out.println("\n===================");
    }


    public Item removeFirst(){
        ItemNode temp= circularSentinel.next;
        circularSentinel.next= circularSentinel.next.next;
        circularSentinel.next.prev=circularSentinel;
        size--;
        return  temp.key;

    }

    public Item removeLast(){
        circularSentinel.prev= circularSentinel.prev.prev;
        circularSentinel.prev.next=circularSentinel;
        size--;
        ItemNode temp= circularSentinel.prev;
        return  temp.key;
    }

    //iteratively return the i^th item
    public Item get(int index){
        ItemNode temp= circularSentinel;
        for(int i=0; i<index; i++){
            temp=temp.next;
        }
        return  temp.key;
    }

    private Item getRecursiveHelper(ItemNode node, int index){
        if(index==-1){
            return node.key;
        }else{
            return getRecursiveHelper(node.next, index-1);
        }
    }

    public Item getRecursive(int index){
        return getRecursiveHelper(circularSentinel, index);
    }


/*




*/


}
