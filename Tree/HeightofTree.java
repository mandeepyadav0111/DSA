public class HeightofTree {
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
    static int heightoftree(Node root){
        if (root==null){
            return 0;
        }
        int lh=heightoftree(root.left);
        int rh=heightoftree(root.right);

         return Math.max(lh,rh)+1;
    }

  
   
    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        
        System.out.println();
        int result= heightoftree(root);
        System.out.println("Height of tree:"+ result);
    } 
}     

