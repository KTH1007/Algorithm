import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        /*
        119 1195524421 
        일단 현재값이 앞에 크기보다 커야 됨
        그리고 substring (0, arr[i - 1].length)가 같은지 확인 
        */
        
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].length() > phone_book[i - 1].length()) {
                if (phone_book[i - 1].equals(phone_book[i].substring(0, phone_book[i - 1].length()))) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}