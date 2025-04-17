package Misc.BreakingSingletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonBreaker {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // using Reflection
        SingletonClassImpl singleton = SingletonClassImpl.getSingleInstance();

        Constructor<SingletonClassImpl> constructor = SingletonClassImpl.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonClassImpl singleton2 = constructor.newInstance();

        System.out.println(singleton2 == singleton);

        // using Cloning , .clone() method allows you to create a clone of the object
        // only works if your class is implementing cloneable interface

        // Java Serialization
        // if you implment serializable the objects of the class can be deconstructed and constructed
        // again
    }
}
