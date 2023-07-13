package javaExamples.topics;

import java.util.Hashtable;

public class EnvironmentInteraction {
    public static void main(String[] args) {
//        getSystemEnv();
//        getSpecificSystemEnv();
        getSystemProperty();
//        getSpecificSSystemProperty();
    }

    public static void getSystemEnvironment() {
        System.out.println(System.getenv());
    }

    public static void getSpecificSystemEnv() {
        System.out.println(System.getenv("PATH"));
    }

    public static void getSystemProperty() {
        Hashtable<Object, Object> systemPropertties = System.getProperties();
        System.getProperties().forEach((k,v) -> System.out.println(k + " ==>> " + v));
    }
    public static void getSpecificSSystemProperty() {
        System.out.println(System.getProperty("java.vm.specification.name")); // java.library.path // java.version
        // java.vendor // java.vm.specification.name     etc.
    }
}
