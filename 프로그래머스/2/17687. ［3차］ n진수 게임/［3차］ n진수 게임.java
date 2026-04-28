import java.util.*;

// t = 3 m = 5 p = 2
// 0 (1) 2 3 4 5 (6) 7 8 9 1 (0) 1 1 1
// m * t 번까지 숫자가 나오는듯 m*t를 n진수로 변경
// n진수로 변경한 숫자를 한 칸씩 나눠서 저장해야 됨
// list로 저장하고 list.get(p), list.get(p + m) ... t번 SB에 넣기

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(m * t, n);
        
        List<Character> list = new ArrayList<>();
        
        for (int i = 0; i <= m * t; i++) {
            String s = Integer.toString(i, n);
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    c = (char) ((int) c - 32);
                }
                list.add(c);
            }
            
        }
        
        p--;
        while (t-- > 0) {
            sb.append(list.get(p));
            p += m;
        }
        
        String answer = sb.toString();
        return answer;
    }
}