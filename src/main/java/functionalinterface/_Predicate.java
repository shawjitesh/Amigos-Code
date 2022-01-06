package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("09674508255"));
        System.out.println(isPhoneNumberValid("0958558819"));
        System.out.println(isPhoneNumberValid("08240875834"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("09674508255"));
        System.out.println(isPhoneNumberValidPredicate.test("0958558819"));
        System.out.println(isPhoneNumberValidPredicate.test("08240875834"));

        System.out.println("Is phone number valid and contains number 3: " +
                isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("09674508255"));
        System.out.println("Is phone number valid or contains number 3: " +
                isPhoneNumberValidPredicate.or(containsNumberThreePredicate).test("08240875834"));
        System.out.println("Is phone number valid and contains number 3: " +
                isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("09830518081"));

        // BiPredicate
        System.out.println("Is phone number valid and contains given number: " +
                isPhoneNumberValidAndContainsGivenNumber.test("09674508255", "3"));
        System.out.println("Is phone number valid and contains given number: " +
                isPhoneNumberValidAndContainsGivenNumber.test("09830518081", "3"));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("09") && phoneNumber.length() == 11;

    static Predicate<String> containsNumberThreePredicate = phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, String> isPhoneNumberValidAndContainsGivenNumber = (phoneNumber, givenNumber) ->
            phoneNumber.startsWith("09") && phoneNumber.length() == 11 && phoneNumber.contains(givenNumber);

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("09") && phoneNumber.length() == 11;
    }
}
