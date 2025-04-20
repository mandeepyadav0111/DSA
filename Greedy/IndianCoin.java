import java.util.ArrayList;
import java.util.List;

public class IndianCoin {
      static List<Integer> minPartition(int N){
        int [] coins={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        ArrayList<Integer> list=new ArrayList<>();
        int count =0;
        int amount = N;
        int n=coins.length;
        for(int i=n-1;i>=0;i--){
            while(coins[i]<=amount){
                amount-=coins[i];
                list.add(coins[i]);
                count++;
            }
        }
        System.out.println("NO. of coins used="+count);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(minPartition(450));
        
    }
}
