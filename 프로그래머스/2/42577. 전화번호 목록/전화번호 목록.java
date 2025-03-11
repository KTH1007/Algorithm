import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 문자열 특성을 이용하기 위해 정렬
        Arrays.sort(phone_book);
        
        // 해당 문자열이 접두어인 경우 그 뒤에 접두어를 사용하는 문자열이 오게 됨
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
            }
        }
        
        return answer;
    }
}