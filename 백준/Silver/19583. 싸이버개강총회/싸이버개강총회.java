import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();

        String[] temp = st.nextToken().split(":");
        int startTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        temp = st.nextToken().split(":");
        int endTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        temp = st.nextToken().split(":");
        int lastEndTime = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

        int count = 0;

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;

            st = new StringTokenizer(s);
            temp = st.nextToken().split(":");
            int time = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

            String name = st.nextToken();

            if (time <= startTime) set.add(name);
            else if (time >= endTime && time <= lastEndTime) {
                if (set.contains(name)) {
                    set.remove(name);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
