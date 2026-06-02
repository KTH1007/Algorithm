import java.util.*;

// 짝수면 + 1
// 홀수면 가장 작은 0과 그 전 위치 변경


class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                long x = numbers[i];
                String bin = "0" + Long.toString(x, 2);
                int idx = bin.lastIndexOf("01");
                String sub = bin.substring(0, idx)+ "10" + bin.substring(idx + 2);
                answer[i] = Long.parseLong(sub, 2);
            }
        }
        return answer;
    }
}