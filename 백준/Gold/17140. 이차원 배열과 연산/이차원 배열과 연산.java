import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] arr;
    static int[][] temp;
    static int time = 0;
    static int rowSize = 3;
    static int colSize = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        r = Integer.parseInt(tokens[0]) - 1;
        c = Integer.parseInt(tokens[1]) - 1;
        k = Integer.parseInt(tokens[2]);

        arr = new int[100][100];

        for (int i = 0; i < 3; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        if (numberCheck()) {
            System.out.println(0);
            return;
        }

        while (time < 100) {
            time++;

            if (rowSize >= colSize) {
                functionR();
            } else {
                functionC();
            }

            if (numberCheck()) {
                System.out.println(time);
                return;
            }


        }

        System.out.println(-1);
    }

    private static void functionR() {
        List<int[]> list;
        Map<Integer, Integer> numberCount;

        temp = new int[100][100];

        int prevColSize = colSize;
        int prevRowSize = rowSize;

        int maxListSize = 0;
        for (int i = 0; i < prevRowSize; i++) {
            numberCount = new HashMap<>();
            list = new ArrayList<>();

            for (int j = 0; j < prevColSize; j++) {
                int num = arr[i][j];
                if (num != 0)
                    numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
            }

            for (Integer key : numberCount.keySet()) {
                list.add(new int[]{key, numberCount.get(key)});
            }

            list.sort((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            for (int j = 0; j < list.size(); j++) {
                temp[i][j * 2] = list.get(j)[0];
                temp[i][j * 2 + 1] = list.get(j)[1];
            }

            maxListSize = Math.max(maxListSize, list.size() * 2);
        }

        colSize = Math.max(colSize, maxListSize);
        colSize = Math.min(colSize, 100);

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    private static void functionC() {
        List<int[]> list;
        Map<Integer, Integer> numberCount;

        temp = new int[100][100];
        int prevColSize = colSize;
        int prevRowSize = rowSize;

        int maxListSize = 0;
        for (int i = 0; i < prevColSize; i++) {
            numberCount = new HashMap<>();
            list = new ArrayList<>();

            for (int j = 0; j < prevRowSize; j++) {
                int num = arr[j][i];
                if (num != 0)
                    numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
            }

            for (Integer key : numberCount.keySet()) {
                list.add(new int[]{key, numberCount.get(key)});
            }

            list.sort((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            for (int j = 0; j < list.size(); j++) {
                temp[j * 2][i] = list.get(j)[0];
                temp[j * 2 + 1][i] = list.get(j)[1];
            }

            maxListSize = Math.max(maxListSize, list.size() * 2);
        }

        rowSize = Math.max(rowSize, maxListSize);
        rowSize = Math.min(rowSize, 100);

        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(arr[i], 0);
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

    private static boolean numberCheck() {
        if (r >= rowSize || c >= colSize) return false;
        return arr[r][c] == k;
    }
}
