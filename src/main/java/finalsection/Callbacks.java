package finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("Sushovan", "Karmakar", null);
        hello("Sushovan", null, value -> {
            System.out.println(value + "'s lastName not provided");
        });
        hello2("Sushovan", null, () -> {
            System.out.println("lastName not provided");
        });
    }

    // this is the javascript style callback function in java
    // this is achieved by mixing normal function with Functional interface
    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        }
        else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        }
        else {
            callback.run();
        }
    }

    // this is the javascript style callback function
    /*function hello(firstName, lastName, callback) {
        console.log(firstName);
        if(lastName) {
            console.log(lastName);
        } else {
            callback();
        }
    }*/
}
