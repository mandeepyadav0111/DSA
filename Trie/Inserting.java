
import java.util.*;

public class Inserting{
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

   
    public static void main(String[] args) {
        String [] words={"the", "a","there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);   
        }  
    }
}
