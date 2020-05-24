package streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Sushovan", MALE),
                new Person("Puja", FEMALE),
                new Person("Guri", FEMALE),
                new Person("Nilu", FEMALE),
                new Person("Trinu", FEMALE),
                new Person("Pritha", FEMALE),
                new Person("Dona", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY));

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length()) // normal way
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length) // usage of method reference
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);

        boolean containsAnyFemales = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsAnyFemales);

        boolean containsNoFemales = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsNoFemales);

        Optional<Person> first = people.stream()
                .findFirst();
        System.out.println(first.get().name);

        Stream<Person> personStream =
                people.stream().dropWhile(person -> person.gender.equals(MALE));  // removes all the males
        personStream.forEach(System.out::println);

        System.out.println("----------------------------");

        Stream<Person> peek = people.stream()
                .peek(person -> System.out.println("Hi " + person.name));
        peek.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
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

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY;
    }
}
