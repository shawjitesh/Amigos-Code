package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = name -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };
        BiFunction<String, Integer, String> lowerCaseName = (name, age) -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toLowerCase();
        };

        System.out.println(upperCaseName.apply("Asmita"));
        System.out.println(lowerCaseName.apply("Jitesh", 28));
    }
}
