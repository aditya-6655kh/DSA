package Sorting;
import java.util.Arrays;

public class BucketSort {
    public void bucketSort(int[] arr, int bucketSize){
        if(arr.length == 0 || bucketSize <= 0) return;
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][arr.length];
        int[] bucketSizes = new int[bucketCount];

        for(int num :  arr){
            int bucketIdx = (num - min) / bucketSize;
            buckets[bucketIdx][bucketSizes[bucketIdx]++] = num;
        }

        int idx = 0;
        for(int i=0; i<bucketCount; i++){
            if(bucketSizes[i] > 0){
                insertionSortBucket(buckets[i], bucketSizes[i]);
                for(int j=0; j<bucketSizes[i]; j++){
                    arr[idx++] = buckets[i][j];
                }
            }
        }
    }

    private void insertionSortBucket(int[] bucket, int size){
        for(int i=1; i<size; i++){
            int key = bucket[i];
            int j = i - 1;
            while(j >= 0 && bucket[j] > key){
                bucket[j+1] = bucket[j];
                j--;
            }
            bucket[j+1] = key;
        }
    }
}
