import java.util.Arrays;

public  class MergeSort<AnyType extends Comparable<? super AnyType>> implements Runnable{

    private AnyType[] arr;
    private int start, stop;

    public MergeSort(AnyType[] arr, int start, int stop) {
        this.arr = arr;
        this.start = start;
        this.stop = stop;
    }

    public void sort() throws InterruptedException {
        this.mergeSort(this.arr, this.start, this.stop);
    }

    private void mergeSort(AnyType[] arr, int start, int stop) throws InterruptedException {
        if (start == stop) {
            return;
        }
        int mid = Math.floorDiv(start + stop, 2);
        Thread t = new Thread (new MergeSort<AnyType>(arr, mid+1, stop));
        t.start();
        mergeSort(arr, start, mid);
        t.join();
        merge(start, stop);
    }

    public void run() {
        try {
            this.sort();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void ChangeArr(AnyType[] newArr, int start, int stop) {
        for (int i = 0; i < newArr.length; i++) {
            this.arr[start + i] = newArr[i];
        }
    }

    public void merge(int start, int stop) {

        int middle = Math.floorDiv(start + stop, 2);
        AnyType[] arr1 = Arrays.copyOfRange(arr, start, middle+1);
        AnyType[] arr2 = Arrays.copyOfRange(arr, middle + 1, stop+1);
        AnyType[] newArr = (AnyType[]) new Comparable[arr1.length + arr2.length];
        int arr1i = 0, arr2i = 0;
        AnyType first, second;
        for (int i = 0; i < newArr.length; i++) {
            if (arr1i < arr1.length && arr2i < arr2.length) {
                first = arr1[arr1i];
                second = arr2[arr2i];
                if (first.compareTo(second) > 0) {
                    newArr[i] = second;
                    arr2i++;
                } else {
                    newArr[i] = first;
                    arr1i++;
                }
            } else if (arr1i < arr1.length) {
                first = arr1[arr1i];
                newArr[i] = first;
                arr1i++;
            } else {
                second = arr2[arr2i];
                newArr[i] = second;
                arr2i++;
            }

        }
        ChangeArr(newArr, start, stop);
    }
}