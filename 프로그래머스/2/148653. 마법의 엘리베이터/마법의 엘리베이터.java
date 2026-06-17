import java.util.*;

// 0층으로 내려가야 됨 +- 다 됨
// 1의자리 끝자리가 1 ~ 5면 빼기 6 ~ 9는 더하기
// 각 자리수마다 더하거나 뺀 개수를 세고
// 마지막 첫번째 자리에서 한 번에 빼기

// 각각의 자리수 카운트 함수

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int num = storey % 10;
            
            if (num == 5) {
                answer += 5;
                if ((storey / 10) % 10 >= 5) storey += 5;
            } else if (num < 5) {
                answer += num;
            } else {
                answer += (10 - num);
                storey += (10 - num);
            }
            
            storey /= 10;
        }
        return answer;
    }
}