package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Sushovan", MALE),
                new Person("Puja", FEMALE),
                new Person("Guri", FEMALE),
                new Person("Nilu", FEMALE),
                new Person("Trinu", MALE),
                new Person("Pritha", FEMALE),
                new Person("Dona", FEMALE));
        // Imperative Approach
        System.out.println("Imperative Approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative Approach
        System.out.println("Declarative Approach");
        //final Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        people.stream()
                .filter(person -> FEMALE.equals(person.gender))  // predicate inside the filter
                .collect(Collectors.toList())
                .forEach(System.out::println);
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
        MALE, FEMALE;
    }
}
