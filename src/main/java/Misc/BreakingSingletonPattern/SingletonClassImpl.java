package Misc.BreakingSingletonPattern;

public class SingletonClassImpl {
    private static SingletonClassImpl singleInstance;

    private SingletonClassImpl() {
    }

    public static SingletonClassImpl getSingleInstance() {
        if (singleInstance == null) {
            synchronized (SingletonClassImpl.class) {
                if (singleInstance == null) {
                    singleInstance = new SingletonClassImpl();
                }
            }
        }
        return singleInstance;
    }
}

/*
The double-checking is required as the first null check only ensures that the instance is null on the check.
It can happen that some other thread has taken the lock and was creating an instance.
The second null check ensures that if the instance had already been created then we get reference to that only.
 */