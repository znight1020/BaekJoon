import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i,j,temp = 0;
        int size = Integer.parseInt(br.readLine());


        ArrayList<Integer> arr = new ArrayList<>();
        for(i = 0; i < size; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        for(i = 0; i < size-1; i++){
            j = i;
            while(arr.get(j) > arr.get(j+1)){
                temp = arr.get(j);
                arr.set(j, arr.get(j+1));
                arr.set(j+1, temp);
                j--;
                if(j < 0) break;
            }
        }

        for(i = 0; i< size; i++){
            System.out.println(arr.get(i));
        }
    }
}
