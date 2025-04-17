package programming.coding.InterviewQuestions.EPAM;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        /*
        Input: board = [["A","B","C","E"],
                        ["S","F","C","S"],
                        ["A","D","E","E"]], word = "ABCCED"
         */
    }

    private static boolean Solution(char[][] chars, String word) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] == word.charAt(0) && search(chars, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] chars, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (!(chars[i][j] == word.charAt(index) || i < 0 || i >= chars.length || j < 0 || j >= chars[0].length || visited.contains(i + "," + j))) {
            return false;
        }

        // now we have to check for the right , left , top , bottom

        visited.add(i + "," + j);
        boolean found = search(chars, word, i + 1, j, index + 1) ||
                search(chars, word, i - 1, j, index + 1) ||
                search(chars, word, i, j + 1, index + 1) ||
                search(chars, word, j, j - 1, index + 1);

        visited.remove(i + "," + j);

        return found;
    }
}
