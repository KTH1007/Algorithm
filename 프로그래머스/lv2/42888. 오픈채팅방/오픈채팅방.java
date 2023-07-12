import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        String[][] arr = new String[record.length][3];
        for(int i=0; i<record.length; i++){
            arr[i] = record[i].split(" ");
            if(!arr[i][0].equals("Leave"))
                map.put(arr[i][1],arr[i][2]);

        }
        List<String> list = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            if(arr[i][0].equals("Enter"))
                list.add(map.get(arr[i][1]) + "님이 들어왔습니다.");
            else if(arr[i][0].equals("Leave"))
                list.add(map.get(arr[i][1]) + "님이 나갔습니다.");
        }
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}