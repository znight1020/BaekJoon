import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2747_피보나치수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        for(int i = 2; i < num+1; i++){
            arr.add(arr.get(i -1) + arr.get(i - 2));
        }
        System.out.println(arr.get(num));
    }
}
