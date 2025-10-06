// QuickSort.java
package Sorting;
public class QuickSort {
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int pivot = high;
        int i = low - 1;
        for(int j=low; j<high; j++){
            if(arr[j] < arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[pivot];
        arr[pivot] = temp;
        return i+1;
    }
}