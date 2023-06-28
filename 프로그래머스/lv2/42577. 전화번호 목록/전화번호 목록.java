import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            int size = phone_book[i].length();
            String s = phone_book[i];
            if(phone_book[i+1].length() <= size)
                continue;
            String temp = phone_book[i+1].substring(0,size);
            if(s.equals(temp)){
                return false;
            }
        }
        return answer;
    }
}