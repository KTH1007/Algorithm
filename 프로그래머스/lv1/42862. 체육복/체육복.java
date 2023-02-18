import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for(int i=0; i<reserve.length; i++){
            arr[reserve[i]-1]++;
        }
        for(int i=0; i<lost.length; i++){
            arr[lost[i]-1]--;
        }
        if(arr[0] == 0){
            if(arr[1] == 2){
                arr[0]++;
                arr[1]--;
            }
        }
        if(arr[n-1] == 0){
            if(arr[n-2] == 2){
                arr[n-1]++;
                arr[n-2]--;
            }
        }
        for(int i=1; i<n-1; i++){
            if(arr[i] == 0){
                if(arr[i-1] == 2){
                    arr[i-1]--;
                    arr[i]++;
                }
                else if(arr[i+1] == 2){
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] != 0)
                answer++;
        }
        return answer;
    }
}