import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i,j,temp = 0;
        int size = Integer.parseInt(br.readLine());
        int[] countingArr = new int[10001];

        for(i = 0; i < size; i++){
            int num = (Integer.parseInt(br.readLine()));
            countingArr[num]++;
        }

        for(i = 0; i < countingArr.length; i++){
            for(j = 0; j < countingArr[i]; j++){
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
