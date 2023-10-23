package optional;

import java.util.Optional;

public class _Optional1 {
    public static void main(String[] args) {

        //1.Present or empty
        Optional<String> string = Optional.of("Aniket");

        //They return boolean values to check the object inside Optional.
        System.out.println(string.isEmpty());
        System.out.println(string.isPresent());

        //2. orElse() method used for assigning default values
//        string = Optional.empty(); //Uncomment it to see the default value.
        System.out.println(string.orElse("Lovin"));

        //3. what if you string is nullable?
        string = Optional.ofNullable(null);
        System.out.println(string); // it will give you Optional.empty rather an null pointer exception.

        //4. orElseGet() will return one value with any logical code.
        String orElseGet = string.orElseGet(()->"The string you assigned is actually null.");
        System.out.println(orElseGet);

        //5. map() for modifications
//        string = Optional.of("Aniket Kumar"); //Uncomment to see the modifications.
        String mappedString = string
                .map(String::toUpperCase)
                .orElse("Null string");
        System.out.println(mappedString);

        //6. If-else (Conditional Statements) using Optionals
//        string = Optional.of("Present"); //Uncomment to see the modifications.
        string.ifPresentOrElse(
                System.out::println,
                ()-> System.out.println("Not Present")
        );
    }
}
