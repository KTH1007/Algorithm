import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            // 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            TeamScore[] teamList = new TeamScore[n + 1];

            for (int i = 1; i <= n; i++) {
                teamList[i] = new TeamScore(i, k);
            }

            //  각 줄에는 팀 ID i, 문제 번호 j, 획득한 점수 s를 나타내는 세 개의 정수
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                teamList[id].updateScore(j, s);
                teamList[id].increaseSubmitCount();
                teamList[id].updateLastSubmitTime(i);
            }

            for (int i = 1; i <= n; i++) {
                teamList[i].calculateTotalScore();
            }

            // 점수 높은 순, 제출 횟수 적은 순, 마지막 제출 시간이 빠른 순

            Arrays.sort(teamList, 1, n + 1, (o1, o2) -> {
                if (o1.totalScore == o2.totalScore) {
                    if (o1.submitCount == o2.submitCount) {
                        return o1.lastSubmitTime - o2.lastSubmitTime;
                    }

                    return o1.submitCount - o2.submitCount;
                }
                return o2.totalScore - o1.totalScore;
            });

            int rank = 1;
            for (int i = 1; i <= n; i++) {
                if (teamList[i].id == t) {
                    break;
                }
                rank++;
            }

            sb.append(rank).append("\n");
        }

        System.out.println(sb);
    }

    static class TeamScore {
        private int id;
        private int[] problemsScores; // 문제 별 최고 점수
        private int totalScore;
        private int submitCount;
        private int lastSubmitTime;

        public TeamScore(int id, int problemCount) {
            this.id = id;
            this.problemsScores = new int[problemCount + 1];
            this.totalScore = 0;
            this.submitCount = 0;
            this.lastSubmitTime = 0;
        }

        // 문제 점수 갱신
        public void updateScore(int problem, int score) {
            problemsScores[problem] = Math.max(problemsScores[problem], score);
        }

        // 제출 횟수 증가
        public void increaseSubmitCount() {
            submitCount++;
        }

        // 마지막 제출 시간 갱신
        public void updateLastSubmitTime(int time) {
            lastSubmitTime = time;
        }

        // 총점 계산
        public void calculateTotalScore() {
            totalScore = 0;
            for (int score : problemsScores) {
                totalScore += score;
            }
        }
    }

}
