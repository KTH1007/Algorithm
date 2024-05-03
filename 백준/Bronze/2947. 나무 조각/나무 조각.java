import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (arr[0] < arr[1] && arr[1] < arr[2] && arr[2] < arr[3] && arr[3] < arr[4]) break;
            for (int i = 0; i < 4; i++) {
                if (arr[i + 1] < arr[i]) {
                    sort(arr, i, i + 1);
                    print(arr, sb);
                }
            }
        }

        System.out.println(sb);
        ;
    }

    public static void print(int[] arr, StringBuilder sb) {
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }

    public static void sort(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
