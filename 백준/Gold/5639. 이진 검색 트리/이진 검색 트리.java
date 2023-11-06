import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String s;
        while (true) {
            s = br.readLine();
            if (s == null || s.equals("")) break;
            root.insert(Integer.parseInt(s));
        }
        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);

    }

    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
    
}
