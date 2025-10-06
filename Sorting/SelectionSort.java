// Selection Sort in Java
//  O(n^2) time complexity, O(1) space complexity
//  Not a stable sort
package Sorting;
public class SelectionSort {
    public void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
