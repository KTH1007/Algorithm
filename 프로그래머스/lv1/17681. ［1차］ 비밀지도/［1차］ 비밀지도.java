import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer, "");
        int[][] map1 = new int[n][n];
        String[] binary1 = new String[arr1.length];
        String[] binary2 = new String[arr2.length];
        Arrays.fill(binary1, "");
        Arrays.fill(binary2, "");
        
        for(int i=0; i<arr1.length; i++){
            String a = Integer.toString(arr1[i], 2);
            if(a.length() != n){
                int b = n - a.length();
                for(int j=0; j<b; j++){
                    binary1[i] += "0";
                }
            }
            binary1[i] += Integer.toString(arr1[i], 2);
        }
        
        for(int i=0; i<arr2.length; i++){
            String a = Integer.toString(arr2[i], 2);
            if(a.length() != n){
                int b = n - a.length();
                for(int j=0; j<b; j++){
                    binary2[i] += "0";
                }
            }
            binary2[i] += Integer.toString(arr2[i], 2);
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(binary1[i].charAt(j) == '1' || binary2[i].charAt(j) == '1'){
                    answer[i] += "#";
                }
                else if(binary1[i].charAt(j) == '0' && binary2[i].charAt(j) == '0'){
                    answer[i] += " ";
                }
            }
        }
        
        return answer;
    }
}