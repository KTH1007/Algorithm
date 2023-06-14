import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-2);
        s = s.replace("{","");
        String[] arr = s.split("},");
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i].replace(",", " ");
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });
        // for(int i=0; i<arr.length; i++){
        //     System.out.println(arr[i]);
        // }
        List<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            String[] newS = arr[i].split(" ");
            for(int j=0; j<newS.length; j++){
                if(!list.contains(newS[j])){
                    list.add(newS[j]);
                }    
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
            
        
        return answer;
    }
}