class Solution {
    public int[] solution(String s) {
        
        int count1 = 0;
        int count2 = 0;
        while(!s.equals("1")){
            String s2 = "";
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    count2++;
                }
                else
                    s2 += Character.toString(s.charAt(i));
            }
            int a = s2.length();
            s = Integer.toString(a, 2);
            count1++;
        }
        int[] answer = {count1, count2};
        return answer;
    }
}