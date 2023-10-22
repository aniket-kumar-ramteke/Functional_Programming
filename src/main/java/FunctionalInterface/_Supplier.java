package FunctionalInterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        //Normal Function
        System.out.println(getConnectionString());

        //Supplier
        System.out.println(getDbConnectionString.get());
    }
    static Supplier<String> getDbConnectionString = () -> "jdbc://localhost:8080/user";
    static String getConnectionString(){
        return "jdbc://localhost:8080/user";
    }
}
