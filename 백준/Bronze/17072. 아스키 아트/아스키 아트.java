import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());

        StringBuilder imageStr = new StringBuilder();
        for (int i = 0; i < ySize; i++) {
            imageStr.append(br.readLine()).append(" ");
        }

        char[][] imageArr = new char[ySize][xSize];
        st = new StringTokenizer(imageStr.toString(), " ");
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                int redColor = Integer.parseInt(st.nextToken());
                int greenColor = Integer.parseInt(st.nextToken());
                int blueColor = Integer.parseInt(st.nextToken());

                int intensity = 2126 * redColor + 7152 * greenColor + 722 * blueColor;
                char ch;
                if (intensity >= 2040000) {
                    ch = '.';
                } else if (intensity >= 1530000) {
                    ch = '-';
                } else if (intensity >= 1020000) {
                    ch = '+';
                } else if (intensity >= 510000) {
                    ch = 'o';
                } else {
                    ch = '#';
                }
                imageArr[y][x] = ch;
            }
        }

        StringBuilder imageOutStr = new StringBuilder();
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                imageOutStr.append(imageArr[y][x]);
            }
            imageOutStr.append("\n");
        }
        System.out.println(imageOutStr);

        br.close();
    }

}
