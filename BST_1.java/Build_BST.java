public class Build_BST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node buildbst(Node root, int n) {
        if (root == null) return new Node(n);

        if (n > root.data) {
            root.right = buildbst(root.right, n);
        } else {
            root.left = buildbst(root.left, n);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int n : arr) {
            root = buildbst(root, n);
        }
         System.out.println();
        inorder(root); // Output: 1 2 3 4 5 7
    }
}
