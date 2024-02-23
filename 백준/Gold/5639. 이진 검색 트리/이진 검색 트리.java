import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) break;
            root.insertNode(Integer.parseInt(s));
        }
        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.node);
    }

    static class Node {
        int node;
        Node left, right;

        Node(int node) {
            this.node = node;
        }

        void insertNode(int node) {
            if (node > this.node) {
                if (this.right == null) this.right = new Node(node);
                else this.right.insertNode(node);
            } else if (node < this.node) {
                if (this.left == null) this.left = new Node(node);
                else this.left.insertNode(node);
            }
        }
    }

}
