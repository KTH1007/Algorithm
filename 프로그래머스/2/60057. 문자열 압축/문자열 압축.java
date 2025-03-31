import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prevStr = s.substring(0, i);
            int count = 1;
            
            for (int j = i; j < s.length(); j += i) {
                String currentStr = "";
                if (j + i <= s.length()) {
                    currentStr = s.substring(j, i + j);
                } else {
                    currentStr = s.substring(j);
                }
                
                if (prevStr.equals(currentStr)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prevStr);
                    
                    prevStr = currentStr;
                    count = 1;
                }
            }
            // System.out.println(sb);
            if (count > 1) sb.append(count);
            sb.append(prevStr);
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}
