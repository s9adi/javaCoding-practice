package core.Java8;


import java.util.List;

public class StreamAPIs {
    public static void main(String[] args) {

        List<String> strings = List.of("aditya", "sharma", "is", "good");



//        Optional<String> shortestString = strings.stream().collect(Collectors.minBy(Comparator.comparingInt(String::length)));
//        System.out.println(shortestString);
//        String string = strings.stream().sorted(Comparator.comparingInt(String::length)).findFirst().get();
//        System.out.println(string);
//        String usingLamda = strings.stream().sorted((a, b) -> a.length() - b.length()).findFirst().get();
//        System.out.println(usingLamda);

//        Optional<String> StringSum = strings.stream().collect(Collectors.reducing((s1, s2) -> s1 + s2));
//        System.out.println(StringSum.get());

//        Map<Integer, List<String>> collect = strings.stream()
//                .collect(Collectors.groupingBy(String::length));
//        System.out.println(collect);

//strings.stream().collect(Collectors.partitioningBy(x-> x.length() >=2 ));


//        List<String> filtered = strings.stream().collect(Collectors.filtering(s -> s.length() > 3, Collectors.toList()));
//        System.out.println(filtered);


//        List<Character> characters = strings.stream()
//                .collect(Collectors.flatMapping(s -> s.chars().mapToObj(c -> (char) c), Collectors.toList()));
//        System.out.println(characters);
//
//        List<Object> collect = strings.stream().flatMap(string -> string.chars().mapToObj(x -> (char)x))
//                .collect(Collectors.toList());
//        System.out.println(collect);

//        ConcurrentMap<Integer, Long> groupedAndCounted = strings.stream()
//                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
//
//        System.out.println(groupedAndCounted);


//        Map<Integer, List<Character>> groupedCharacters = strings.stream()
//                .collect(Collectors.groupingBy(String::length,
//                        Collectors.mapping(s -> s.charAt(0) , Collectors.toList())));
//// {2=[i], 4=[g], 6=[a, s]}
//        System.out.println(groupedCharacters);


//        TreeMap<Integer, List<String>> groupedByLength = strings.stream()
//                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
//        System.out.println(groupedByLength);
//
//                Map<Integer, Long> result = strings.stream()
//                .collect(Collectors.toMap(
//                        String::length,
//                        v -> 1L,
//                        (existingValue, newValue) -> existingValue + newValue
//                ));
//
//        System.out.println("Result :" + result);


        //Coding Question  - sort the salary in descending order of the list
// Input [[101, aa, 10000],[102, ab, 10000],[103, ac, 20000],[104, ad, 20000],[105, ae, 30000],[106, af, 30000]]
// Output {30000=[[105, ae, 30000], [106, af, 30000]], 20000=[[103, ac, 20000], [104, ad, 20000]], 10000=[[101, aa, 10000], [102, ab, 10000]]}

//        List<Employee> list = List.of(new Employee(101, "aa", 10000),
//                new Employee(102, "ab", 10000),
//                new Employee(103, "ac", 20000),
//                new Employee(104, "ad", 20000),
//                new Employee(105, "ae", 30000),
//                new Employee(106, "af", 30000));
//
//        System.out.println(list);
//
//        List<Employee> collect = list.stream().sorted((a, b) -> {
//            return Long.compare(b.getSalary(), a.getSalary());
//        }).collect(Collectors.toList());
//
//        System.out.println(collect);

//        List<String> list = new ArrayList<>();
//        list.add("java database");
//        list.add("database");
//        list.add("springboot Java");
//        list.add("database");
//        list.add("java");
//        // have to find the count of the string
//        String string = list.stream().reduce((a, b) -> a + " " + b).get();
//
//        String[] strinArray = string.split(" ");
//
//        Map<String, Long> collect = Arrays.stream(strinArray).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//
//        System.out.println(collect);


//        int[] array = {1,2,3,4,5,7,8,91,112,32,12};
//
//        Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " , "));

        //MapsOps();
//        List<Integer> stream = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
//        HashMap<Integer, Long> collect = stream.stream()
//                .collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));
//        System.out.println(collect);
//
//        collect.entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toList());
//
//
//        String sentence = "Java is the best programming language and Java is popular";
//        sentence = sentence.trim();
//        Map<Character, Long> collect1 = sentence
//                .chars()
//                .mapToObj(x -> Character.valueOf((char) x))
//                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//
//        System.out.println(collect1);

//        int i = 15623;
//        String string = String.valueOf(i);
//
//        Integer reduce = string
//                .chars()
//                .mapToObj(x -> String.valueOf((char) x))
//                .map(x -> Integer.valueOf(x))
//                .reduce(0, (a, b) -> a + b);
//
//        System.out.println(reduce);
    }
//
//    public static void ArrayOps() {
//        Integer[] nums = {50, 5, 25, 100, 66};
//
//        System.out.println(IntStream.range(0, 5).boxed()
//                .map(x -> nums[x])
//                .sorted((a,b) -> Integer.compare(b,a))
//                .limit(2)
//                .skip(1)
//                .findFirst().get());
//    }
//
//    public static void MapsOps(){
//        String [] s={"apple","mango","pineapple","guava","orange"};
//        HashMap<String, Long> collect = Arrays.stream(s)
//                .collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));
//        System.out.println(collect);
//    }

//    public static void Question2(){
//        List<Emp> list= List.of(new Emp(101, "aa", 10000),new Emp(102, "ab", 10000),
//                new Emp(103, "ac", 20000),new Emp(104, "ad", 20000),
//                new Emp(105, "ae", 30000),new Emp(106, "af", 30000));
//
//        // key is salary , value is List of Employee id
//
//        Map<Integer, List<Integer>> collect = list.stream()
//                .collect(Collectors.groupingBy(Emp::sal, Collectors.mapping(Emp::id, Collectors.toList())));
//        System.out.println(collect);
//    }
//
//    public static void Question3(){
//        List<Integer> stream = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
//        HashMap<Integer, Long> collect = stream.stream().collect(Collectors.groupingBy(stream::get, HashMap::new, Collectors.counting()));
//        System.out.println(collect);
//
//        collect.entrySet().stream().filter(x -> x.getValue() >1).collect(Collectors.toList());
//    }
}
