import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Case = Integer.parseInt(br.readLine());
        double []arr = new double[Case];

        for(int i = 0; i < Case; i++){
            arr[i] = Double.parseDouble(br.readLine());
            double sum = arr[i] * 80 / 100;
            System.out.println("$" + String.format("%.2f", sum));
        }
    }
}