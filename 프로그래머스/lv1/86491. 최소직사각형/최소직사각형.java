import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> w = new ArrayList<>();
        List<Integer> h = new ArrayList<>();
        for (int[] size : sizes) {
            if (size[0] >= size[1]) {
                w.add(size[0]);
                h.add(size[1]);
            } else {
                w.add(size[1]);
                h.add(size[0]);
            }
        }
        Collections.sort(w, Collections.reverseOrder());
        Collections.sort(h, Collections.reverseOrder());
        answer = w.get(0) * h.get(0);
        return answer;
    }
}