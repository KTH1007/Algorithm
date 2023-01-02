import java.util.Arrays;
class Solution {
    public int solution(int n) {
        
        int cnt = 0;
        if(n < 2) {
        	cnt = 0;
        }
        boolean[] b = new boolean[n+1];
        Arrays.fill(b , true);
        b [0] = b [1] = false;
        for(int i = 2; i*i <= n; i++){
        	 if(b[i]) {
        		 for(int j=i*i; j<=n; j+=i) {
 					b[j] = false;                
 				}
        	 }
        }
        for(int i=1; i<=n ;i++){
			if(b[i]) {
				cnt++; 
			}
		}
        int answer = cnt;
        return answer;
    }
}