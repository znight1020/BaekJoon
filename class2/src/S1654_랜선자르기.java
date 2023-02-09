import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 첫째 줄에는 이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N이 입력
 * K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수
 * 그리고 항상 K ≦ N 이다. 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다.
 * 랜선의 길이는 231-1보다 작거나 같은 자연수이다.
 */
public class S1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        int i;
        long high = 0, target;

        ArrayList<Long> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        st = new StringTokenizer(input);
        long ready = Long.parseLong(st.nextToken());
        long want = Long.parseLong(st.nextToken());

        for(i = 0; i < ready; i++){
            arr.add(Long.parseLong(br.readLine()));
            if(i == 0) high = arr.get((int) i);
            if(arr.get(i) > high) high = arr.get(i);
        }
        target = findNum(arr, 0, high+1, want);


        System.out.print(target);
    }

    static long findNum(ArrayList<Long> arr, long low, long high, long want){
        long mid = (low + high) / 2;
        if(mid == 0) return high;

        if(want > correctWant(arr, mid)){
            return findNum(arr, low, mid, want);
        }
        else if(want <= correctWant(arr, mid)){
            if(correctWant(arr,mid+1) >= want){
                return findNum(arr, mid+1, high, want);
            }
            else return mid;
        }
        return -1;
    }

    static long correctWant(ArrayList<Long> arr, long mid){
        long cnt = 0;
        for(int i = 0; i < arr.size(); i++){
            cnt += arr.get(i) / mid;
        }
        return cnt;
    }
}
