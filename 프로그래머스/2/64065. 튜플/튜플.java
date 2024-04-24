import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.replace("},{", " ").split(" ");
        
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                if (!list.contains(temp[j])) {
                    list.add(temp[j]);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}