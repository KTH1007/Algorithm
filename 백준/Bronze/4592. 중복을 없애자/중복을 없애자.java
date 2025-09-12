import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String str = br.readLine();

            if (str.equals("0")){
                break;
            }else{
                String [] number = str.split(" ");
                int count = Integer.parseInt(number[0]);
                
                int [] num = new int[count];

                for (int i = 0; i < count; i++) {
                    num[i] = Integer.parseInt(number[i + 1]);
                }
                
                int index = -1;
                for (int i = 0; i < count; i++) {
                    if (num[i] != index){
                        sb.append(num[i]).append(" ");
                        index = num[i];
                    }
                }

                sb.append("$").append("\n");

            }
        }

        System.out.println(sb.toString());
    }
}
