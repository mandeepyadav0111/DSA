public class Kth_Level {
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

    static void kthlevel(Node root,int l, int k){
        if (root==null){
            return;
        }
        if (k==l){
            System.out.println(root.data);
            return;
        }
        kthlevel(root.left,l+1,k);
        kthlevel(root.right,l+1,k);
    }

    public static void main(String[] args) {
        Node root= new Node(1);                    //           1
        root.left=new Node(2);                     //          /  \
        root.right=new Node(3);                    //         2    3
        root.left.left=new Node(4);                //       /  \   / \
        root.left.right=new Node(5);               //      4   5   6  7
        root.right.left=new Node(6);               
        root.right.right=new Node(7);              
        
        int k=3;
        System.out.println();
        kthlevel(root, 1, k);
        
    }
    
}
