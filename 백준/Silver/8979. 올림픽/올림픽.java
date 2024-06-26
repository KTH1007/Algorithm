import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            list.add(temp);
        }

        Collections.sort(list, (int[] o1, int[] o2) -> {
            if (o2[1] == o1[1]) {
                if (o2[2] == o1[2]) {
                    if (o2[3] == o1[3]) {
                        return o1[3] - o2[3];
                    } else
                        return o2[3] - o1[3];
                } else {
                    return o2[2] - o1[2];
                }
            } else {
                return o2[1] - o1[1];
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        int lank = 1;
        int count = 0;
        map.put(list.get(0)[0], lank);
        lank++;
        for (int i = 1; i < n; i++) {
            int[] temp = list.get(i);
            if (temp[1] == list.get(i - 1)[1] && temp[2] == list.get(i - 1)[2] && temp[3] == list.get(i - 1)[3]) {
                map.put(temp[0], --lank);
                count++;
            } else {
                lank += count;
                count = 0;
                map.put(temp[0], lank);
            }
            lank++;
        }

        System.out.println(map.get(k));
    }
}
