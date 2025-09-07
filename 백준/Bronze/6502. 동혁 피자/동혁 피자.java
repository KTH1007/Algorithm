import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        int count=0;
        while ((str = br.readLine()) != null) {
            if(str.equals("0")){
                break;
            }
            count++;


            String arr[] = str.split(" ");

            int r = Integer.parseInt(arr[0]);

            int w = Integer.parseInt(arr[1]);
            int l=Integer.parseInt(arr[2]);

            if(2*r >= Math.sqrt(w*w+l*l)){
                bw.write("Pizza "+String.valueOf(count)+" fits on the table.\n");
            }else{
                bw.write("Pizza "+String.valueOf(count)+" does not fit on the table.\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}