/**
 * Created by Song on 6/13/2017.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        if((x-y)==1 || (x-y)==-1){
            return true;
        }else{
            return false;
        }
    }
}
