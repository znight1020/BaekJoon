/**
 * 각 숫자를 적절한 위치에 삽입하는 방법
 * 선택정렬, 버블정렬의 경우 무조건 위치를 바꾸는 방식이였다면 삽입 정렬은 '필요한 때만' 위치를 바꾸게 된다.

 * 삽입 정렬의 시간복잡도는 O(N*2)
 * 삽입 정렬의 경우 데이터가 {2,3,4,5,6,7,8,9,10,1} 과 같이 '거의 정렬된 상태'라면 최고의 효율을 낸다.(퀵, 힙, 병합보다도 더)
 * */
public class Insertion_Sort {
    public static void main(String[] args) {
        // 입력
        int[] numArray = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        // 초기변수 설정
        int temp, j = 0;

        // sort 구현
        for(int i = 0; i < numArray.length - 1; i++){
            j = i;
            while(numArray[j] > numArray[j+1]){
                temp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = temp;
                j--;
                if(j < 0) break; // 맨 앞의 값이 큰 수인 경우 indexOut 오류발생
            }
        }

        // 출력
        for(int i = 0; i < numArray.length; i++){
            System.out.print(numArray[i] + " ");
        }
    }
}
