import java.util.Arrays;
class Solution {
    public int[] solution(int num, int total) {
        int [] answer = new int[num];
        int a = total/num;
        int b = (num-1)/2;
        answer[b] = a;
        int n1 = a;
        int n2 = a;
        if(total % num == 0){
            for(int i=0; i<b; i++){
                answer[i] = --n1;
            }
            for(int i=b+1; i<num; i++){
                answer[i] = ++n2;
            }
        }
        else{
            for(int i=0; i<b; i++){
                answer[i] = --n1;
            }
            for(int i=b+1; i<num; i++){
                answer[i] = ++n2;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}