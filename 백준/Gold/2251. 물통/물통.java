import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A,B,C;
    static boolean[][][] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201][201];
        BFS();
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,C});
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];

            if (visited[a][b][c]) {
                continue;
            }

            visited[a][b][c] = true;

            if (a == 0) {
                list.add(c);
            }

            // 첫 번째 물통에서 두 번째 물통으로 물 붓기
            if (a + b > B) {
                queue.add(new int[]{a + b - B, B, c});
            } else {
                queue.add(new int[]{0, a + b, c});
            }

            // 첫 번째 물통에서 세 번째 물통으로 물 붓기
            if (a + c > C) {
                queue.add(new int[]{a + c - C, b, C});
            } else {
                queue.add(new int[]{0, b, a + c});
            }

            // 두 번째 물통에서 첫 번째 물통으로 물 붓기
            if (b + a > A) {
                queue.add(new int[]{A, b + a - A, c});
            } else {
                queue.add(new int[]{b + a, 0, c});
            }

            // 두 번째 물통에서 세 번째 물통으로 물 붓기
            if (b + c > C) {
                queue.add(new int[]{a, b + c - C, C});
            } else {
                queue.add(new int[]{a, 0, b + c});
            }

            // 세 번째 물통에서 첫 번째 물통으로 물 붓기
            if (c + a > A) {
                queue.add(new int[]{A, b, c + a - A});
            } else {
                queue.add(new int[]{c + a, b, 0});
            }

            // 세 번째 물통에서 두 번째 물통으로 물 붓기
            if (c + b > B) {
                queue.add(new int[]{a, B, c + b - B});
            } else {
                queue.add(new int[]{a, c + b, 0});
            }
        }
    }

}

