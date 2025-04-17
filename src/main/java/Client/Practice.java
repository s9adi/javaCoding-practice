package Client;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

    }

    private static void TwoMaps() {

        BiPredicate<String, String> predicate = (String val1, String val2) -> {
            return val1.equals(val2);
        };

        Map<String, String> map1 = new HashMap<>();
        map1.put("Aditya", "Sharma");
        map1.put("Nikhil", "Banka");
        map1.put("Harshit", "Agg");
        map1.put("Manav", "Joon");

        Map<String, String> map2 = new HashMap<>();
        map2.put("Aditya", "Sharma");
        map2.put("Nikhil", "Banka");
        map2.put("Harshit", "Agg");
        map2.put("Manav", "Joon");

        if (map1.size() != map2.size()) {
            System.out.println("Not Equal");
            return;
        }

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                String value = map2.get(entry.getKey());
                boolean result = predicate.test(entry.getValue(), value);
                if (!result) {
                    System.out.println("Not equal");
                    return;
                }
            }
        }

        System.out.println("Equal");

    }

    private static void FirstNonRepeating(String string) {
        String oper = string.trim().toLowerCase().replaceAll("\\s+", "");
        // using Map
        Map<Character, Long> longMap = oper.chars().mapToObj(c -> Character.valueOf((char) c)).collect(Collectors.toMap(x -> x, v -> 1L, Long::sum));
        Map.Entry<Character, Long> longEntry = longMap.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get();
        System.out.println(longEntry);
    }

    private static void ValidParantheses(String string) {
        // {}{}{}, {{{ }}},}{{{}}, {}}
        // {{{}{}}{{}}
        // we create a char array simulating the stack
        char[] charArray = new char[string.length()];
        int top = -1;
        // top = -1 means that there are no elements in the array

        for (int i = 0; i < string.length(); i++) {
            char charactertoadd = string.charAt(i);
            if (charactertoadd == '{') {
                top++;
                charArray[top] = charactertoadd;
            } else {
                if (top == -1) {
                    System.out.println("Invalid String");
                    return;
                }

                charArray[top] = 0;
                top--;
            }
        }
        if (top == -1) {
            System.out.println("This is Valid ");
        } else {
            System.out.println("This is Invalid");
        }
    }

    private static void removeDuplicates() {
        int[] array = new int[]{1, 2, 4, 2, 6, 5};
        for (int i = 0; i < array.length; i++) {

        }
    }

    private static void reverseString() {
        // """"This is paragraph""""
        String string = "     This is a Aditya Sharma   ";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); ) {
            while (i < string.length() && string.charAt(i) == ' ') {
                i++;
            }
            if (i >= string.length()) {
                break;
            }
            int j = i;
            while (j < string.length() && string.charAt(j) != ' ') {
                j++;
            }
            String str = string.substring(i, j);
            if (result.length() > 0) {
                result.insert(0, " ");
            }
            result.insert(0, str);
            i = j;
        }
        System.out.println(result.toString());
    }

    private static void reverseIndividual() {
        String string = "This is Aditya Sharma   ";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            while (i < string.length() && string.charAt(i) != ' ') {
                i++;
            }
            if (i > string.length()) {
                break;
            }
            int j = i;
            while (string.charAt(j) != ' ' && i < string.length()) {
                j++;
            }
            String sample = string.substring(i , j);
            String reverseString = reverse(sample);

        }
    }

    private static String reverse(String string) {
        char[] charArray = string.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }

        String result = new String(charArray);
        return result;
    }

}
