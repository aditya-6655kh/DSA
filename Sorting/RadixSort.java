package Sorting;
public class RadixSort{
    public void radixSort(int[] arr){
        CountingSort cs = new CountingSort();
        int max = cs.findMax(arr);
        for(int exp=1; max/exp > 0; exp *= 10){
            cs.countingSortByDigit(arr, exp);
        }
    }
}