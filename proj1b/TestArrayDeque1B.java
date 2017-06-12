/**
 * Created by Song on 6/12/2017.
 */

import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Array;

public class TestArrayDeque1B {

    // recursive method to select the sequence of functions to call and execute them
    private void assertEqualsHelper(ArrayDequeSolution<Integer> correctSolution , StudentArrayDeque<Integer> studentSolution, OperationSequence fs){
        for(int i=0;i<correctSolution.size();i++){
            assertEquals(fs.toString(), correctSolution.get(i), studentSolution.get(i));
        }
    }


    private  void recursiveOps(ArrayDequeSolution<Integer> correctSolution , StudentArrayDeque<Integer> studentSolution, int numofIterations, OperationSequence fs ){
        if(numofIterations==0){
            return;
        }else{
            int temp;
            if(correctSolution.isEmpty()){
                temp= (int)(2*StdRandom.uniform());
            }else{
                temp= (int)(4*StdRandom.uniform());
            }

            switch (temp){
                case 0:
                    Integer temp2= (Integer) (int)(10*StdRandom.uniform());
                    correctSolution.addFirst(temp2);
                    studentSolution.addFirst(temp2);
                    DequeOperation dequeOp1 = new DequeOperation("addFirst", temp2);
                    fs.addOperation(dequeOp1);
                    assertEqualsHelper(correctSolution ,studentSolution,fs);
                    break;
                case 1:
                    Integer temp3= (Integer) (int)(10*StdRandom.uniform());
                    correctSolution.addLast(temp3);
                    studentSolution.addLast(temp3);
                    DequeOperation dequeOp2 = new DequeOperation("addLast", temp3);
                    fs.addOperation(dequeOp2);
                    assertEqualsHelper(correctSolution ,studentSolution,fs);
                    break;
                case 2:
                    Integer temp4=correctSolution.removeFirst();
                    Integer temp5=studentSolution.removeFirst();
                    DequeOperation dequeOp3 = new DequeOperation("removeFirst", temp4);
                    fs.addOperation(dequeOp3);
                    assertEqualsHelper(correctSolution ,studentSolution,fs);
                    break;
                case 3:
                    Integer temp6=correctSolution.removeLast();
                    Integer temp7=studentSolution.removeLast();
                    DequeOperation dequeOp4 = new DequeOperation("removeLast", temp6);
                    fs.addOperation(dequeOp4);
                    assertEqualsHelper(correctSolution ,studentSolution,fs);
                    break;
            }

            numofIterations--;
            recursiveOps(correctSolution,studentSolution,numofIterations,fs);
        }
    }

    @Test
    public void Test1(){
        int numofIterations=10+(int)(10*StdRandom.uniform());
        ArrayDequeSolution<Integer> correctSolution= new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> studentSolution= new StudentArrayDeque<>();
        OperationSequence fs = new OperationSequence();
        recursiveOps(correctSolution,studentSolution,numofIterations, fs);
        System.out.println("Fished the process");
        correctSolution.printDeque();
        studentSolution.printDeque();
        System.out.println("size=" + correctSolution.size());
        System.out.println("Haha finish");
        assertEqualsHelper(correctSolution ,studentSolution,fs);

    }


}
