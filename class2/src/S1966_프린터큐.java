import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class S1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        Queue<Integer> q = new LinkedList<>();
        int size = Integer.parseInt(br.readLine());
        int weightCnt = 0, target=0, pollCount = 0, maxWeight = 0, cnt = 0;
        while(cnt < size){
            weightCnt = 0; target=0; pollCount = 0; maxWeight = 0;

            str = br.readLine();
            st = new StringTokenizer(str);
            int counting = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            str = br.readLine();
            st = new StringTokenizer(str);
            while(st.hasMoreTokens()){
                int weight = Integer.parseInt(st.nextToken());

                if(maxWeight < weight){
                    maxWeight = weight;
                }

                if(weightCnt == targetIndex){
                    target = weight;
                    weight += 10;
                }
                q.add(weight);
                weightCnt++;
            }

            while(!q.isEmpty()){
                if(q.peek() % 10 == maxWeight || q.peek() == maxWeight){ // 찾은 최대중요도랑 같은 중요도를 가진 요소는 poll 해준다.
                    pollCount++; // 출력 횟수 증가
                    if(q.peek() / 10 == 1 && q.peek() % 10 == target) {
                        System.out.println(pollCount);
                        break; // target 요소가 출력되면 종료
                    }
                    q.poll();
                    if(pollCount == counting) break; // pollCount = counting이면 모든 값이 출력되었으므로 break
                }
                while(!q.contains(maxWeight) && !q.contains(maxWeight + 10)){ // 현재 남아있는 큐 중 중요도가 제일 큰 값으로 조정
                    maxWeight--;
                    if(maxWeight == 0) break;
                }
                if(q.peek() != maxWeight && q.peek() % 10 != maxWeight){ // 중요도가 낮으면 맨 뒤로 넣어줌
                    q.add(q.poll());
                }
            }
            q.clear();
            cnt++;
        }
    }
}