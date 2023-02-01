import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B25305_커트라인 {
    public static void main(String[] args) throws IOException {
        int i, j, temp = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        StringTokenizer st = new StringTokenizer(numStr);

        int size = Integer.parseInt(st.nextToken());
        int cutLine = Integer.parseInt(st.nextToken());

        String pointStr = br.readLine();
        st = new StringTokenizer(pointStr);
        ArrayList<Integer> pointArr = new ArrayList<>();
        for(i = 0; i< size; i++){
            pointArr.add(Integer.parseInt(st.nextToken()));
        }

        for(i = 0; i < size - 1; i++){
            j = i;
            while(pointArr.get(j) < pointArr.get(j + 1)){
                temp = pointArr.get(j);
                pointArr.set(j, pointArr.get(j+1));
                pointArr.set(j+1, temp);
                j--;
                if(j < 0) break;
            }
        }
        System.out.print(pointArr.get(cutLine-1));
    }
}
