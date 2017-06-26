/**
 * Created by Song on 6/13/2017.
 */

public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> newDeque= new ArrayDequeSolution<Character>();
        for(int i=0;i<word.length();i++){
            newDeque.addLast(word.charAt(i));
        }
        return newDeque;
    }
    private static boolean helperFunction(Deque<Character> newDeque){
        if(newDeque.size()<=0){
            return true;
        }else{

            if(newDeque.removeFirst()==newDeque.removeLast()){
                helperFunction(newDeque);

            }else{
                return false;
            }

            return true;

        }
    }

    public static boolean isPalindrome(String word){
        Deque<Character> newDeque= wordToDeque(word);
        boolean returnValue=helperFunction(newDeque);
        return returnValue;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> newDeque = wordToDeque(word);
        // here i try to solve the problem iteratively instead of recursively
        int length = newDeque.size();
        for(int i=0; i<= (Math.ceil((length-1)/2)-1);i++){
            if(!cc.equalChars(newDeque.get(i), newDeque.get(length-1-i))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        OffByOne newComparator = new OffByOne();
        System.out.println(isPalindrome("fe", newComparator));
    }


}
