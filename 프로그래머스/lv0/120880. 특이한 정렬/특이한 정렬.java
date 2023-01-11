import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Integer[] arr = new Integer[numlist.length];
        for(int i=0; i<numlist.length; i++){
            arr[i] = numlist[i];
        }
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                int o1abs = Math.abs(o1-n);
                int o2abs = Math.abs(o2-n);
                if(o1abs == o2abs){
                    if(o1>o2)
                        return -1;
                    else if(o1<o2)
                        return 1;
                }
                else
                    return o1abs-o2abs;
                return 0;
            }
        });
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}