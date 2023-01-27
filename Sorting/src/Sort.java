import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Sort {
    public static void main(String[] args) throws IOException {
        /**ArrayList 퀵정렬*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer> numArr = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            numArr.add(Integer.parseInt(br.readLine()));
        }
        quickSort(numArr, 0, size - 1);

        for(int i = 0; i < size; i++){
            System.out.println(numArr.get(i));
        }
        /**ArrayList 퀵정렬*/


        /**Array 퀵정렬*/
        int[] num = new int[100];
        for(int i = 0; i < 100; i++){
            num[i] = (int)(Math.random()*1000);
            for(int j = 0; j < i; j++){
                if(num[i] == num[j]) num[i] = (int)(Math.random()*1000);
            }
        }

        quickSort(num, 0, 99);

        for(int i = 0; i < 100; i++){
            System.out.println(num[i] + " ");
        }
        /**Array 퀵정렬*/
    }

    /**ArrayList 퀵정렬*/
    // 1. 피벗을 기준으로 2개의 부분 리스트로 나눈다.
    // 2. 피벗보다 작은 값은 모두 왼쪽 부분 리스트로, 큰 값은 오른쪽 부분 리스트로 옮긴다.
    // 3. quickSort 메소드에서는 partition 메소드를 재귀호출하면서 정렬한다.
    static ArrayList<Integer> quickSort(ArrayList<Integer> arr, int left, int right){
        if(left < right){
            int pivot = quickSortPartition(arr, left, right);

            //pivot을 기준으로 2개의 List들을 각각 재귀호출을 사용하여 정렬
            quickSort(arr, pivot + 1, right);
            quickSort(arr, left, pivot - 1);
        }

        for(int i = 0; i < 5; i++){
            arr.get(i);
        }
        return arr;
    }
    static int quickSortPartition(ArrayList<Integer> numArr,int left, int right){
        int pivot = numArr.get(left);
        int low = left;
        int high = right;
        int temp = 0;

        while(low < high){

            while(pivot > numArr.get(low) && low <= right){
                low++;
            }
            while(pivot < numArr.get(high) && high >= left){
                high--;
            }

            if(numArr.get(low) > numArr.get(high)){
                temp = numArr.get(low);
                numArr.set(low, numArr.get(high));
                numArr.set(high, temp);
            }
        }

        if(numArr.get(low) > numArr.get(high)){
            temp = numArr.get(low);
            numArr.set(low, numArr.get(high));
            numArr.set(high, temp);
        }

        return high; // 피벗의 위치인 high를 반환
    }
    /**ArrayList 퀵정렬*/



    /**Array 퀵정렬*/
    static int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivot = quickSortPartition(arr, left, right);
            //pivot을 기준으로 2개의 List들을 각각 재귀호출을 사용하여 정렬
            quickSort(arr, pivot + 1, right);
            quickSort(arr, left, pivot - 1);
        }
        return arr;
    }
    static int quickSortPartition(int[] numArr,int left, int right){
        int pivot = numArr[left];
        int low = left;
        int high = right;
        int temp = -1;

        while(low < high){
            while(pivot > numArr[low] && low <= right){
                low++;
            }
            while(pivot < numArr[high] && high >= left){
                high--;
            }

            if(numArr[low] > numArr[high]){
                temp = numArr[low];
                numArr[low] = numArr[high];
                numArr[high] = temp;
            }
        }

        if(numArr[low] > numArr[high]){
            temp = numArr[low];
            numArr[low] = numArr[high];
            numArr[high] = temp;
        }

        return high; // 피벗의 위치인 high를 반환
    }
    /**Array 퀵정렬*/
}
