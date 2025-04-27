public class CoutNodes {
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
    static int countnodes(Node root){
        if (root==null){
            return 0;
        }
        int lh=countnodes(root.left);
        int rh=countnodes(root.right);

         return (lh+rh)+1;
    }
    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        
        System.out.println();
        int result= countnodes(root);
        System.out.println("Count of nodes of tree:"+ result);
    } 
    
}
