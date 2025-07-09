import java.util.Arrays;

class Item {
    int value, weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {

    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                // Take whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take fractional part
                totalValue += item.ratio * remainingCapacity;
                break;  // Knapsack full now
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}
