/* time complexity -> O(n^2)
 * space complexity -> O(1)
 * Bubble Sort Algorithm
 * Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
 */

package Sorting;
public class BubbleSort {
    public void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
