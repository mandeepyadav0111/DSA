import java.util.HashMap;

public class Itinerary_Tickets {
    public static String findstart(HashMap<String, String> tickets){
        HashMap<String, String> reversemap= new HashMap<>();
        for(String k: tickets.keySet()){
            reversemap.put(tickets.get(k), k);
        }

        //this is in tickets but not in reversemap
        //means this is starting (not in destination)
        for(String start: tickets.keySet()){
            if(!reversemap.containsKey(start)){
                return start;
            }
        }
     return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

          tickets.put( "Chennai", "Bengaluru");
          tickets.put( "Mumbai",  "Delhi");
          tickets.put("Goa",  "Chennai");
          tickets.put( "Delhi", "Goa");

          System.out.println("--------------");
          String start= findstart(tickets);
          while(tickets.containsKey(start)){
            System.out.println(start +"-->>"+ tickets.get(start));
            start=tickets.get(start);
          }
    }
    
}
