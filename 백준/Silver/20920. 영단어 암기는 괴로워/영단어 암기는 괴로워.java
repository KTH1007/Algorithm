import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.length() < m) continue;

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Word> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(new Word(s, map.get(s)));
        }

        list.sort((o1, o2) -> {
            if (o2.count == o1.count) {
                if (o2.word.length() == o1.word.length()) {
                    return o1.word.compareTo(o2.word);
                }
                return o2.word.length() - o1.word.length();
            }
            return o2.count - o1.count;
        });

        StringBuilder sb = new StringBuilder();

        for (Word word : list) {
            sb.append(word.word).append("\n");
        }

        System.out.println(sb);
    }

    private static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
