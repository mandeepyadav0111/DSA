public class Unique_Substrings {
    
    static class Node{
        Node[] children = new Node[26];
        boolean endofword=false;
        Node(){
            for (int i = 0; i < 26; i++) {
                children[i]= null;  
            }
        }
    }
    public static Node root= new Node();

    public static void insert( String word){
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch= word.charAt(i);
            if(curr.children[ch- 'a']==null){
                curr.children[ch- 'a']=new Node();
            }
            curr=curr.children[ch- 'a'];  
        }
        curr.endofword=true;
    }

    public static boolean search(String key){
        Node curr=root;
        for (int i = 0; i < key.length(); i++) {
            char ch= key.charAt(i);
            if(curr.children[ch- 'a']==null){
                return false;
            }
            curr=curr.children[ch- 'a'];   
        }
        if(curr.endofword==true){
            return true;
        }
        return false;
    }
    ////////////////////////////
    /// count will give us unique substrings of a string
    public static int countnodes(Node root){
        if(root==null){
            return 0;
        }
        int count =0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null){
                count+=countnodes(root.children[i]);
            }
        }
        //backtracking
        return count+1;

    }
    public static void main(String[] args) {
        String word="ababa";
        for (int i = 0; i < word.length(); i++) {
            String substring=word.substring(i);  
            insert(substring);

        }  

        System.out.println("----------------------");
       System.out.println(countnodes(root));
    }
    
}
