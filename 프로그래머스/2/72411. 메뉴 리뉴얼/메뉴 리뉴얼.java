import java.util.*;
class Solution {
    static List<String> stringList = new ArrayList<>();
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        // 정렬 후 문자열 조합
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);
            for (int j = 2; j <= sortedOrder.length(); j++) {
                back(0, "", j, 0, sortedOrder);
            }
        }
        
        // 문자열 조합 개수를 얻기 위해 map에 put
        for (int i = 0; i < stringList.size(); i++) {
            map.put(stringList.get(i), map.getOrDefault(stringList.get(i), 0) + 1);
        }
        
        // 조건에 맞는 값 넣기
        for (int i = 0; i < course.length; i++) {
            List<Order> orderList = new ArrayList<>();
            for (String key : map.keySet()) {
                if (key.length() == course[i]) {
                    orderList.add(new Order(key, map.get(key)));
                }
            }
            
            // List 크기 순 정렬
            orderList.sort((o1, o2) -> o2.count - o1.count);
            
            // 최소 2번 이상 주문된 조합
            if (!orderList.isEmpty() && orderList.get(0).count >= 2) {
                int maxCount = orderList.get(0).count;
                for (Order order: orderList) {
                    if (order.count == maxCount) {
                        answer.add(order.order);
                    } else break;
                }
            }
            
        }
        
        answer.sort(null);
        return answer;
    }
    
    // 백트래킹을 이용하여 문자열 조합 생성
    private static void back(int depth, String newStr, int length, int at, String str) {
        if (depth == length) {
            stringList.add(newStr);
            return;
        }
        
        for (int i = at; i < str.length(); i++) {
            back(depth + 1, newStr + str.charAt(i), length, i + 1, str);
        }
    }
    static class Order{
        String order;
        int count;
        
        public Order(String order, int count) {
            this.order = order;
            this.count = count;
        }
    }
}