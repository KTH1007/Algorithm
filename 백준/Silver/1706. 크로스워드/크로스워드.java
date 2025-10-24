import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String[][] map;
    static List<String> wordList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        map = new String[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j) + "";
            }
        }

        // 가로
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals("#")) {
                    String word = sb.toString();
                    if (!validateLength(word)) {
                        wordList.add(word);
                    }
                    sb.setLength(0);
                } else {
                    sb.append(map[i][j]);
                }
            }
            String word = sb.toString();
            if (validateLength(word)) continue;
            wordList.add(word);
            sb.setLength(0);
        }

        // 세로
        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if (map[j][i].equals("#")) {
                    String word = sb.toString();
                    if (!validateLength(word)) {
                        wordList.add(word);
                    }
                    sb.setLength(0);
                } else {
                    sb.append(map[j][i]);
                }
            }
            String word = sb.toString();
            if (validateLength(word)) continue;
            wordList.add(word);
            sb.setLength(0);
        }

        wordList.sort(String::compareTo);
        System.out.println(wordList.get(0));
    }

    private static boolean validateLength(String word) {
        return word.length() < 2;
    }
}
