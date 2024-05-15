import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        String[] arr = s.split(",");
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        for(int i=0; i<k; i++) {
            ArrayList<Integer> result = solution(list);
            list = result;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.size(); i++) {
            if(i==list.size()-1)
                sb.append(list.get(i));
            else
                sb.append(list.get(i)+",");
        }

        System.out.println(sb);
    }

    public static ArrayList<Integer> solution(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<list.size()-1; i++) {
//            result.add(Integer.toString(Integer.parseInt(list.get(i+1))-Integer.parseInt(list.get(i))));
            result.add(list.get(i + 1) - list.get(i));
        }
        return result;
    }

}
