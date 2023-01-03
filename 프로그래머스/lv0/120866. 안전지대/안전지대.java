class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] arr = new int[board.length][board.length];
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                for(int k=0; k<8; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(board[i][j] == 1)
                        arr[i][j] = 1;
                    if(nx >=0 && nx<board.length && ny >= 0 && ny<board.length && board[i][j] == 1)
                        arr[nx][ny] = 1;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] == 0)
                    answer++;
            }
        }
        return answer;
    }
}