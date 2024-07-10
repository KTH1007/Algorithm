import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int count = 1;

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;

            String[] temp = s.split(" ");

            List<Integer> list = new ArrayList<>();

            for (int i = 1; i < temp.length; i++) {
                list.add(Integer.parseInt(temp[i]));
            }

            list = list.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            int max = list.get(0);
            int min = list.get(list.size() - 1);
            int diff = 0;

            for (int i = 1; i < list.size(); i++) {
                int tempDiff = list.get(i - 1) - list.get(i);
                diff = Math.max(diff, tempDiff);
            }
            sb.append("Class ").append(count).append("\n");
            sb.append("Max ").append(max).append(", ").append("Min ").append(min).append(", ").append("Largest gap ").append(diff).append("\n");

            count++;
        }
        System.out.println(sb);
        br.close();
    }

}
