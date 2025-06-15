import java.util.*;
public class Longstword_AllPrefix {

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

    static  String ans="";
    public static void longestword(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null && root.children[i].endofword==true){
                char ch=(char)('a'+i); 
                temp.append(ch);
                if(ans.length()<temp.length()) {
                    ans=temp.toString();
                }

                longestword(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); //backtrack
            }
        }


    }
    public static void main(String[] args) {
        String [] words={"a", "banana","apple", "app", "appl", "apply", "ap"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);   
        } 
        
        longestword(root, new StringBuilder(""));
        System.out.println("-------------------"); 
        System.out.println(ans);
    }

}
