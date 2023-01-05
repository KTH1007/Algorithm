class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" +");
        int linear = 0;
        int constant = 0;
        for(String s : arr){
            if(s.equals("x"))
                linear += 1;
            else if(s.contains("x"))
                linear += Integer.parseInt(s.substring(0, s.length()-1));
            else if(!s.equals("+"))
                constant += Integer.parseInt(s);
        }
        if(linear != 0 && constant != 0){
            if(linear == 1)
                answer += "x" + " + " + constant;
            else
                answer += linear + "x" + " + " + constant;
        }
        else if(linear != 0 && constant == 0)
            if(linear == 1)
                answer += "x";
            else
                answer += linear + "x";
        else if(linear == 0 && constant != 0)
            answer += constant;
        return answer;
    }
}