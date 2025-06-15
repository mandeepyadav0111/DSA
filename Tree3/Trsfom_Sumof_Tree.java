import org.w3c.dom.Node;

public class Trsfom_Sumof_Tree {
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

     public static void pre(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        pre(root.left);
        pre(root.right);
    }


    public static int transform(Node root){
        if(root==null){
            return 0;
        }
        int leftchild=transform(root.left);
        int rightchild=transform(root.right);
        int newleft= root.left==null ? 0 : root.left.data;
        int newright=root.right==null? 0 : root.right.data;
        int data=root.data;
        root.data=leftchild+newleft + rightchild+newright;
        return data;
    }

   
      public static void main(String[] args) {
        Node root= new Node(1);                    //           1
        root.left=new Node(2);                     //          /  \
        root.right=new Node(3);                    //         2    3
        root.left.left=new Node(4);                //       /  \   / \
        root.left.right=new Node(5);               //      4   5   6  7
        root.right.left=new Node(6);               
        root.right.right=new Node(7);              
        
        int n1=7;
        int n2=4;
        System.out.println("Original tree ->");
        pre(root);
        System.out.println("Transformed tree ->");
        transform(root);
        pre(root);
        
    }
}
