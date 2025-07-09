import java.util.*;

class Meeting {
    int start, end;
    Meeting(int s, int e) {
        start = s;
        end = e;
    }
}

public class NMeetings {
    public static void main(String[] args) {
        Meeting[] meetings = {
            new Meeting(1, 3),
            new Meeting(2, 4),
            new Meeting(3, 5),
            new Meeting(0, 6),
            new Meeting(5, 7),
            new Meeting(8, 9),
            new Meeting(5, 9)
        };

        Arrays.sort(meetings, Comparator.comparingInt(m -> m.end));

        int count = 1;
        int lastEnd = meetings[0].end;

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i].start >= lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }

        System.out.println("Maximum meetings in one room: " + count);
    }
}


// import java.util.*;

// public class NMeetingsWithArray {
//     public static void main(String[] args) {
//         // Each row is a meeting: {start, end}
//         int[][] meetings = {
//             {1, 3},
//             {2, 4},
//             {3, 5},
//             {0, 6},
//             {5, 7},
//             {8, 9},
//             {5, 9}
//         };

//         // Sort meetings by end time (greedy strategy)
//         Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));

//         int count = 1;
//         int lastEnd = meetings[0][1];

//         for (int i = 1; i < meetings.length; i++) {
//             if (meetings[i][0] >= lastEnd) {
//                 count++;
//                 lastEnd = meetings[i][1];
//             }
//         }

//         System.out.println("Maximum meetings in one room: " + count);
//     }
// }
