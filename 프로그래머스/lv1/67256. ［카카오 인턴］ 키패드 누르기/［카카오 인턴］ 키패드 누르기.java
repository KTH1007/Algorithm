class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int l = 10;
        int r = 12;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                l = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                r = numbers[i];
            }
            else{
                if(numbers[i] == 0)
                    numbers[i] = 11;
                int ln = Math.abs(l-numbers[i]);
                int lcount = ln/3 + ln%3;
                int rn = Math.abs(r-numbers[i]);
                int rcount = rn/3 + rn%3;
                if(lcount > rcount){
                    sb.append("R");
                    r = numbers[i];
                }
                    
                else if(rcount > lcount){
                    sb.append("L");
                    l = numbers[i];
                }
                    
                else{
                    if(hand.equals("left")){
                        sb.append("L");
                        l = numbers[i];
                    }
                    else{
                        sb.append("R");
                        r = numbers[i];
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}