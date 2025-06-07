import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] puzzle = new char[4][4];
        int totalDistance = 0;

        // 4x4 퍼즐 상태 입력 받기
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 4; j++) {
                puzzle[i][j] = line.charAt(j);
            }
        }

        // 각 알파벳 조각(A-O)에 대해 맨해튼 거리 계산
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char currentTile = puzzle[i][j];

                // 빈 칸은 계산에서 제외
                if (currentTile == '.') {
                    continue;
                }

                // 목표 위치 계산
                int targetRow = (currentTile - 'A') / 4;
                int targetCol = (currentTile - 'A') % 4;

                // 맨해튼 거리 계산 및 누적
                // |현재 행 - 목표 행| + |현재 열 - 목표 열|
                totalDistance += Math.abs(i - targetRow) + Math.abs(j - targetCol);
            }
        }

        // 결과 출력
        System.out.println(totalDistance);
    }
}