import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Seat {
    int x;
    int y;
    int friendCnt;
    int emptyCnt;

    public Seat(int x, int y, int friendCnt, int emptyCnt) {
        this.x = x;
        this.y = y;
        this.friendCnt = friendCnt;
        this.emptyCnt = emptyCnt;
    }
}

public class Main {

    static int N, studentCnt;
    static int[][] map;
    static Map<Integer, int[]> hashMap = new HashMap<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int score = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        studentCnt = N * N;
        map = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int[] likeFriends = new int[4];

            for (int j = 0; j < 4; j++) {
                likeFriends[j] = Integer.parseInt(st.nextToken());
            }

            hashMap.put(student, likeFriends);
            pustStudentSeat(student);
        }

        getScore();
        System.out.println(score);
    }

    private static void pustStudentSeat(int student) {
        int[] friends = hashMap.get(student);
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) continue;  // 이미 앉은 자리는 제외

                int friendCnt = 0;
                int emptyCnt = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        for (int l = 0; l < 4; l++) {
                            if (map[nx][ny] == friends[l]) friendCnt++;
                        }

                        if (map[nx][ny] == 0) emptyCnt++;
                    }
                }
                seats.add(new Seat(i, j, friendCnt, emptyCnt));
            }
        }

        seats.sort((o1, o2) -> {
            if (o1.friendCnt == o2.friendCnt) {
                if (o1.emptyCnt == o2.emptyCnt) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;  // 열 번호 작은 순
                    }
                    return o1.x - o2.x;  // 행 번호 작은 순
                }
                return o2.emptyCnt - o1.emptyCnt;  // 빈 칸 많은 순
            }
            return o2.friendCnt - o1.friendCnt;  // 친구 많은 순
        });

        for (Seat seat : seats) {
            if (map[seat.x][seat.y] == 0) {  // 빈 자리인 경우에만
                map[seat.x][seat.y] = student;
                return;
            }
        }
    }

    private static void getScore() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int[] friends = hashMap.get(map[i][j]);
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        for (int l = 0; l < 4; l++) {
                            if (map[nx][ny] == friends[l]) count++;
                        }
                    }
                }

                if (count == 1) score += 1;
                else if (count == 2) score += 10;
                else if (count == 3) score += 100;
                else if (count == 4) score += 1000;  // count가 4일 때만 1000점
                // count == 0일 때는 점수 추가 안 함
            }
        }
    }
}
