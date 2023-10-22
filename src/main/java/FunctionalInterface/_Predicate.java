package FunctionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        //Normal Function
        System.out.println("//Normal Function");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("+9100000000"));

        //Predicate as Refrence
        System.out.println("//Predicate as Refrence");
        System.out.println(
                isPhoneNumberValidPredicateRefrence
                        .test("+9100000000")
        );
        //Predicate
        System.out.println("//Predicate");
        System.out.println(
                isPhoneNumberValidPredicate.test("07")
        );
        //"Or" and "And" case
        System.out.println("//\"Or\" and \"And\" case");
        System.out.println(
                isPhoneNumberValidPredicate.and(containsNumber3).test("+9100000004")
        );
        System.out.println(
                isPhoneNumberValidPredicate.or(containsNumber3).test("9100000004")
        );
    }
    //here isPhoneNumberValidPredicate act as refrence pointing to Function.
    static Predicate<String> isPhoneNumberValidPredicateRefrence =
            _Predicate::isPhoneNumberValid;
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("+91") && phoneNumber.length() == 11;
    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("4");
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("+91") && phoneNumber.length() == 11;
    }
}
