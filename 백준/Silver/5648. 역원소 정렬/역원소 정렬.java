import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder temp;
        List<Long> list = new ArrayList<>();

        long n = sc.nextLong();

        for (long i = 0; i < n; i++) {
            temp = new StringBuilder();
            temp.append(sc.nextLong());
            list.add(Long.parseLong(temp.reverse().toString()));
        }

//        while (true) {
//            String s = br.readLine();
//            if (s == null || s.equals("")) break;
//            st = new StringTokenizer(s);
//
//            size = st.countTokens();
//            for (int i = 0; i < size; i++) {
//                temp = new StringBuilder();
//                temp.append(st.nextToken());
//                list.add(Long.parseLong(temp.reverse().toString()));
//            }
//        }

        list.stream().sorted().forEach(i -> sb.append(i).append("\n"));

        System.out.println(sb);
        br.close();
    }
}
