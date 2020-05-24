package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    // Consumer<T> represents an operation that accepts a single input argument and returns no result.

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);   // normal java function.
        greetCustomerV2(maria, false);

        greetCustomerConsumer.accept(maria);    // consumer functional interface.
        greetCustomerBiConsumer.accept(maria, false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + customer.customerPhoneNumber);
    };

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                ((showPhoneNumber) ? customer.customerPhoneNumber : "********"));
    }

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) -> {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                ((showPhoneNumber) ? customer.customerPhoneNumber : "********"));
    };

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
