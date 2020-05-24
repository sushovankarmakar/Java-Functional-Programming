package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        System.out.println(upperCaseName.apply("Sushovan"));

        Function<String, String> upperCaseName2 = String::toUpperCase;
        System.out.println(upperCaseName2.apply("Karmakar"));

        Function<String, String> upperCaseName3 = name -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };
        System.out.println(upperCaseName3.apply("I am learning"));

        int count = 0;

        BiFunction<String, Integer, String> upperCaseNameAndAge = (name, age) -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);

            // we shouldn't write the below line cause a pure function shouldn't depends upon other state
            // except the state which are inside. A function should be always self contained.

            //System.out.println(count);   // shouldn't do, reason is above.
            //count++;     // shouldn't do, reason is above.

            return name.toUpperCase();
        };
        System.out.println(upperCaseNameAndAge.apply("I am Sushovan", 21));
    }
}
