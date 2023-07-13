package java5;

//import java.lang.*;

public class OverrideExample {
//    @Override  // Must Override a function from the base class
    public int returnValueInt() {
        return 1;
    }
    @Override // Override is Supported only from Java 5, and not available before Java 5
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        Class c = OverrideExample.class;

        System.out.println(c.getClassLoader());
        System.out.println(Override.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }

//    enum DAYS_OF_WEEK = { SUNDAY, MONDAY, TUESDAY};
}
