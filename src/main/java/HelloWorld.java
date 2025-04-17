import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello");

        List<Integer> stream = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        HashMap<Integer, Long> collect = stream.stream().collect(Collectors.groupingBy(stream::get, HashMap::new, Collectors.counting()));
        System.out.println(collect);

        collect.entrySet().stream().filter(x -> x.getValue() >1).collect(Collectors.toList());
    }
}
