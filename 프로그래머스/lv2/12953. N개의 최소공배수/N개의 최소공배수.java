import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if(arr.length == 1)
            return arr[0];
        answer = (arr[0] * arr[1]) / gcd(arr[0],arr[1]);
        if(arr.length > 2){
            for(int i=2; i<arr.length; i++){
                answer = (answer * arr[i]) / gcd(answer, arr[i]);
            }
        }
        return answer;
    }
    static int gcd(int a, int b){
        if(b == 0)
            return a;
        else{
            return gcd(b, a%b);
        }
    }
}