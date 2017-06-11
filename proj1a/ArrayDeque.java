/**
 * Created by Song on 5/22/2017.
 */

/**
 * Many functions in this class has not been fully tested for overflow and underflow
 * I plan to thoroughly test it in Lab 3
 * */


import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDeque<Item> {

    private Item[] arrayList;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque(){
        arrayList= (Item[]) new Object[8];
        size=0;
        head=0;
        tail=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }


    public void printDeque(){
        System.out.println("===================");

        for(int i=0;i<size;i++){
            int tempIndex= (head+i)%arrayList.length;
            System.out.print(arrayList[tempIndex]+ " ");
        }
        System.out.println("\n===================");
    }

    public void addFirst(Item x){

        arrayList[tail]=x;
        tail= (tail+1)%(arrayList.length);
        size++;
    }


    public void addLast(Item x){
        int newindex= (head-1)%(arrayList.length)+((head-1)<0 ? arrayList.length: 0);
        arrayList[newindex]= x;
        head= newindex;
        size++;
    }


    public Item removeFirst(){
        int tempIndex= (tail-1)%arrayList.length + ((tail-1<0)? arrayList.length:0);
        tail= tempIndex;
        size--;
        Item returnedValue= arrayList[tail];
        arrayList[tail]=null;
        return returnedValue;
    }


    public Item removeLast(){
        int tempIndex = (head+1)%arrayList.length;
        Item returnedValue= arrayList[head];
        head= tempIndex;
        size--;

        return returnedValue;
    }

    public Item get(int index){
        int tempIndex= (head+index)%arrayList.length;
        return arrayList[tempIndex];
    }


}
