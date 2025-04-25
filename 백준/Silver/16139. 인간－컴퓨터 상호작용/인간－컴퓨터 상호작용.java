import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] prefixAlpha = new int[26][s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 이전 값 불러오기
            for (int j = 0; j < 26; j++) {
                prefixAlpha[j][i + 1] = prefixAlpha[j][i];
            }

            prefixAlpha[c - 'a'][i + 1]++;
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int alphaIndex = alpha - 'a';

            int result = prefixAlpha[alphaIndex][end + 1] - prefixAlpha[alphaIndex][start];
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
