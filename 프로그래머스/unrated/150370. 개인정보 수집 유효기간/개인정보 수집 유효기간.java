import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] arr = new int[privacies.length];
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<terms.length; i++){
            String t = terms[i];
            String t1 = t.substring(0,1);
            String t2 = t.substring(2);
            map.put(t1, Integer.parseInt(t2));  // 약관 종류에 대한 기간
        }
        
        //today
        today = today.replace(".","");
        int year = Integer.parseInt(today.substring(2,4));
        int month = Integer.parseInt(today.substring(4,6));
        int day = Integer.parseInt(today.substring(6));
        int cnt = (year *12 *28) + (month * 28) + day;   
        //약관 유효기간 계산
        for(int i=0; i<privacies.length; i++){
            String p = privacies[i];
            p = p.replace(".", "");
            
            int y = Integer.parseInt(p.substring(2,4));
            int m = Integer.parseInt(p.substring(4,6));
            int d = Integer.parseInt(p.substring(6,8));
            String t = p.substring(9);
            
            int cnt2 = (y*12*28) + (m*28) + d + (map.get(t) * 28);
            if(cnt >= cnt2){
                arr[i] = i+1;
            }
                
        }
        int k = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0)
                k++;
        }
        int[] answer = new int[k];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}