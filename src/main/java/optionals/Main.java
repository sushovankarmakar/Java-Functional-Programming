package optionals;

import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "Default Value");
        System.out.println(value);

        Object value1 = Optional.ofNullable("Hello")
                .orElseGet(() -> "Default Value");
        System.out.println(value1);

        Object value2 = Optional.ofNullable("Throws Exception If this string is null")
                .orElseThrow(() -> new IllegalStateException("Exception"));

        Optional.ofNullable("Hello hi there")
                .ifPresent(value3 -> {
                    System.out.println(value3);
                });

        Optional.ofNullable("Hello hi there (Usage of method reference)")
                .ifPresent(System.out::println); // usage of method reference

        Optional.ofNullable("sk@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to "+ email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to "+ email),
                        () -> System.out.println("Can't send email"));
    }
}
