package javaExamples.topics.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;

public class ClassDescriptor {
    public static void main(String[] args) {
//        classDescriptors();
        printMethodsOfAClass("java.lang.Object"); // java.lang.String, //java.lang.Different
    }

    public static void classDescriptors() {
        // Class.class field examples
        System.out.println("Object class " + Object.class);
        System.out.println("String class " + String.class);
        System.out.println("String[] class " + String[].class);
        System.out.println("Calendar class " + Calendar.class);

        // instance.getClass() method examples
        System.out.println("Calendar class " + Calendar.getInstance().getClass());
        System.out.println("int class " + int.class);
    }

    public static void printMethodsOfAClass( String object ) {
        try {
            Class<?> classOb = Class.forName(object);
            Constructor<?>[] constructors = classOb.getConstructors();
            System.out.println("\n\n**** Constructors of the class **** : " + object + " ::");
            printList(constructors);
            Method[] methods = classOb.getMethods();
            System.out.println("\n\n**** Methods of the class **** : " + object + " ::");
            printList(methods);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found for the string of : " + object);
//            throw new RuntimeException(e);
        }
    }

    private static void printList(Object[] list) {
        for(Object o1 : list) {
            System.out.println(o1.toString());
        }
    }
}
