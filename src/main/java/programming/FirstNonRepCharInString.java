package programming;

public class FirstNonRepCharInString {

    public static void main(String[] args) {

        String string = "SYSTEM";

        method2(string);
        // output -> Y
//        Map<Character, Integer> map = new LinkedHashMap<>();
//
//        for (int i = 0; i < string.length(); i++) {
//            map.put(string.charAt(i) , map.getOrDefault(string.charAt(i) , 0) + 1);
//        }
//
//        Map.Entry<Character, Integer> characterIntegerEntry = map.entrySet()
//                .stream()
//                .filter(x -> x.getValue() == 1)
//                .findFirst()
//                .get();
//
//        System.out.println(characterIntegerEntry);

        // More Conventional Way


    }

    public static void method2(String string) {
        char ch = ' ';
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(i) != string.charAt(j)) {
                    ch = string.charAt(j);
                    System.out.println(ch);
                    return;
                }


            }
        }
    }

}
