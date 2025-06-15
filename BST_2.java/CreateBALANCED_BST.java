public class CreateBALANCED_BST {
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

    static Node createBST(int[] arr, int si, int end){
        if(si > end){
            return null;
        }
        int mid= (si+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, si ,mid-1);
        root.right=createBST(arr,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        int [] arr={2,5,6,8,10,11,12};
        Node root=createBST(arr,0,arr.length-1);

        System.out.println("------------------------");
        inorder(root);


    }
    
}
