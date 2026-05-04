import java.util.*;

// 1 2 3 4 5 current
// 4 3 1 2 5 order 

// 1 2 3 보관  subContainer main에는 4 5 남음
// 3 꺼냄 1 2 남음 
// 1꺼내야 되는데 못꺼냄 끝

// main은 1부터 order 크기만큼 있음
// main 컨테이너와 order[index]가 다르면 서브컨테이너로 푸쉬
// 같으면 answer 증가

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int index = 0;
        Deque<Integer> subContainer = new ArrayDeque<>();
        
        int current = 1;
        while (current <= order.length) {
            if (current > order.length) {
                if (!subContainer.isEmpty() && subContainer.peek() != order[answer]) {
                    break;
                }
            }
            
            // current가 order 번호랑 같으면 answer 증가
            if (current == order[answer]) {
                answer++;
                current++;
            } else if (!subContainer.isEmpty() && subContainer.peek() == order[answer]) {
                subContainer.pop();
                answer++;
            } else {
                subContainer.push(current);
                current++;
            }
        }
        
        while (!subContainer.isEmpty()) {
            if (subContainer.pop() == order[answer]) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}