package Misc.JavaNewFeatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CopyOfApiRunner {

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) throws IOException {

//        List<String> strings = List.of("Aditya", "Sharma");
//        System.out.println(strings);
//        System.out.println(strings);


//        Path path = Paths.get("./resources/sample.txt");
//        String readString = Files.readString(path);
//
//        System.out.println(readString);

//        List<Integer> nums = List.of(1, 2, 4, 69, 89, 29, 5, 12);
//        Predicate<Integer> predicateEven = num -> num % 2 == 0;
//        boolean test = predicateEven.test(45);
//        System.out.println(test);
//
//        nums.stream().filter(predicateEven).forEach(System.out::println);
//
//        System.out.println("--------------------------------------------------------------");
//
//        nums.stream().filter(Predicate.not(CopyOfApiRunner::isEven)).forEach(System.out::println);

           String string = "Java is great Language";
//        Stream<String> lines = string.lines();

//        Integer transform = string.transform(x -> x.length());
//        System.out.println(transform);

    }
}
