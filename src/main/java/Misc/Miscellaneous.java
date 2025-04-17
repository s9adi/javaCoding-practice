package Misc;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Predicate;

public class Miscellaneous {

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
//        Predicate<Integer> predicate = Predicate.not(Miscellaneous::isEven);
//        System.out.println(predicate.test(12));

        ZonedDateTime americaTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(americaTime);
    }
}
