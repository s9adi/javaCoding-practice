package programming;

public class MostRepeatedCharConsecutively {
    public static char mostRepeatedConsecutiveChar(String input) {
        char mostRepeated = '\0';
        int maxCount = 0;
        int currentCount = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostRepeated = input.charAt(i - 1);
                }
                currentCount = 1;
            }
        }

        // Check the last run of characters
        if (currentCount > maxCount) {
            maxCount = currentCount;
            mostRepeated = input.charAt(input.length() - 1);
        }

        return mostRepeated;
    }

    public static void main(String[] args) {
        String input = "abcaaaccbb";
        System.out.println("The most repeated consecutive character is: " + mostRepeatedConsecutiveChar(input));
    }
}
