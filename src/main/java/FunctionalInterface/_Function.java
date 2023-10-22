package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Normal Function
        int increment = incrementByOne(1);
        System.out.println(increment);

        //With Function Interface - It takes one parameter and returns one.
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        //Multiply Function
        int multiply = multiplyBy10.apply(increment);
        System.out.println(multiply);

        //Combining two Function into one
        Function<Integer,Integer> increamentByOneAndMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10);
        System.out.println(increamentByOneAndMultiplyBy10.apply(2));// 2 + 1 = 3 then 3 * 10 = (30) output

        //Bi-Function - It takes 2 input parameter and returns one.
        System.out.println(
                incrementBy1AndMultiply(4,100) // 4 + 1 = 5 then 5 * 100 = (500) output
        );// Normally

        System.out.println(
                incrementBy1AndMultiplyFunction.apply(4,100)
        );//With Bi-Function
    }

    static Function<Integer,Integer> incrementByOneFunction = x -> x + 1;
    static Function<Integer,Integer> multiplyBy10 = x -> 10 * x;
    static BiFunction<Integer,Integer,Integer> incrementBy1AndMultiplyFunction =
            (numberToIncrement,numberToMultiply) -> (numberToIncrement + 1) * numberToMultiply;
    static int incrementBy1AndMultiply(int number,int numberToMultiply){
        return (number + 1) * numberToMultiply;
    }
    static int incrementByOne(int x){
        return x + 1;
    }
}
