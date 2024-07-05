import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();

        while (n-- > 0) {
            list.add(br.readLine().split(" "));
        }


        list.sort((s1, s2) -> {
            if (s1[3].equals(s2[3])) {
                if (s1[2].equals(s2[2])) {
                    if (s1[1].equals(s2[1])) {
                        return 0;
                    } else {
                        return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
                    }
                } else {
                    return Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);
                }
            } else {
                return Integer.parseInt(s1[3]) - Integer.parseInt(s2[3]);
            }

        });

        System.out.println(list.get(list.size() - 1)[0]);
        System.out.println(list.get(0)[0]);

        br.close();
    }

}
