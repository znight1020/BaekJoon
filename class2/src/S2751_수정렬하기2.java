import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < size; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        quickSort(arr, 0, size-1);

        for(int i = 0; i < size; i++){
            System.out.print(arr.get(i)+"\n");
        }
    }

    private static void quickSort(ArrayList<Integer> arr, int start, int end) {
        if(start < end){
            int q = quickSortPartition(arr, start, end);

            quickSort(arr, start, q-1);
            quickSort(arr, q+1, end);
        }
    }

    private static int quickSortPartition(ArrayList<Integer> arr, int start, int end) {
        int pivot = arr.get(start);
        int low = start;
        int high = end;
        int i,j,temp = 0;

        while(low < high){
            while(pivot > arr.get(low) && low <= end){
                low++;
            }
            while(pivot < arr.get(high) && high >= start){
                high--;
            }
            if(arr.get(low) > arr.get(high)){
                temp = arr.get(low);
                arr.set(low, arr.get(high));
                arr.set(high, temp);
            }
        }
        if(arr.get(low) > arr.get(high)){
            temp = arr.get(low);
            arr.set(low, arr.get(high));
            arr.set(high, temp);
        }

        return high;
    }
}
