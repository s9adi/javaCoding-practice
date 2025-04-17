package Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<Employee> emps = UtilMethods.getEmployees();

        // Sort the emps based on the city and then name

        Map<Integer , Employee> map = new HashMap<>();
        map.put(1 , new Employee(1, "Aditya", "bangalore", 150000, "Java" , List.of(new Address("Baker Street" , 26 ) , new Address("Rohini" , 175))));
        map.put(2 ,  new Employee(2, "Nikhil", "bangalore", 200000, "C#" , List.of(new Address("Bengaluru Street" , 45))));
        map.put(3 ,  new Employee(3, "Harshit", "hyderabad", 220000, "C++" , List.of(new Address("Hydrabad Street" , 67) )));

        map.entrySet()
                .stream()
                .sorted((entry1 , entry2) -> {
                    int result = entry1.getValue().getLocation().compareTo(entry2.getValue().getLocation());
                    if (result == 1){
                        return entry1.getValue().getName().compareTo(entry2.getValue().getName());
                    }

                    return result;
                });
        // count of each employee in department



//        List<Address> aditya = emps.stream().filter(employee -> employee.getName().equals("Aditya")).flatMap(emp -> emp.getAddress().stream()).collect(Collectors.toList());
//        System.out.println(aditya);

        // write a program to convert list of employee to map in which dept should be as key and count for dept should be
//        HashMap<String, Long> collect = emps.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment(), HashMap::new, Collectors.counting()));
//        System.out.println(collect);

//        emps.stream().sorted((a, b) -> {
//            int namecomparison = a.name.compareTo(b.name);
//            return (namecomparison != 0) ? namecomparison : Integer.compare(a.id, b.id);
//        }).forEach(System.out::println);


//        List<String> stringList = Arrays.asList("Aditya", "Sharma", "is", "great");
//        Map<Integer, Long> collect = stringList.stream().collect(Collectors.toMap(String::length, v -> 1L, Long::sum));
//        System.out.println(collect);

    }
}

class UtilMethods {
    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(1, "Aditya", "bangalore", 150000, "Java" , List.of(new Address("Baker Street" , 26 ) , new Address("Rohini" , 175))),
                new Employee(2, "Nikhil", "bangalore", 200000, "C#" , List.of(new Address("Bengaluru Street" , 45))),
                new Employee(3, "Harshit", "hyderabad", 220000, "C++" , List.of(new Address("Hydrabad Street" , 67) ))
        );
    }
}



@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
class Address {
    String street;
    int houseNo;
}
