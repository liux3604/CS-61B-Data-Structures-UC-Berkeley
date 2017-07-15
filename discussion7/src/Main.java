import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Given an integer x and a sorted array A[] of N distinct integers, design an algorithm to find if there
        // exists indices i and j such that A[i] + A[j] == x.

    }

    //naive solution
    public static boolean existX(int[]A,int x){
        int N=A.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(A[i]+A[j]==x){
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] overlappingArray(int[] A, int[] B){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int k: A){
            if(map.get(k)!=null){
                map.put(k,map.get(k)+1);
            }
        }
        for(int k: B){
            if(map.get(k)!=null){
                map.put(k,map.get(k)+1);
            }
        }
        Set<Integer> keySet = map.keySet();
        int size= keySet.size();
        int[] newArray = new int[size];
        int i=0;
        for(int key: keySet){
            if(map.get(key)>=2){
                newArray[i]=key;
                i++;
            }
        }

        return newArray;

    }

}
