import java.util.ArrayList;

/**
 * 병합 정렬은 '분할 정복' 방법을 채택한 알고리즘으로 퀵 정렬과 동일하게 평균적으로 O(N*logN)의 시간 복잡도를 가집니다.
 * 퀵 정렬과 다르게 최악의 경우에도 O(N*logN)의 시간복잡도를 보장합니다.

 *
 * */

public class Merge_Sort {
    static int[] sorted = new int[8];
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1};
        mergeSort(arr, 0, 7);

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    static void merge(int[] arr, int m, int middle, int n){
        int i,j,k;
        i = m;
        j = middle + 1;
        k = m;

        //작은 순서대로 배열에 삽입
        while(i <= middle && j <= n){
            if(arr[i] <= arr[j]){
                sorted[k] = arr[i];
                i++;
            } else{
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }
        // 남은 데이터도 삽입
        if(i > middle){
            for(int t = j; t <= n; t++){
                sorted[k] = arr[t];
                k++;
            }
        } else{
            for(int t = i; t <= middle; t++){
                sorted[k] = arr[t];
                k++;
            }
        }

        //정렬된 배열을 삽입
        for(int t = m; t <= n; t++){
            arr[t] = sorted[t];
        }
    }
    static void mergeSort(int[] arr, int m, int n){
        if(m < n){
            int middle = (m+n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr, m, middle, n);
        }
    }
}
