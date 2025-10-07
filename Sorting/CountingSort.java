package Sorting;
public class CountingSort{
    public void countingSort(int[] arr){
        int n = arr.length;
        int max = findMax(arr);
        int[] count = new int[max+1];

        for(int i : arr){
            count[i]++;
        }

        for(int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }

        int[] out = new int[n];
        for(int i=n-1; i>=0; i--){
            out[--count[arr[i]]] = arr[i];
        }

        System.arraycopy(out, 0, arr, 0, n);
    }

    public void countingSortByDigit(int[] arr, int exp){
        int n = arr.length;
        int max = findMax(arr);
        int[] count = new int[max+1];
        int[] out = new int[n];

        for(int i: arr){
            count[(i/exp)%10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for(int i=n-1; i>=0; i--){
            out[--count[(arr[i]/exp)%10]] = arr[i];
        }
        System.arraycopy(out, 0, arr, 0, n);
    }

    public int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}