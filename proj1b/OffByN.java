/**
 * Created by Song on 6/14/2017.
 */
public class OffByN implements CharacterComparator {
    int N;
    public OffByN(int N) {
        this.N = N;
    }

    public boolean equalChars(char x, char y) {
        if ((x - y) == N || (x - y) == -N) {
            return true;
        } else {
            return false;
        }
    }


}
