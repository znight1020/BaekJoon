import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S10814_나이순정렬 {
    static int[] sortedAge = new int[100001];
    static String[] sortedName = new String[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        String str;

        int[] ageArr = new int[size];
        String[] nameArr = new String[size];

        for(int i = 0; i < size; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            ageArr[i] = Integer.parseInt(st.nextToken());
            nameArr[i] = st.nextToken();
        }

        mergeSort(ageArr, nameArr, 0, size - 1);


    }

    static void mergeSort(int[] ageArr, String[] nameArr, int m, int n){
        while(m < n){
            int mid = (m+n) / 2;
            mergeSort(ageArr, nameArr, m, mid);
            mergeSort(ageArr, nameArr, mid+1, n);
            merge(ageArr, nameArr, m, mid, n);
        }
    }

    static void merge(int[] ageArr, String[] nameArr, int m, int mid, int n){
        int i = m;
        int j = mid+1;
        int k = m;

        while(i <= mid && j <= n){
            if(ageArr[i] > ageArr[j]){
                sortedAge[k] = ageArr[j];
                sortedName[k] = nameArr[j];
                j++;
            }
            else{
                sortedAge[k] = ageArr[i];
                sortedName[k] = nameArr[i];
                i++;
            }
        }
    }
}
