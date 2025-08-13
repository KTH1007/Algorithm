import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String filteredStr = br.readLine().chars().mapToObj(e -> (char) e)
                .filter(ch -> !(ch >= '0' && ch <= '9'))
                .map(String::valueOf).collect(Collectors.joining());
        System.out.print(filteredStr.contains(br.readLine()) ? 1 : 0);
    }
}