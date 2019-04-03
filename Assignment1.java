import java.util.Arrays;

public class Assignment1 {

    public static void main(String args [])
    {

        Integer[] arrayToBeSorted =  new Integer[100];
        fillArray(arrayToBeSorted);
        printArray(arrayToBeSorted);
        MergeSort<Integer> sortedArray = new MergeSort<Integer>(arrayToBeSorted);
        sortedArray.printArray();

    }

    private static void fillArray(Integer[] a) {
        for(int i = 0; i < a.length; i++){
            int r = (int) (Math.random() * 10000 + 1);
            a[i] = r;
        }
    }

    private static void printArray(Integer[] a){
        System.out.println(Arrays.toString(a));
    }
}
