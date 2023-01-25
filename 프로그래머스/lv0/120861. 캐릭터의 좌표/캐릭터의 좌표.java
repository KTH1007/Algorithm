class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int xmax = board[0]/2;
        int ymax = board[1]/2;
        int[] answer = {0,0};
        for(int i=0; i<keyinput.length; i++){
            if(keyinput[i].equals("left")){
                answer[0]--;
                if(answer[0] < -xmax)
                    answer[0]++;
            }
            else if(keyinput[i].equals("right")){
                answer[0]++;
                if(answer[0] > xmax)
                    answer[0]--;
            }
            else if(keyinput[i].equals("up")){
                answer[1]++;
                if(answer[1] > ymax)
                    answer[1]--;
            }
            else if(keyinput[i].equals("down")){
                answer[1]--;
                if(answer[1] < -ymax)
                    answer[1]++;
            }
        }
        return answer;
    }
}