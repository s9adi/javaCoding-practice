package programming;

public class StreamAPIs {

    public static void main(String[] args) {

//        // Print ten random numbers using foreach
//        Random random = new Random();
//        IntStream.rangeClosed(0,10).boxed().map(x -> x*random.nextInt(10)).forEach(System.out::println);
//        Random random = new Random();
//        Stream.generate(random::nextInt).limit(10).forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        double average = numbers
//                .stream()
//                .filter(n -> n % 2 == 0)    // Filter even numbers
//                .mapToDouble(n -> n * 2.0)  // Map to doubles and multiply by 2
//                .average()                  // Calculate the average
//                .orElse(0);

//        Stream.Builder<Integer> builder = Stream.builder();
//        builder.add(1);
//        builder.add(2);
//        builder.add(3);
//        Stream<Integer> stream = builder.build();


//        List<String> names = Arrays.asList("John", "Alice", "Bob", "Jane");
//        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.toList()));
//        Map<Integer, Long> collect1 = names.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.counting()));
//        System.out.println(collect);
//        System.out.println(collect1);


//        // handling null values in the java Streams
//        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
//        List<String> filteredList = list.stream()
//                .map(s -> {
//                    if (s == null) {
//                        return "N/A";
//                    }
//                    // Perform other operations
//                    return s.toUpperCase();
//                })
//                .collect(Collectors.toList());
//        System.out.println(filteredList);

//        String str1 = "abcdABCDabcd";
//        //{a=2, A=1, b=2, B=1, c=2, C=1, d=2, D=1}
//      str1.chars().mapToObj(ch -> Character.valueOf((char) ch)).collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));




    }
}
