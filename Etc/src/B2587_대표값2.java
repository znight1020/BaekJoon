import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2587_대표값2 {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, temp = 0;
        ArrayList<Integer> numArr = new ArrayList<>();
        for(i = 0; i < 5; i++){
            numArr.add(Integer.parseInt(br.readLine()));
            sum += numArr.get(i);
        }

        for(i = 0; i < 4; i++){
            j = i;
            while(numArr.get(j) > numArr.get(j+1)){
                temp = numArr.get(j);
                numArr.set(j, numArr.get(j+1));
                numArr.set(j+1, temp);
                j--;
                if(j < 0) break;
            }
        }

        System.out.println(sum / 5);
        System.out.println(numArr.get(2));
    }
}