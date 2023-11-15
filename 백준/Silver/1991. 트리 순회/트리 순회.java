import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node node = new Node('A', null, null);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);
            insertNode(node, root, leftNode, rightNode);
        }
        preOrder(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOder(node);

    }

    static void insertNode(Node temp, char root, char leftNode, char rightNode) {
        if (temp.node == root) {
            if (leftNode == '.') temp.leftNode = null;
            else temp.leftNode = new Node(leftNode, null, null);
            if (rightNode == '.') temp.rigthNode = null;
            else temp.rigthNode = new Node(rightNode, null, null);
        } else {
            if (temp.leftNode != null) insertNode(temp.leftNode, root, leftNode, rightNode);
            if (temp.rigthNode != null) insertNode(temp.rigthNode, root, leftNode, rightNode);
        }
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.node);
        preOrder(node.leftNode);
        preOrder(node.rigthNode);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.leftNode);
        System.out.print(node.node);
        inOrder(node.rigthNode);
    }

    static void postOder(Node node) {
        if (node == null) return;
        postOder(node.leftNode);
        postOder(node.rigthNode);
        System.out.print(node.node);
    }

    static class Node {
        char node;
        Node leftNode;
        Node rigthNode;

        Node(char node, Node leftNode, Node rigthNode) {
            this.node = node;
            this.leftNode = leftNode;
            this.rigthNode = rigthNode;
        }
    }

}
