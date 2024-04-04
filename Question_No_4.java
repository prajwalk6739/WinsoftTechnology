// Q4:Write a Java Program to find the duplicate characters in a string.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "Hello Myself Prajwal Kale";
        char[] chars = str.toCharArray();

        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (char c : chars) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Character: " + entry.getKey() + " - Count: " + entry.getValue());
            }
        }
    }
}
