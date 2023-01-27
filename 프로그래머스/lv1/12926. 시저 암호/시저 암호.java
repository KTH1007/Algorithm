class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            int a = s.charAt(i) + n;
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90 && a > 90)
                a = a-26;
            else if(s.charAt(i) >= 97 && s.charAt(i) <= 122 && a > 122)
                a = a-26;
            else if(s.charAt(i) == ' ')
                a = ' ';
            arr[i] = (char)a;
        }
        answer = String.valueOf(arr);
        return answer;
    }
}