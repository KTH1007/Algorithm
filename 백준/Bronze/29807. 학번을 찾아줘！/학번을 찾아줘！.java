import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;

        if (arr[0] > arr[2]) answer = (arr[0] - arr[2]) * 508;
        else answer = (arr[2] - arr[0]) * 108;
        if (arr[1] > arr[3]) answer += (arr[1] - arr[3]) * 212;
        else answer += (arr[3] - arr[1]) * 305;
        if (n == 5) answer += arr[4] * 707;

        answer *= 4763;

        System.out.println(answer);
    }
}
