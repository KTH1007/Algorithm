import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        //도전자 수
        double[] challenger = new double[N+1];
        //도전중인 스테이지
        double[] challengeStage = new double[N+1];
        //실패율
        List<double[]> fail = new ArrayList<>();
        
        for(int i=0; i<stages.length; i++){
            //총 도전자 수
            for(int j=0; j<stages[i]; j++){
                challenger[j]++;
            }
            //클리어하지 못한 도전자 수
            challengeStage[stages[i]-1]++;
        }
        
        //실패율
        for(int i=0; i<N; i++){
            if(challenger[i] == 0)
                fail.add(new double[]{i,0});
            else
                fail.add(new double[]{i,challengeStage[i]/challenger[i]});
        }
        Collections.sort(fail, (o1,o2)->Double.compare(o2[1],o1[1]));
        for(int i=0; i<fail.size(); i++){
            answer[i] = (int)fail.get(i)[0]+1;
        }
        return answer;
    }
}