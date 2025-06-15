public class Searching_in_BST {
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

    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    
    }
public static void main(String[] args) {
    Node root=new Node(5);
    root.left=new Node(3);
    root.right=new Node(7);
    root.left.left=new Node(2);
    root.left.right=new Node(4);
    root.right.left=new Node(6);
    root.right.right=new Node(8);
    System.out.println();
    System.out.println(search(root,8));
}
    
}
