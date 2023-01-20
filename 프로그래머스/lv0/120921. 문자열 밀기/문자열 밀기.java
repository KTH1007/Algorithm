class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String tempA = A;

        for(int i=0; i<A.length(); i++){
            if(tempA.equals(B)) return answer;
            String a = tempA.substring(tempA.length()-1);
            tempA = a + tempA.substring(0, tempA.length()-1);
            answer++;
        }
        return -1;
    }
}