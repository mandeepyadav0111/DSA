public class SumofNodes {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int sumofnodes(Node root){
        if (root==null){
            return 0;
        }
        int leftsum=sumofnodes(root.left);
        int rightsum=sumofnodes(root.right);

         return leftsum+rightsum+root.data;
    }
    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        
        System.out.println();
        int result= sumofnodes(root);
        System.out.println("Sum of nodes of tree:"+ result);
    } 
    
}
