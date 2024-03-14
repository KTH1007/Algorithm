import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.replace("{", " ").replace("}", " ").trim().split(" , ");
         
        Arrays.sort(arr, (o1, o2) -> {return o1.length() - o2.length();});
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (String temp : arr[i].split(",")) {
                if (!list.contains(temp)) list.add(temp);
            }
        }

        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}