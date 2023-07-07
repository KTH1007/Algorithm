import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] node;
    static int count = 0, delete;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        node = new int[n];
        int root = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            node[i] = Integer.parseInt(st.nextToken());
            if(node[i] == -1) root = i;
        }
        delete = Integer.parseInt(br.readLine());
        deleteNode(delete);
        visited = new boolean[n];
        countLeaf(root);
        System.out.println(count);
    }
    static void deleteNode(int d){
        node[d] = -2;  //삭제된 노드는 -2로 표시
        for(int i=0; i<n; i++){
            if(node[i] == d){
                deleteNode(i);
            }
        }
    }
    static void countLeaf(int s){
        boolean isLeaf = true;
        visited[s] = true;
        if(node[s] != -2){
            for(int i=0; i<n; i++){
                if(node[i] == s && !visited[i]){
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) count++;
        }
    }

}
