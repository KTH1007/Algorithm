import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] strA = br.readLine().split(" ");
        int numA = Integer.parseInt(strA[0]);

        String [] strB = br.readLine().split(" ");
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < strB.length; i++) {
            int numB = Integer.parseInt(strB[i]);

            for (int j = 1; (j * numB) <= numA; j++) {
                if ((numB * j) > numA){
                    break;
                }else{
                    set.add(numB * j);
                }
            }
        }

        int answer = 0;
        for (Integer i : set) {
            answer += i;
        }

        sb.append(answer);
        System.out.println(sb.toString());

    }
}