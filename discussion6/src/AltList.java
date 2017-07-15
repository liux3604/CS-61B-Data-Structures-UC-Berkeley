import org.junit.Test;
import org.junit.Assert.*;
public class AltList<X, Y> {
    private X item;
    private AltList<Y, X> next;

    AltList(X item, AltList<Y, X> next) {
        this.item = item;
        this.next = next;
    }

    public AltList<Y,X> pairsSwapped() {

        AltList<X,Y> thirdList = next.next;
        AltList<Y,X> newList;
        if(thirdList!=null){
             newList = new AltList<Y,X>(next.item,new AltList<X,Y>(item,thirdList.pairsSwapped()));
        }else{
            newList = new AltList<Y,X>(next.item,new AltList<X,Y>(item,null));
        }
        return newList;
    }

    @Test
    public void testThis(){

    }


}
