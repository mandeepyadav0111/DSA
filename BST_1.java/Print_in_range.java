public class Print_in_range {
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

    public static void printrange(Node root,int k1,int k2){
        if(root==null){
            return ;
        }
        if(k1<=root.data && root.data<=k2){
            printrange(root.left,k1,k2);
            System.out.println(root.data+" ");
            printrange(root.right,k1,k2);
        }
        else if(root.data<k1){
            printrange(root.left,k1,k2);
        }
        else{
            printrange(root.right,k1,k2);
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
   System.out.println("------------------------------");
   printrange(root,5,7);
    }
}
