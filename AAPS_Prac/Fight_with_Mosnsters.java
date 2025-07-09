
import java.util.*;

public class Fight_with_Mosnsters {
    public static int fwm(int [] info, int [] hm){
        int n= info[0];
        int a=info[1];
        int b= info[2];
        int k= info[3];
        int point=0;
///////////////////
         List<Integer> list = new ArrayList<>();
        for (int num : hm) {
            list.add(num);
        }
        list.sort(Comparator.comparingInt(e -> e % (a+b)));

        int i=0;
        while(i < list.size() && list.get(i)% (a+b)==0){
            i++;
       }
     
       ///////////////////
        for (int j=i; j<n; j++) {
            int health=list.get(j);
            int mod=health % (a+b);
            int p=((mod-a)/a )%2==0 ?(mod-a)/a: (mod-a)/a+1;
            if(0< mod && mod <= a){
                point++;
            }
            else if( mod > a && k >= p ){
                k=k-p;
                point++;
            }  
        }
        for (int j = 0; j < i; j++) {
            int health=list.get(j);
            int mod=health % (a+b);
            int q= (b/a) % 2==0 ?b/a :b/a+1;
            if(mod==0 && k >= q){
                k=k-q;
                point++;
            }  
            
        }
        
        return point;
    }
    

    public static void main(String[] args) {
        int [] info={6,2,3,3};
        int [] hm= {7,10,50,12,1,8};        //monsters health

        System.out.println("-----------");
        System.out.println(fwm(info, hm));
    }
    
}
