import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Character> arr;
        String str;
        int top, cnt = 0;
        boolean flag;

        int size = Integer.parseInt(br.readLine());

        while(cnt < size){ // 문자열 단위
            flag = true;
            top = 0;
            arr = new Stack<>();

            str = br.readLine();

            for(int i = 0; i < str.length(); i++){ // 글자 단위
                if(top == 0 && str.charAt(i) == ')'){
                    flag = false;
                    break;
                }

                if(str.charAt(i) == '('){
                    arr.push(str.charAt(i));
                    top++;
                }
                else if(str.charAt(i) == ')' && top > 0){
                    if(arr.peek() == '(') {
                        arr.pop();
                        top--;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if(!arr.isEmpty()) flag = false;

            if(flag == true) System.out.println("YES");
            else System.out.println("NO");

            cnt++;
        }
    }
}
