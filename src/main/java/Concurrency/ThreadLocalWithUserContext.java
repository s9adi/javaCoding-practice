package Concurrency;

public class ThreadLocalWithUserContext implements Runnable {
    private ThreadLocal<Context> threadloc = new ThreadLocal<>();
    private Integer userId;
    private UserRepos repos = new UserRepos();

    @Override
    public void run() {
        String username = repos.getUserNameForUserId(userId);
        threadloc.set(new Context(username));

        System.out.println("Thread Context for : " + userId + " is : " + threadloc.get());


    }

    ThreadLocalWithUserContext(int userId) {
        this.userId = userId;
    }


    public static void main(String[] args) {
        ThreadLocalWithUserContext firstUser
                = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser
                = new ThreadLocalWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
    }
}

class Context {
    private String userName;

    public Context(String userName) {
        this.userName = userName;
    }
}