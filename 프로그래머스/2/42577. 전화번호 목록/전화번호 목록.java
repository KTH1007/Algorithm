import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            int size = phone_book[i].length();
            if (phone_book[i + 1].length() > size) {
                String temp = phone_book[i + 1].substring(0, size);
                if (temp.equals(phone_book[i])) return false;
            } 
        }
        return answer;
    }
}