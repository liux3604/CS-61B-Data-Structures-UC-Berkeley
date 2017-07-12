public class Main {

    public static void main(String[] args) {

        // Given an integer x and a sorted array A[] of N distinct integers, design an algorithm to find if there
        // exists indices i and j such that A[i] + A[j] == x.



    }

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
}
