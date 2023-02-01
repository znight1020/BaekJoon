/**작은 수를 선택해서 앞으로 보내기
 * increaseIndex(초기값 0)부터 시작하여 가장 작은 수를 찾으면
 * 해당 index와 increaseIndex의 값을 바꾸고 increaseIndex++
 * 위 행동을 반복하여 수행

 * 선택 정렬의 시간복잡도는 O(N*2), 데이터의 갯수가 10,000개 == 1억번의 계산 수행
 * */
public class Selection_Sort {
    public static void main(String[] args) {
        // 입력
        int[] numArray = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        // 초기변수 설정
        int min, temp, index = 0;

        // sort 구현
        for(int i = 0; i < numArray.length; i++){
            min = 9999;
            for(int j = i; j < numArray.length; j++){
                if(min > numArray[j]){
                    min = numArray[j];
                    index = j;
                }
            }
            temp = numArray[i];
            numArray[i] = min;
            numArray[index] = temp;
        }

        // 출력
        for(int i = 0; i < numArray.length; i++){
            System.out.print(numArray[i] + " ");
        }

    }

}
