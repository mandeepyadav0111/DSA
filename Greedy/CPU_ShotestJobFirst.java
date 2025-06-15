import java.util.*;
public class CPU_ShotestJobFirst {
public static class job{
    int id;
    int bursttime;
    job(int id, int bursttime){
         this.id=id;
         this.bursttime=bursttime;
    }
}

public static void main(String[] args) {
    job[] jobs={
        new job(1,6),
        new job(2,8),
        new job(3,7),
        new job(4,3)
    };
     
    Arrays.sort(jobs,(a,b)->a.bursttime);
    int totalwaitingtime=0;
    int currenttime=0;
    System.out.println("-------------------------------------");
   System.out.println("ID "+"BurstTime  "+ "Waiting Time");
    for(job job:jobs){
        int waitingtime=currenttime;
        System.out.println(job.id+"       " +job.bursttime+"         "+ waitingtime);
        totalwaitingtime +=waitingtime;
        currenttime +=job.bursttime;
    }
    
    double avgwaitingtime=totalwaitingtime/jobs.length;
    System.out.println("Average wating time:"+ avgwaitingtime);
}
    
}
