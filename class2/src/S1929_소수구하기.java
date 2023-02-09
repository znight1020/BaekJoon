import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**에라토스테네스의 체*/
public class S1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str);
        int low = Integer.parseInt(st.nextToken());
        int high = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> arr = new ArrayList<>(high + 1);
        arr.add(false);
        arr.add(false);

        for(int i = 2; i <= high; i++){
            arr.add(i, true);
        }

        for(int i = 2; i * i <= high; i++){
            if(arr.get(i)){
                for(int j = i*i; j <= high; j+=i){
                    arr.set(j, false);
                }
            }
        }

        for(int i = low; i <= high; i++){
            if(arr.get(i)){
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);

    }
}
