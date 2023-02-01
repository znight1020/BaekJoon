import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2750_수정렬하기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int i, j, temp = 0;
        ArrayList<Integer> numArr = new ArrayList<>();
        for(i = 0; i < size; i++){
            numArr.add(Integer.parseInt(br.readLine()));
        }

        for(i = 0; i < size - 1; i++){
            j = i;
            while(numArr.get(j) > numArr.get(j+1)){
                temp = numArr.get(j);
                numArr.set(j, numArr.get(j+1));
                numArr.set(j+1, temp);
                j--;
                if(j < 0) break;
            }
        }
        for(i = 0; i < size; i++){
            System.out.println(numArr.get(i));
        }
    }
}