import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", " ");
        String[] arr = s.split(" ");
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            String[] newArr = arr[i].split(",");
            for (int j = 0; j < newArr.length; j++) {
                int n = Integer.parseInt(newArr[j]);
                if (!list.contains(n)) list.add(n);
            }
        }
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}