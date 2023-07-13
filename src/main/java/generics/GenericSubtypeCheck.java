package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericSubtypeCheck {
    public static void main(String[] args) {
//        isIntegerArraySubtypeOfNumberArray();
        isNumberArrayHoldingAllNumbers();
    }

    private static void isIntegerArraySubtypeOfNumberArray() {
        // Checking if Integer[] is a subtype of Number[]
        Integer[] ints = new Integer[] {1,2,3};
        Number[] nums = ints; // Q.E.D Integer[] is subtype of Number[]
        nums[0] = 3.14; // But just because it is a subtype , doesn't mean a Double ( another subtype of Number ) can be added to Integer[]
        System.out.println(nums);
        System.out.println(ints);
    }
    private static void isNumberArrayHoldingAllNumbers() {
        // Checking if Integer[] is a subtype of Number[]
        Number[] numbs = new Number[] {1,2,3.14};
        numbs[1] = 2.1;
        System.out.println(numbs);
    }

    private static void isListIntegerSubtypeOfListNumber() {
        List<Integer> ints = new ArrayList<>();
        List<Number> nums = new ArrayList<>();
//        nums = ints;
        // Compile time error :: List of Integers can not be assigned to List of Numbers, as former is not a subtype of the latter
    }
    /*
    private static void isListIntegerSubtypeOfListNumber() {
        List<Integer> ints = new ArrayList<>();
        List<Number> nums = new ArrayList<>();
//        nums = ints;
        // Compile time error :: List of Integers can not be assigned to List of Numbers, as former is not a subtype of the latter
    }
    */
    private static void isListIntegerSubtypeOfListWildCardNumber() {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> wildNums = new ArrayList<>();
        wildNums = ints;
        // List of Integers CAN be assigned to List of Numbers, as now the former is subtype of the latter

        // But adding any type of value to wildNums is not possible, because it doesn't know the exact type
            // with ? extends Genric collections , we can only get elements out of the collection, not put anything
//        wildNums.add(23);
//        wildNums.add(3.14);
//        wildNums.add(new Integer(23));

    }
}
