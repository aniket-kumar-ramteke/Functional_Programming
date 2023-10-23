package optional;

import java.util.Optional;

public class _Optional2 {
    public static void main(String[] args) {
        Person person = new Person("Aniket","aniket19o96kumar@gmail.com");
        printDetails(person);

        //if user dont wanted to provide email.
        Person person1 = new Person("Ashutosh",null);
        printDetails(person1);
    }

    static void printDetails(Person person){
        System.out.println("Name: " + person.getName());
        person.getEmail()
                .ifPresentOrElse(
                        (email)-> System.out.println("Email: " + email),
                        ()-> System.out.println("Email: Email not provided!")
                );
    }
}

class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
