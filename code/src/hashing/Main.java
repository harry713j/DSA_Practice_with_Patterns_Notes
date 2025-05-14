package hashing;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void highestAndLowestFreqElements(int[] arr){
        Map<Integer, Integer> freq = new HashMap<>();

        for (int a: arr){

                freq.put(a, freq.getOrDefault(a, 0) + 1);

        }

        int highestApp = Integer.MIN_VALUE, lowestApp = Integer.MAX_VALUE,
                highestAppNum = Integer.MIN_VALUE, lowestAppNum = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if (entry.getValue() > highestApp){
                highestAppNum = entry.getKey();
                highestApp = entry.getValue();
            }

            if (entry.getValue() < lowestApp){
                lowestAppNum = entry.getKey();
                lowestApp = entry.getValue();
            }
        }

        System.out.println("Highest appeared number is " + highestAppNum + " appeared " + highestApp + " times");
        System.out.println("Lowest appeared number is " + lowestAppNum + " appeared " + lowestApp + " times");

    }
    public static void main(String[] args) {
        highestAndLowestFreqElements(new int[]{10,5,10,15,10,5});
    }
}
