// package DSA(Sh).BackTracking;

public class Permutation {
    public static void permut(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length();i++){
            char ch=str.charAt(i);
            str=str.substring(0, i)+str.substring(i+1);
            permut(str, ans+ch);
        }
    }

    public static void main(String[] args) {
        String str="abc";
        String ans="";
        permut(str, ans); 
    }
    
}
