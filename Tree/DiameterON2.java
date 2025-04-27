public class DiameterON2 {
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

    static int diameteroftree(Node root){
        if(root==null){
            return 0;
        }
        int ld=diameteroftree(root.left);
        int rd=diameteroftree(root.right);
        int lh=heightoftree(root.left);
        int rh=heightoftree(root.right);
        return Math.max(lh+rh+1,Math.max(ld,rd));
    }

  
   
    public static void main(String[] args) {
        Node root= new Node(1);                    //           1
        root.left=new Node(2);                     //          /  \
        root.right=new Node(3);                    //         2    3
        root.left.left=new Node(4);                //       /  \   / 
        root.left.right=new Node(5);               //      4   5  6  
        root.right.left=new Node(6);               
                     
        
        System.out.println();
        int result= diameteroftree(root);
        System.out.println("Diameter of tree is:"+ result);
    } 

    
}
