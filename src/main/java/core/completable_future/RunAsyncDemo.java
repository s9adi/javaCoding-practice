package core.completable_future;

//import com.fasterxml.jackson.core.exc.StreamReadException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DatabindException;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class RunAsyncDemo {
//
//    public static CompletableFuture<?> saveEmployees(File jsonFile) {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Object Mapper is class that is used to serialize the java objects in json
//        // and deserialize into java objects
//
//        CompletableFuture<?> future = CompletableFuture.runAsync(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
//
//                    });
//                    // converted the j-son file to list of employee objects
//                    // write logic to save to db
//                    System.out.println("Thread " + Thread.currentThread().getName() + " is running");
//                    employees.stream().forEach(System.out::println);
//
//                } catch (StreamReadException e) {
//                    e.printStackTrace();
//                } catch (DatabindException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        return future;
//    }
//
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CompletableFuture<?> future = saveEmployees(new File("employees.json"));
//        future.get();
//    }
//

}
