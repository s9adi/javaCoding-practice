package programming.coding.InterviewQuestions.EPAM;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class MaxLenSubstring {
    public static void main(String[] args) {

    }

    private static String Solution(String string) {
        // abcabcdababa
        int maxlen = Integer.MIN_VALUE;
        int left = 0;
        int right;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < string.length(); right++) {
            char c = string.charAt(right);

            if (map.containsKey(c)) {
                // we have our long substring

                left = Math.max(map.get(c) + 1, left);
            }

            map.put(c, right);

            if (right - left + 1 > maxlen) {
                maxlen = right - left + 1;
                start = left;


            }


        }
        return string.substring(start, start + maxlen);
    }
}
