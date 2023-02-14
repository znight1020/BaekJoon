import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S11659_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 0, sum, low, high;
        String str = br.readLine();
        st = new StringTokenizer(str);

        int numSize = Integer.parseInt(st.nextToken());
        int orderSize = Integer.parseInt(st.nextToken());

        ArrayList<Integer> preArr = new ArrayList<>();
        str = br.readLine();
        st = new StringTokenizer(str);

        for(int i = 0; i < numSize; i++){
            if(i == 0){
                preArr.add(Integer.parseInt(st.nextToken()));
            }
            else{
                preArr.add(i, preArr.get(i - 1) + Integer.parseInt(st.nextToken()));
            }
        }
        while(cnt < orderSize){
            str = br.readLine();
            st = new StringTokenizer(str);
            low = Integer.parseInt(st.nextToken())-1;
            high = Integer.parseInt(st.nextToken())-1; /// 1 3 입력되면 low = 0, high = 2

            if(low - 1 < 0){
                System.out.println(preArr.get(high));
            }
            else{
                System.out.println(preArr.get(high) - preArr.get(low-1));
            }
            cnt++;
        }


    }
}