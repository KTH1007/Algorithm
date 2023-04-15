import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rux = 0;
        int ruy = 0;
        for(int i=0; i<wallpaper.length; i++){
            String wp = wallpaper[i];
            for(int j=0; j<wp.length(); j++){
                if(wp.charAt(j) == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rux = Math.max(rux, i);
                    ruy = Math.max(ruy, j);
                }
            }
        }
        int[] answer = {lux, luy, rux+1, ruy+1};
        return answer;
    }
}