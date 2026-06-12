import java.util.*;

// 오름차순, 투포인터, 합은 k
// left, right 인덱스 반환


class Solution {
    static int x = 0;
    static int y = 0;
    static int minLength = Integer.MAX_VALUE;
    public int[] solution(int[] sequence, int k) {
        two(sequence, k);
        int[] answer = new int[]{x, y};
        
        return answer;
    }
    
    private static void two(int[] sequence, int k) {
        int sum = sequence[0];
        int right = 0;
        int left = 0;
        while (right < sequence.length) {
            if (sum == k) {
                int size = right - left;
                if (minLength > size) {
                    minLength = size;
                    x = left;
                    y = right;
                }
                sum -= sequence[left++];
            } else if (sum > k) {
                sum -= sequence[left++];
            } else {
                right++;
                if (right < sequence.length)
                    sum += sequence[right];
            }
        }
    }
}