import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length() / 3;
        int remainder = s.length() % 3;


        if (remainder == 1) {
            s = "00" + s;
        } else if (remainder == 2) {
            s = "0" + s;
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i += 3) {
            String temp = s.substring(i, i + 3);
            if (temp.equals("000")) sb.append("0");
            else if (temp.equals("001")) sb.append("1");
            else if (temp.equals("010")) sb.append("2");
            else if (temp.equals("011")) sb.append("3");
            else if (temp.equals("100")) sb.append("4");
            else if (temp.equals("101")) sb.append("5");
            else if (temp.equals("110")) sb.append("6");
            else if (temp.equals("111")) sb.append("7");
        }

        System.out.println(sb);


    }
}
