package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    //Supplier<T> represents a supplier of results.

    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionURLSupplier.get());
    }

    static String getDBConnectionURL() {
        return "jdbc://localhost:4342/users";
    }

    static Supplier<List<String>> getDBConnectionURLSupplier =
            () -> List.of("jdbc://localhost:4342/users", "jdbc://localhost:4342/customer");
}
