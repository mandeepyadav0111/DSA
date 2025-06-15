public class Uiqu_Prefix {
      static class Node{
        Node[] children = new Node[26];
        boolean endofword=false;
        int frequency;
        Node(){
            for (int i = 0; i < 26; i++) {
                children[i]= null;  
            }
            frequency=1;
        }
    }
    public static Node root= new Node();

    public static void insert( String word){
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            char ch= word.charAt(i);
            if(curr.children[ch- 'a']==null){
                curr.children[ch- 'a']=new Node();
            }else{
                curr.children[ch- 'a'].frequency++;
            }
            curr=curr.children[ch- 'a'];  
        }
        curr.endofword=true;
    }

////////////////////////
    public static void findUniquePrefixes(Node node, String prefix) {
    if (node == null) return;
    
    // If frequency is 1, this is a unique prefix
    if (node.frequency == 1) {
        System.out.println(prefix);
        return;
    }

    // Recurse for all children
    for (char ch = 'a'; ch <= 'z'; ch++) {
        if (node.children[ch - 'a'] != null) {
            findUniquePrefixes(node.children[ch - 'a'], prefix + ch);
        }
    }
}

    public static void main(String[] args) {
        String[] words={"dog", "dove", "duck", "zebra"};
        for (String word : words) {
        insert(word);
    }

    System.out.println("-----------------");
    System.out.println("Unique Prefixes:");
    findUniquePrefixes(root, "");
    
    }
    
}
