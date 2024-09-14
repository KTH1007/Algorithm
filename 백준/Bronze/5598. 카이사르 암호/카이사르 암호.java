import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> encodedList = br.readLine().codePoints().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> decodedList = encodedList.stream().map(Main::findDecodedChar).collect(Collectors.toList());

        decodedList.forEach(System.out::print);
    }

    private static char findDecodedChar(Character c) {
        int tempVal = Integer.valueOf(c) - 3;
        if (tempVal < 'A') {
            tempVal = 'Z' + ((tempVal) - 'A' + 1);
        }
        return (char) tempVal;
    }
}
