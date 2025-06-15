import java.util.*;
public class Searching {

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
    
    public static void main(String[] args) {
        String [] words={"the", "a","there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);   
        }  

        System.out.println("----------------------");
        System.out.println(search("any"));
        System.out.println(search("thor"));
    }
}

    

