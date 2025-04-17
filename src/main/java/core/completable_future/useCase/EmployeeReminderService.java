package core.completable_future.useCase;

public class EmployeeReminderService {

//    public CompletableFuture<Void> SendReminderToEmployees() {
//
//
//        // these all then apply are threads , separate threads clubbed
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                    System.out.println("Fetching Employees" + Thread.currentThread().getName());
//                    List<Employee> employees = EmployeeDatabase.fetchEmployees();
//                    return employees;
//
//                }).thenApply((employees) -> {
//                    System.out.println("Filter the new Joinees " + Thread.currentThread().getName());
//                    return employees.stream().filter(emp -> emp.getNewJoiner().equals("TRUE"))
//                            .collect(Collectors.toList());
//                })
//                // the list that i got i want to pass to the new employees
//                .thenApply((employees) -> {
//                    System.out.println("filter training not complete ");
//                    return employees
//                            .stream().filter(emp -> emp.getLearningPending().equals("TRUE"))
//                            .collect(Collectors.toList());
//
//                }).thenApply((emp) -> {
//                    System.out.println("get Email " + Thread.currentThread().getName());
//
//                    return emp.stream().map(empl -> empl.getEmail()).collect(Collectors.toList());
//                })
//
//                .thenAccept((emails) -> {
//
//                    System.out.println("send Emails ");
//                    emails.forEach(email -> sendEmail(email));
//                });
//
//        return voidCompletableFuture;
//    }
//
//    public static void sendEmail(String email) {
//        System.out.println("Sending the training reminder email to the mail ids" + email);
//
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        EmployeeReminderService service = new EmployeeReminderService();
//
//        service.SendReminderToEmployees().get();
//    }
}
