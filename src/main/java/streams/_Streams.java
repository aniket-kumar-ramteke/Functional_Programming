package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static streams._Streams.Gender.*;

public class _Streams {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John",MALE),
                new Person("Maria",FEMALE),
                new Person("Aisha",FEMALE),
                new Person("Alex",MALE),
                new Person("Alice",FEMALE)
        );

        //1. Retrive all genders
        List<Gender> genderList = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toList()); // .toList() will give you gender of each person and can contains duplicates.

//        System.out.println(genderList);

        Set<Gender> genderList2 = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet()); // .toSet() will give you list gender of person without duplicates.

//        System.out.println(genderList2);

        //2.Same using Consumer Method Refrence
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //3.List of person name
        System.out.println("//3.List of person name");
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //4.List of person name's lenght
        System.out.println("//4.List of person name's lenght");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        //5.Unique list of name's lenght
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .boxed()  // Convert the IntStream back to a Stream<Integer>
                .collect(Collectors.toSet())
                .forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name,Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE,FEMALE
    }
}
