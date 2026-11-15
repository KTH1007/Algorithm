import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        /*
        앞에 기능이 배포 되어야 다음 배포 가능
        93 7일, 30, 3일, 55 9일, 7일째에 2개, 9일째에 1개 배포
        
        전체적으로 값을 증가시키고 100 이상인 프로세스 개수 세기
        
        개수 세는 함수, 값 증가 함수
        반복문에서 i번째 프로세스가 100 이상이면 개수 함수 아니면 증가 함수
        */
        
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
        }
        
        while (!queue.isEmpty()) {
            if (queue.peek() >= 100) {
                list.add(getCount(queue));
            } else {
                addQueue(queue, speeds);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private static void addQueue(Queue<Integer> queue, int[] speeds) {
        for (int i = speeds.length - queue.size(); i < speeds.length; i++) {
            queue.add(queue.poll() + speeds[i]);
        }
    }
    
    private static int getCount(Queue<Integer> queue) {
        int count = 0;
        
        while (!queue.isEmpty()) {
            if (queue.peek() >= 100) {
                count++;
                queue.poll();
            } else {
                break;
            }
        }
        
        return count;
    }
}