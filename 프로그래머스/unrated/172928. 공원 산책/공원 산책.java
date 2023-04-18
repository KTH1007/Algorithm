class Solution {
    public int[] solution(String[] park, String[] routes) {

        int startX = 0;
        int startY = 0;
        char[][] arr = new char[park.length][park[0].length()];
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    startX = j;
                    startY = i;
                }
                arr[i][j] = park[i].charAt(j);
            }
        }

        for(String s : routes){
            String[] sp = s.split(" ");
            String way = sp[0];
            int len = Integer.parseInt(sp[1]);
            int x = startX;
            int y = startY;
            for(int i=0; i<len; i++){
                if(way.equals("W"))
                    x--;
                else if(way.equals("E"))
                    x++;
                else if(way.equals("N"))
                    y--;
                else if(way.equals("S"))
                    y++;
                //공원 범위 안
                if(x >= 0 && y >= 0 && x < arr[0].length && y<arr.length){
                    if(arr[y][x] == 'X')
                        break;
                    //끝까지 이동했을 때 조건을 만족하면 수행
                    if(i == len -1){
                        startX = x;
                        startY = y;
                    }
                }
            }
        }
        int[] answer = {startY, startX};
        return answer;
    }
}