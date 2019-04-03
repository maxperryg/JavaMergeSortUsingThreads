import org.omg.CORBA.Any;

import java.lang.reflect.Array;
import java.util.Arrays;

public  class MergeSort<AnyType extends Comparable<? super AnyType>> {

    private AnyType v [];
    private AnyType firstHalf[];
    private AnyType secondHalf[];

    public MergeSort(AnyType [] n){
        if(n.length != 1) v = n;
    }

    public AnyType[] sort(){
        int totalLength = v.length;

        if(totalLength % 2 == 0){
            firstHalf = (AnyType[]) Array.newInstance(v.getClass(), totalLength/2);
            secondHalf = (AnyType[]) Array.newInstance(v.getClass(), totalLength/2);
        }
    }

    public void printArray(){
        System.out.println(Arrays.toString(this.v));
    }
}
