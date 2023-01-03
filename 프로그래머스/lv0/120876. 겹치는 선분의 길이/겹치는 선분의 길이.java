class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[200]; //-100부터 100까지 길이를 저장하기 위한 배열
        //-배열을 만들 수 없기 때문에 100을 더해줌
        for(int i=0; i<lines.length; i++){
            for(int j=lines[i][0]+100; j<lines[i][1]+100; j++){
                arr[j]++;
            }
        }
        //arr 배열의 값이 2이상이면 겹쳐진 선분임
        for(int i=0; i<arr.length; i++){
            if(arr[i] >=2)
                answer++;
        }
        return answer;
    }
}