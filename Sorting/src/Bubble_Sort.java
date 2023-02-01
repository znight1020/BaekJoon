/** 버블정렬 또한 선택정렬과 같이 몹시 직관적인 해결 방법
 * 가까이에 있는 두 숫자끼리 비교를 하여 당장 더 작은 숫자를 앞으로 보내주는 것을 반복
 * 가장 비효율적인 알고리즘

 * 버블 정렬의 시간복잡도는 O(N*2), 데이터의 갯수가 10,000개 == 1억번의 계산 수행
 * 시간복잡도는 선택정렬과 같지만 명령어의 실행 수가 훨씬 많아 선택정렬보다 성능이 안좋다.
 * */
public class Bubble_Sort {
    public static void main(String[] args) {
        // 입력
        int[] numArray = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        // 초기변수 설정
        int temp = 0;

        // sort 구현
        for(int i = 0; i < numArray.length; i++){
            for(int j = 0; j < numArray.length - i-1; j++){
                if(numArray[j] > numArray[j+1]){
                    temp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = temp;
                }
            }
        }

        // 출력
        for(int i = 0; i < numArray.length; i++){
            System.out.print(numArray[i] + " ");
        }
    }
}
