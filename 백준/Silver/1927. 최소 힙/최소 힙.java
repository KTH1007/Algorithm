import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int n = Integer.parseInt(st.nextToken());
    for(int i=0; i<n; i++){
      int a = Integer.parseInt(br.readLine());
      if(a == 0 && pq.size() == 0)
        System.out.println(0);
      else if(a == 0 && pq.size() != 0){
        int m = pq.poll();
        System.out.println(m);
      }
      else
        pq.add(a);
    }
  }
}