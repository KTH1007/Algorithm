import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        StringTokenizer st;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new int[]{location, height});

            maxHeight = Math.max(maxHeight, height);
        }

        list.sort((o1, o2) -> o1[0] - o2[0]);

        int answer = 0;
        int leftMax = 0;
        int leftPos = 0;

        // 왼쪽부터 최대 높이까지
        for (int[] pillar : list) {
            if (pillar[1] > leftMax) {
                answer += (pillar[0] - leftPos) * leftMax;
                leftMax = pillar[1];
                leftPos = pillar[0];
            }
            if (pillar[1] == maxHeight) break;
        }

        int rightMax = 0;
        int rightPos = 0;

        // 오른쪽부터 최대 높이까지
        for (int i = list.size() - 1; i >= 0; i--) {
            int[] pillar = list.get(i);
            if (pillar[1] > rightMax) {
                answer += (rightPos - pillar[0]) * rightMax;
                rightMax = pillar[1];
                rightPos = pillar[0];
            }
            if (pillar[1] == maxHeight) break;
        }

        // 최대 높이 구간의 면적 추가
        answer += (rightPos - leftPos + 1) * maxHeight;

        System.out.println(answer);
    }
}
