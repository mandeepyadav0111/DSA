// package DSA(Sh).BackTracking;

public class Subset {
    public static void subset(String str , String ans , int i ){
        if (i==str.length()){
            System.out.println(ans);
        }
        subset(str,ans+str.charAt(i),i+1);
        subset(str, ans,i+1);
    }
    public static void main(String[] args) {
        String str= "abc";
        String ans="";
        subset(str, ans, 0);
        
    }
    
}
