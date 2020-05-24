package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+01234567",
                LocalDate.of(2000, 1, 1)
        );
        //System.out.println(new CustomerValidatorService().isValid(customer));

        //Using combinator pattern

        ValidationResult result = CustomerRegistrationValidator.isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);   // this the apply function of Function interface of package java.util.function;
        // until we do .apply(customer), none of the validations get run cause they are lazy.

        System.out.println(result);

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
