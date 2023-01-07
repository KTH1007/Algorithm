class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] arr = new int[1001];
        for(int i=0; i<array.length; i++){
            arr[array[i]]++;
        }
        int max = 0;
        int max_item = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max_item = i;
                max = arr[i];
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == max){
                count++;
            }
        }
        if(count > 1)
            answer = -1;
        else
            answer = max_item;
        
        return answer;
    }
}