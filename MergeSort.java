import org.omg.CORBA.Any;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort implements Runnable{


    private Integer[] arr;
    private int Size;
    private int left;
    private int right;
    public Integer[] resultArr ;

    public MergeSort(Integer[] arr, int i, int j) {
        this.arr = arr;
        this.Size = arr.length;
        //this.resultArr = new int[j-i+1];
        this.left  = i;
        this.right = j;
    }



    @Override
    public void run() {
        sort();

    }

    private void sort() {

        if(left==right && left >=0 )
        {
            this.resultArr = new Integer[]{arr[left]};
            return;
        }
        if(left>right) return;

        int rightLimit = this.left+(right-left)/2;
        //int leftArr[] = sort( left,rightLimit );

        MergeSort mleft = new MergeSort(arr,left,rightLimit);
        Thread t1 = new Thread(mleft);
        t1.start();

        int leftlimit = 1 + rightLimit;
        //int rightArr[] = sort(leftlimit , right);

        MergeSort mright= new MergeSort(arr,leftlimit,right);
        Thread t2 = new Thread(mright);
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        merge(mleft.resultArr,mright.resultArr);
    }

    private  Integer[] merge(Integer[] left, Integer[] right) {
        resultArr = new Integer[left.length+right.length];

        int r=0;
        int i=0;
        int j=0;
        while(i<left.length && j <right.length )
        {
            if( i<left.length && j<right.length && left[i] < right[j] )
                resultArr[r++] = left[i++];

            else if( j<right.length && i<left.length && right[j] < left[i])
                resultArr[r++] = right[j++];
        }


        while(i<left.length)
        {
            resultArr[r++] = left[i++];
        }

        while(j<right.length)
        {
            resultArr[r++] = right[j++];
        }


        //System.out.println("resultArr "+resultArr);
        return resultArr;
    }



}
//public  class MergeSort<AnyType extends Comparable<? super AnyType>> implements Runnable{
//
//    private AnyType[] v;
//    private int from, to;
//    private int length;
//    private AnyType[] answer;
//
//    public MergeSort(AnyType [] v, int from, int to){
//        this.v = v;
//        this.from = from;
//        this.to = to;
//        this.length = v.length;
//        this.answer = (AnyType[]) new Comparable[length];
//
//    }
//
//    private void sort(AnyType[] v, int from, int to){
//        if (from < to) {
//            int middle = from + (from - to) / 2;
//            Thread childThread = new Thread(new MergeSort<AnyType>(v, from, middle));
//            childThread.start();
//            sort(v, middle+1, to);
//            try {
//                childThread.join();
//            }
//            catch (InterruptedException e) {}
//            merge(from, middle, to);
//        }
//        else return;
//    }
//
//    private void merge(int form, int middle, int to){
//        for (int i = form; i <= to; i++) {
//            answer[i] = v[i];
//        }
//        int i = form;
//        int j = middle + 1;
//        int k = form;
//        while (i <= middle && j <= to) {
//            if (answer[i].compareTo(answer[j]) == 0) {
//                v[k] = answer[i];
//                i++;
//            } else {
//                v[k] = answer[j];
//                j++;
//            }
//            k++;
//        }
//        while (i <= middle) {
//            v[k] = answer[i];
//            k++;
//            i++;
//        }
//    }
//
//    @Override
//    public void run() {
//        sort(v, from, to);
//    }
//
//    private void printArray(){
//        System.out.println(Arrays.toString(this.v));
//    }
//
//
//}
