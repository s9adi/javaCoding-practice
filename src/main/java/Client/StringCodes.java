package Client;

import java.util.ArrayList;
import java.util.List;

public class StringCodes {
    public static void main(String[] args) {
        prefixOfStringArray();
    }

    private static void PermAndComb() {
        String string = "abc";
        // O/P : abcd, cdab, bcad...
        // we fix the letter the first letter and then we are just swapping each elements
        List<String> result = new ArrayList<>();
        buildString("", string, result);
        System.out.println(result);

    }

    private static void buildString(String building, String string, List<String> strings) {
        int n = string.length();
        if (n == 0) {
            strings.add(building);
        } else {
            for (int i = 0; i < n; i++) {
                buildString(building + string.charAt(i), string.substring(0, i) + string.substring(i + 1), strings);
            }
        }
    }

    static void prefixOfStringArray() {
        String[] arr = new String[]{"ab", "abc", "abcd", "abcdd"};
        // we have to find the commonPrefix
        // we take the first String , compare it with each of the Strings in the array
        String firstString = arr[0];
        for (int i = 1; i < arr.length; i++) {
            String compareString = arr[i];
            while (!compareString.startsWith(firstString)) {
                if (firstString.length() == 0) break;
                firstString.substring(0, firstString.length() - 1);
            }
        }

        System.out.println("Prefix" + " " + firstString);
    }
}
