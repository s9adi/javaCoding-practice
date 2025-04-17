package Client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    /*
    String str = "Java is prograMming LAnaguage I S";
    3rd Unique Character

    String ips = "IP1|USA IP2|India IP3|USA IP4|UK IP5|India";
    Output# USA=[IP1, IP3], UK=[IP4], India=[IP2, IP5]

    String input1="Java is NON java I S";
			OUT PUT =NON
     */

    public static void main(String[] args) {


        String input1="Java is NON java I S";
        String[] strings = input1.split(" ");
      String first =  Arrays.stream(strings)
               .filter(Predicate.not(String::isBlank))
               .map(String::toLowerCase)
               .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
               .entrySet()
               .stream()
               .filter(ed -> ed.getValue() == 1)
               .map(ed -> ed.getKey())
               .toList()
               .getFirst()
               ;

        String s = Arrays.stream(input1.split(" "))
                .filter(ed -> ed.contains
                        (input1.charAt(input1.indexOf(first) == -1 ? input1.indexOf(first.toUpperCase()) : 0) + ""))
                .findFirst()
                .get();
        System.out.println(s);


               //.forEach(System.out::println);

        /*
        String input = "IP1|USA IP2|India IP3|USA IP4|UK IP5|India";
        String[] s = input.split(" ");

        Map<String, List<String>> collect = Arrays.stream(s).map(x -> x.split("\\|"))
                .collect(Collectors.groupingBy(arr -> arr[1],
                        Collectors.mapping(arr2 -> arr2[0], Collectors.toList())));

        System.out.println(collect);


        String str = "Java is prograMming LAnaguage I S";
        StringBuilder builder = new StringBuilder();

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == ' ')) {
                builder.append(str.charAt(i));
            }
        }

        builder.toString().chars().mapToObj(x -> Character.valueOf((char) x))
                .collect(Collectors.groupingBy(x -> x , Collectors.counting())).entrySet()
                .stream().filter(entryset -> entryset.getValue() == 1).skip(2).findFirst().get();

         */
    }
}
