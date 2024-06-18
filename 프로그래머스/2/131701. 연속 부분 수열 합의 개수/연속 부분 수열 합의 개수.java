import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        int start = 1;
        
        /*
        start -> 더할 원소의 개수를 정함
        i -> 시작할 인덱스
        j -> j번째 원소를 더함
        */
        while (start <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < start + i; j++) {
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
            start++;
        }
        answer = set.size();
        return answer;
    }
}