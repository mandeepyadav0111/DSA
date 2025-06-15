public class Mirror_image {
     public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
            }
    }
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node mirror(Node root){
        if (root==null){
            return null;
        }
        Node leftmirror=mirror(root.left);
        Node rightmirror=mirror(root.right);

        root.left=rightmirror;
        root.right=leftmirror;
        return root;
    }

    public static void main(String[] args) {
    Node root=new Node(5);
    root.left=new Node(3);
    root.right=new Node(7);
    root.left.left=new Node(2);
    root.left.right=new Node(4);
    root.right.left=new Node(6);
    root.right.right=new Node(8);
    
    System.out.println("--------------------------");
    Node result=mirror(root);
    //This time inorder will print descending order sorted values
    inorder(result);

    }
    
}
