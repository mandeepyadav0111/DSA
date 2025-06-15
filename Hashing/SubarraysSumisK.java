import java.util.HashMap;

public class SubarraysSumisK {
    public static void main(String[] args) {
       int [] arr={10,2,-2,-20, 10};
       int k=-10;
       //(Sum, Count)
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0, 1);

        int sum=0;
        int count=0;
        for (int j = 0; j < arr.length; j++) {
            sum+= arr[j];
            if(map.containsKey(sum-k)){
               count+= map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        System.out.println("--------------");
        System.out.println("Number of subarrays with sum "+k+ "is:--->>>"+ count); 
    }
}
