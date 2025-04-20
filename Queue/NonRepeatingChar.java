import java.util.*;
public class NonRepeatingChar {
    public static void printstream(String s){
        Queue<Character> q=new LinkedList<>();
        int frequency[]=new int [26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
             q.add(ch);
             frequency[ch-'a']++;
             if(frequency[ch-'a']>1){
                q.remove();
             }

             while(!q.isEmpty() && frequency[q.peek()-'a']>1){
                q.remove();
             }
             if(q.isEmpty()){
                System.out.print(-1+" ");
             }
             else{
                System.out.print(q.peek()+" ");
             }

        }
    }
public static void main(String [] args){
String s="aabccxb";
printstream(s);
}

}
