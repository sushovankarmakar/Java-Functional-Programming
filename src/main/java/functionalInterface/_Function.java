package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function takes 1 argument and produces 1 result.
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> incrementByOneThenMultiplyByTen =
                incrementByOneFunction.andThen(multiplyByTenFunction);
        System.out.println(incrementByOneThenMultiplyByTen.apply(4));

        // BiFunction takes 2 arguments and produces 1 result.
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    // Function<T,R> represents a function that accepts one argument and produces a result.

    static Function<Integer, Integer> incrementByOneFunction =
            number -> ++number;

    static Function<Integer, Integer> multiplyByTenFunction =
            number -> number*10;

    static int incrementByOne (int number) {
        return ++number;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply (int number, int numToMultiplyBy) {
        return (++number) * numToMultiplyBy;
    }
}
