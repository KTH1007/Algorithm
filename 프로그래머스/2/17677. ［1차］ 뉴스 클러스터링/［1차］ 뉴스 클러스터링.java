import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 자카드 = 교집합 크기 / 합집합 크기
        // 공집합인 경우 -> 1
        // 중복허용 (map을 이용해서 개수를 카운트)
        // 문자 2개씩 자르기 (공백 및 특수기호가 들어오면 그 집합 버리기)
        
        Map<String, Integer> strMap1 = setCount(str1);
        Map<String, Integer> strMap2 = setCount(str2);
        
        int intersection = getCount(strMap1, strMap2)[0];
        int union = getCount(strMap1, strMap2)[1];
        
        if (intersection == 0 && union == 0) {
            return 65536;
        }
        
        answer = (int) ((intersection / (double) union) * 65536);
        
        return answer;
    }
    
    private static int[] getCount(Map<String, Integer> map1, Map<String, Integer> map2) {
        
        int[] arr;
        
        int intersection = 0;
        int union = 0;
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }
        
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                union += map2.get(key);
            } else if (map1.containsKey(key)) {
                union += Math.max(map1.get(key), map2.get(key));
            }
        }
        
        arr = new int[]{intersection, union};
        return arr;
    }
    
    private static Map<String, Integer> setCount(String s) {
        Map<String, Integer> strMap = new HashMap<>();
        
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            
            if (!(validateNum(c1) && validateNum(c2))) {
                continue;
            }
            String str = "" + c1 + c2;
            str = str.toUpperCase();
            strMap.put(str, strMap.getOrDefault(str, 0) + 1);
        }
        
        return strMap;
    }
    
    private static boolean validateNum(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        } 
        
        return false;
    }
}