// Q3:Write a Java Program to count the number of words in a string using HashMap.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "Hello myself Prajwal Kale and i am final year engineering";
        String[] words = str.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase(); // convert to lower case
            if(word.endsWith(".") || word.endsWith(",")) {
                word = word.substring(0, word.length()-1);
            }
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Word: " + entry.getKey() + " - Count: " + entry.getValue());
        }
    }
}
