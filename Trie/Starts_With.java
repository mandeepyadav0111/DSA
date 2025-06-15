public class Starts_With {
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
////////////////////
    public static boolean startswith(Node root, String str){
        Node curr= root;
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(curr.children[ch-'a']==null){
                return false;
            }
            curr=curr.children[ch-'a'];
        }
        return true;
    }
   
    public static void main(String[] args) {
        String [] words={"mango", "banana","apple", "app", "woman"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);   
        }  

        System.out.println("----------------");
        System.out.println(startswith(root, "app"));
    }
    
}
