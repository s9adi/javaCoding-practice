package Misc.Annotataions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Check {

    // check for the class level annotation
    public void checkIfSerializable(Object object) {
        if (object == null) {
            throw new RuntimeException("The Object is not Serializable");
        }
        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new RuntimeException("The Object cannot be serialized as annotation is not present");
        }
    }
    // check for the method level , or just initialize
    public void initliseObjects(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()){
            if (method.isAnnotationPresent(Init.class)){
                method.setAccessible(true); // this allows us to execute the method that is private
                method.invoke(object); // invoke the method on the Object
            }
        }
    }

    // after initialization, we iterate over out objects fields
    // retrieve the key and value of the Json objects and put them in a map
    // then we create JSON string from the map
//    private String getJsonString(Object object) throws Exception {
//        Class<?> clazz = object.getClass();
//        Map<String, String> jsonElementsMap = new HashMap<>();
//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            if (field.isAnnotationPresent(JsonElement.class)) {
//                jsonElementsMap.put(String.valueOf(getKey(field)), (String) field.get(object));
//            }
//        }
//
//        String jsonString = jsonElementsMap.entrySet()
//                .stream()
//                .map(entry -> "\"" + entry.getKey() + "\":\""
//                        + entry.getValue() + "\"")
//                .collect(Collectors.joining(","));
//        return "{" + jsonString + "}";
//    }

}
