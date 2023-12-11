import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        for (int i : list) System.out.print(i + " ");

    }


}


