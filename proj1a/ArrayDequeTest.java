/**
 * Created by Song on 5/22/2017.
 */
public class ArrayDequeTest {


    public static void main(String[] args){
        ArrayDeque<String> newList= new ArrayDeque<String>();

        System.out.println("Size of the newlist is " + newList.size());


        newList.addFirst("0");
        newList.addFirst("1");
        newList.addFirst("2");
        newList.addLast("-1");
        newList.addLast("-2");

        String haha= newList.removeFirst();
        String haha2=newList.removeFirst();

        newList.printDeque();
        System.out.println("Size of the newlist is " + newList.size()+ newList.isEmpty());

        System.out.println("The 3rd Item in the list is: " + newList.get(0));




    }

}
