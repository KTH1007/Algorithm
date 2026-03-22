import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // 현재 포인터부터 n개 선택
        // ex) 2일때 4개 선택 2 3 4 0, len = 5
        // ++, if (i == len - 1) i = 0; 
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            int sum = elements[i];
            set.add(sum);
            // System.out.println(sum);
            for (int j = 1; j < elements.length; j++) {
                int position = (i + j) % elements.length;
                sum += elements[position];
                // System.out.println(sum);
                set.add(sum);
            }
            // System.out.println();
        }
        
        answer = set.size();
        return answer;
    }
}