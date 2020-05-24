package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    // Predicate<T> represents a predicate (boolean-valued function) of one argument.

    public static void main(String[] args) {

        // normal java function call
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09007700"));

        // predicate call
        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09007700"));

        System.out.println("Is phone number valid and contains 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("07000030000"));
        System.out.println("Is phone number valid and contains 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("09007700"));
        System.out.println("Is phone number valid or contains 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3Predicate).test("09307700"));

        System.out.println(isBothStringEqualBiPredicate.test("Sushovan", "Sushovan"));
        System.out.println(isBothStringEqualBiPredicate.test("Sushovan", "Karmakar"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3Predicate = phoneNumber ->
            phoneNumber.contains("3");

    static BiPredicate<String, String> isBothStringEqualBiPredicate = (name1, name2) ->
            name1.equals(name2);
}
