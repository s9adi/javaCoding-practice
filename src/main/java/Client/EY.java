package Client;

public class EY {

    record Employee(int id , String name , String department){};
    public static void main(String[] args) {
        commonPrefixInStringArray();
    }

    static void commonPrefixInStringArray() {
        String[] arr = {"abc", "abd", "abcdh", "abccc"};
        String firstString = arr[0];
        for (int i = 1; i < arr.length; i++) {
            String compareString = arr[i];
            while (!compareString.startsWith(firstString)) {
                if (firstString.length() == 0) break;
                firstString = firstString.substring(0, firstString.length() - 1);
            }
        }

        System.out.println("longest Common Prefix is =====>>>>  " + firstString);
    }
}
