class Solution {
    public String solution(int[] food) {
        String answer = "";
        // food / 2 몫을 인덱스 번호에 맞는 문자열로 저장
        // 문자열을 다 붙인 후 0을 붙이고 reverse 문자열 추가
        int[] arr = new int[food.length-1];
        for(int i=0; i<food.length-1; i++){
            arr[i] = food[i+1] / 2;
        }
        String s1 = "";
        String s2 = "";
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++){
                s1 += Integer.toString(i+1);
            }
        }
        for(int i=s1.length()-1; i>=0; i--){
            s2 += Character.toString(s1.charAt(i));
        }
        answer = s1 + "0" + s2;
        return answer;
    }
}