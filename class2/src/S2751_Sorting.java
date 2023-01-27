import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

public class S2751_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numArr = new ArrayList<>();

        int size = Integer.parseInt(br.readLine());

        for(int i = 0; i< size; i++){
            numArr.add(Integer.parseInt(br.readLine()));
        }

        /** 퀵정렬은 평균 시간복잡도가 nlogn 으로 성능이 우수하지만 worst인 경우 n의2승이 되므로 시간초과가 난다. */
        //quickSort(numArr, 0, size-1);





        //출력
        for(int i = 0; i < size; i++)
        {
            System.out.println(numArr.get(i));
        }
    }

    /**퀵 정렬 */
    static ArrayList<Integer> quickSort(ArrayList<Integer> numArr, int left, int right) {
        if(left < right){
            int pivot = quickSortPartition(numArr, left, right);
            quickSort(numArr, left, pivot - 1);
            quickSort(numArr,pivot +1, right);
        }
        return numArr;
    }
    static int quickSortPartition(ArrayList<Integer> numArr, int left, int right){
        int pivot = numArr.get(left);
        int low = left;
        int high = right;
        int temp = 0;

        while(low < high){
            while(pivot > numArr.get(low) && low < right){
                low++;
            }

            while(pivot < numArr.get(high) && high > left){
                high--;
            }

            if(numArr.get(low) > numArr.get(high)){
                temp = numArr.get(low);
                numArr.set(low, numArr.get(high));
                numArr.set(high, temp);
            }
        }
        if(numArr.get(low) > numArr.get(high)){ // 교차한 경우 값 비교 후 큰 숫자를 오른쪽 작은 숫자를 왼쪽으로 교환
            temp = numArr.get(low);
            numArr.set(low, numArr.get(high));
            numArr.set(high, temp);
        }
        return high;
    }
    /**퀵 정렬 */



    /**힙 정렬*/

    /**힙 정렬*/



    /**병합 정렬*/
    /**병합 정렬*/
}
