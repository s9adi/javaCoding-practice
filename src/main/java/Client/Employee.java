package Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Data
class Employee {
    int id;
    String name;
    String location;
    int salary;
    String department;
    List<Address> address;
}
