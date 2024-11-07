import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        double credit = 0;
        double grade = 0;

        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }

            st = new StringTokenizer(s);
            String name = st.nextToken();
            double currentCredit = Double.parseDouble(st.nextToken());
            String currentGrade = st.nextToken();

            if (currentGrade.equals("P")) {
                continue;
            }

            credit += currentCredit;
            grade += map.get(currentGrade) * currentCredit;
        }

        System.out.println(grade / credit);
    }
}
