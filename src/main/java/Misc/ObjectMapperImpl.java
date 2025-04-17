package Misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ObjectMapperImpl {

    @AllArgsConstructor
    @NoArgsConstructor
    static class Person{
        int id;
        int age;
        String fName;
        String lName;
    }

    public static void main(String[] args) throws JsonProcessingException {

        Person person = new Person(100 , 28 , "Aditya" , "Sharma");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(person);
        System.out.println(jsonString);
    }
}
