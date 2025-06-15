import java.util.HashMap;

public class Valid_Anagram {
     static boolean isvalid(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map= new HashMap<>();
      
        for(int i=0; i<s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);   
        }
        for(int i=0; i<s2.length(); i++){
            char ch= s2.charAt(i);
            if(map.get(ch)!= null){
                if(map.get(ch)== 1){
                    map.remove(ch);
                }
                else{
                map.put(ch, map.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s1="carrace";
        String s2="racecar";
       
        System.out.println("--------------");
        System.out.println(isvalid(s1,s2));
    }
    
}
