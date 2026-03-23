import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        Set<String> set = new HashSet<>();
        
        int count = 1;
        
        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i]))  {
                answer = new int[]{(i % n) + 1, count};
                break;
            } else {
                set.add(words[i]);
            }
            
            if (i > 0) {
                boolean isSame = isSamePrevWord(words[i - 1], words[i]);
                if (!isSame) {
                    answer = new int[]{(i % n) + 1, count};
                    break;
                }
            }
            
            if ((i + 1) % n == 0) {
                count++;
            } 
        }
        return answer;
    }
    
    private static boolean isSamePrevWord(String prevWord, String currentWord) {
        char prevChar = prevWord.charAt(prevWord.length() - 1);
        char currentChar = currentWord.charAt(0);
        
        return prevChar == currentChar;
    }
}