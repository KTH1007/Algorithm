import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2).toUpperCase();
            if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z'
               && temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z') {
                list1.add(str1.substring(i, i + 2).toUpperCase());
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2).toUpperCase();
            if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z'
               && temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z') {
                list2.add(str2.substring(i, i + 2).toUpperCase());
            }
        }
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for (String s : list2) {
            union.add(s);
        }
        
        double intersectionSize = (double) intersection.size();
        double unionSize = (double) union.size();
        
        
        if (intersectionSize == 0 && unionSize == 0) return 65536;
        
        answer = (int) ((intersectionSize / unionSize) * 65536);

        return answer;
    }
}