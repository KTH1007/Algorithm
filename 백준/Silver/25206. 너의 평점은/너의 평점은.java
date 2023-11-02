import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double unitSum = 0;
        for (int t = 0; t < 20; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            double unit = Double.parseDouble(st.nextToken());
            String grades = st.nextToken();
            if (grades.equals("A+")) sum += unit * 4.5;
            else if (grades.equals("A0")) sum += unit * 4.0;
            else if (grades.equals("B+")) sum += unit * 3.5;
            else if (grades.equals("B0")) sum += unit * 3.0;
            else if (grades.equals("C+")) sum += unit * 2.5;
            else if (grades.equals("C0")) sum += unit * 2.0;
            else if (grades.equals("D+")) sum += unit * 1.5;
            else if (grades.equals("D0")) sum += unit * 1.0;
            if (!grades.equals("P")) unitSum += unit;
        }
        System.out.println(sum / unitSum);
    }


}
