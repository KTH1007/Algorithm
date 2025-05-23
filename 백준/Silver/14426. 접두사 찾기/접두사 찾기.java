import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class TrieNode {
    Map<Character, TrieNode> childNode = new HashMap<>();
    boolean terminal;

    public void insert(String word) {
        TrieNode trieNode = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            trieNode.childNode.putIfAbsent(c, new TrieNode());
            trieNode = trieNode.childNode.get(c);

            if (i == word.length() - 1) {
                trieNode.terminal = true;
                return;
            }
        }
    }

    public boolean contains(String prefix) {
        TrieNode trieNode = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!trieNode.childNode.containsKey(c)) {
                return false;
            }

            trieNode = trieNode.childNode.get(c);
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TrieNode root = new TrieNode();

        for (int i = 0; i < n; i++) {
            root.insert(br.readLine());
        }

        int count =0;

        for (int i = 0; i < m; i++) {
            if (root.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);

    }
}
