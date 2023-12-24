import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 3; i++) min = Math.min(min, Integer.parseInt(br.readLine()));
        sum += min;

        min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) min = Math.min(min, Integer.parseInt(br.readLine()));

        sum += min;

        System.out.println(sum - 50);

    }


}


