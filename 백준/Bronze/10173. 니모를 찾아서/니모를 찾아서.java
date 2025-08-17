import java.util.*;
import java.io.*;

interface Main{
    static void main(String[]a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        String regex = "(?i).*nemo.*";
        while(!(str = br.readLine()).equals("EOI")){
          if(str.matches(regex)) {
            bw.write("Found");
          } else {
            bw.write("Missing");
          }
          bw.newLine();
      }
      bw.flush();
    }
}