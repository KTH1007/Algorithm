import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final String[] lyrics = {
            "baby", "sukhwan", "tururu", "turu", "very", "cute",
            "tururu", "turu", "in", "bed", "tururu", "turu",
            "baby", "sukhwan"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int index = (n - 1) % 14; // 반복되는 가사 위치
        int repeat = (n - 1) / 14; // 몇 번째 반복인지

        StringBuilder sb = new StringBuilder();

        if (lyrics[index].equals("tururu")) {
            int ruCount = 2 + repeat;
            if (ruCount >= 5) {
                sb.append("tu+ru*").append(ruCount);
            } else {
                sb.append("tu");
                for (int i = 0; i < ruCount; i++) {
                    sb.append("ru");
                }
            }
        } else if (lyrics[index].equals("turu")) {
            int ruCount = 1 + repeat;
            if (ruCount >= 5) {
                sb.append("tu+ru*").append(ruCount);
            } else {
                sb.append("tu");
                for (int i = 0; i < ruCount; i++) {
                    sb.append("ru");
                }
            }
        } else {
            sb.append(lyrics[index]);
        }

        System.out.println(sb);
    }
}
