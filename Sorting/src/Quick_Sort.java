/**
 * 퀵 정렬은 하나의 큰 문제를 두 개의 작은 문제로 분할하는 식으로 빠르게 진행합니다.
 * -> 특정한 값을 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤에 배열은 반으로 나눕니다.

 * 퀵 정렬의 평균 시간 복잡도는 O(N*logN), 최악의 시간 복잡도는 O(N*2)
 * 재귀 함수를 사용하는데 이해가 안된다면 그냥 외웁시다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Quick_Sort {

    public static void main(String[] args) {
        int[] data = {1,10,5,8,7,6,4,3,2,9};
        quickSort(data, 0, data.length-1);

        for(int i = 0; i< data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

    private static void quickSort(int[] data, int start, int end) {
        if(start < end){
            int q = quickSortPartition(data, start, end);

            quickSort(data, start, q -1);
            quickSort(data, q+1, end);
        }
    }

    private static int quickSortPartition(int[] data, int start, int end) {
        int pivot = data[start];
        int low = start;
        int high = end;
        int temp = 0;

        /**
         * 내림차순의 경우 밑부분의 pivot 관련된 코드의 부등호를 역으로 바꾸어주면 된다 */
        while(low < high){
            while(pivot > data[low] && low <= end){
                low++;
            }
            while(pivot < data[high] && high >= start){
                high--;
            }
            if(data[low] > data[high]){
                temp = data[low];
                data[low] = data[high];
                data[high] = temp;
            }
        }
        if(data[low] > data[high]){
            temp = data[low];
            data[low] = data[high];
            data[high] = temp;
        }

        return high;
    }

}
