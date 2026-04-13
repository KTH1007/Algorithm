import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    public int[] solution(String s) {
        
        // 1개만 있는게 맨 처음 그 다음 2개짜리에서 포함되어 있지 않은 숫자 고르기
        // 문자열 맨 앞 {{, 맨 뒤 }} 제거
        // },{으로 나누기
        // 나눠진 문자 -> 2   2,1  2,1,3   2,1,3,4
        // 문자열 크기 순 정렬?
        // 각 문자열 배열마다 숫자인지 판별 후 list에 없으면 넣기
        
        s = s.substring(2, s.length() - 2);
        
        String[] strArr = s.split("\\},\\{");
        
        Arrays.sort(strArr, (o1, o2) -> o1.length() - o2.length());
        
        for (int i = 0; i < strArr.length; i++) {
            String[] splitArr = strArr[i].split(",");
            addList(splitArr);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private static void addList(String[] splitArr) {
        for (int i = 0; i < splitArr.length; i++) {
            int num = Integer.parseInt(splitArr[i]);
            if (!list.contains(num)) {
                list.add(num);
            }
        }
    }
}