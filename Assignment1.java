import java.util.Arrays;

public class Assignment1 {

    public static void main(String args [])
    {
        int[] arrayToBeSorted =  new int[100];
        for(int i = 0; i < arrayToBeSorted.length; i++){
            int r = (int) (Math.random() * 10000 + 1);
            arrayToBeSorted[i] = r;
        }
        System.out.println(Arrays.toString(arrayToBeSorted));
    }
}
