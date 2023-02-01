import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S11650_좌표정렬하기 {
    static int[][] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        sorted = new int[size][2];
        int[][] arr = new int[size][2];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mergeSort(arr, 0, size-1);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(arr[i][j]+ " ") ;
            }
            System.out.println();
        }


    }

    static void merge(int[][] arr, int m, int middle, int n){
        int i,j,k;
        i = m;
        j = middle + 1;
        k = m;
        while(i <= middle && j <= n){
            if(arr[i][0] < arr[j][0]){
                sorted[k][0] = arr[i][0];
                sorted[k][1] = arr[i][1];
                i++;
            } else if(arr[i][0] > arr[j][0]){
                sorted[k][0] = arr[j][0];
                sorted[k][1] = arr[j][1];
                j++;

            } else if(arr[i][0] == arr[j][0]){
                if(arr[i][1] < arr[j][1]){
                    sorted[k][0] = arr[i][0];
                    sorted[k][1] = arr[i][1];
                    i++;
                }
                else if(arr[i][1] > arr[j][1]){
                    sorted[k][0] = arr[j][0];
                    sorted[k][1] = arr[j][1];
                    j++;
                }
            }




            k++;

        }
        if(i > middle){
            for(int t = j; t <= n; t++){
                sorted[k][0] = arr[t][0];
                sorted[k][1] = arr[t][1];
                k++;
            }
        }
        else{
            for(int t = i; t <= middle; t++){
                sorted[k][0] = arr[t][0];
                sorted[k][1] = arr[t][1];
                k++;
            }
        }
        for(int t = m; t <= n; t++){
            arr[t][0] = sorted[t][0];
            arr[t][1] = sorted[t][1];
        }

    }

    static void mergeSort(int[][] arr, int m, int n){
        if(m < n){
            int middle = (m+n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr, m, middle, n);
        }
    }
}
