import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] num = new int[3];
        int k=0;
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9'){
                if(dartResult.charAt(i) == '1' && dartResult.charAt(i+1) == '0'){
                    num[k] = 10;
                    i++;
                }
                else num[k] = dartResult.charAt(i) - '0';
            }
            else if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T'){
                if(dartResult.charAt(i) == 'S'){
                    k++;
                }
                else if(dartResult.charAt(i) == 'D'){
                    num[k] *= num[k];
                    k++;
                }
                else if(dartResult.charAt(i) == 'T'){
                    num[k] = (int)Math.pow(num[k],3);
                    k++;
                }
            }
            else{
                if(dartResult.charAt(i) == '*'){
                    num[k-1] *= 2;
                    if(k-2>=0)
                        num[k-2] *= 2;
                }
                else{
                    num[k-1] *= -1;
                }
            }
        }
        answer = num[0] + num[1] + num[2];
        return answer;
    }
}