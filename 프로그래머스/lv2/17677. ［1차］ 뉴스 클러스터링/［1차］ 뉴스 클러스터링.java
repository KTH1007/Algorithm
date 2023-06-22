import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++){
          char first = str1.charAt(i);
          char second = str1.charAt(i + 1);
          
          if(first >= 'a' && first <= 'z' &&
             second >= 'a' && second <= 'z'){
              list1.add(first + "" + second);
          }
      }
      
      for(int i = 0; i < str2.length() - 1; i++){
          char first = str2.charAt(i);
          char second = str2.charAt(i + 1);
          
          if(first >= 'a' && first <= 'z' &&
             second >= 'a' && second <= 'z'){
              list2.add(first + "" + second);
          }
      }
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        for(String s : list1){
            if(list2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }
        for(String s : list2){
            union.add(s);
        }

        double d = 0.0;
        if(union.size() == 0)
            d = 1;
        else{
            d = ((double)intersection.size() / (double)union.size());
        }
        answer = (int)(d * 65536);
        return answer;
    }
}