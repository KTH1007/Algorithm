import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< progresses.length; i++){
            queue.add(progresses[i]);
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> speedList = new ArrayList<>();
        for(int i=0; i<speeds.length; i++){
            speedList.add(speeds[i]);
        }
        while(!queue.isEmpty()){
            int count = 0;
            //현재 진도가 100%가 넘은 서비스가 있는지 확인하고 있으면
            //그 서비스를 배포하고 count값 증가시킴
            int size = queue.size();
            for(int i=0; i<size; i++){
                if(queue.peek() >= 100){
                    queue.poll();
                    speedList.remove(0);
                    count++;
                }
            }
            size = queue.size();
            //남은 서비스들은 speeds 배열에 있는 속도만큼 작업을 더해줌
            for(int i=0; i<size; i++){
                int a = queue.poll();
                a += speedList.get(i);
                queue.add(a);
                //System.out.println(a);
            }
            //System.out.println();
            //배포된게 하나라도 있다면 list에 추가
            if(count != 0)
                list.add(count);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}