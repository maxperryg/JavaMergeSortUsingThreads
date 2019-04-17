import java.lang.reflect.Array;
import java.util.Arrays;

public class Assignment1 {

    public static void main(String[] args) {

        Integer arr[] = fillArray(100);

        System.out.println("Before");
        System.out.println(Arrays.toString(arr));

        MergeSort<Integer> mr = new MergeSort<Integer>(arr,0,arr.length-1);

        Thread t = new Thread(mr);

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("after");
        System.out.println(Arrays.toString(arr));
    }

    private static Integer[] fillArray(int size) {
        Integer[] a = new Integer[size];
        for(int i = 0; i < a.length; i++){
            int r = (int) (Math.random() * 10000 + 1);
            a[i] = r;
        }
        return a;
    }
}
