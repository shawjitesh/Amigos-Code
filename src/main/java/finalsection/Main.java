package finalsection;

import java.util.Optional;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("Asmita", "Biswas", null);
        hello("Jitesh", null, value -> System.out.println("No last name provided for " + value));
        helloTwo("Jitu", "Shaw", null);
        helloTwo("Pawan", null, () -> System.out.println("No last name provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        Optional<String> lName = Optional.ofNullable(lastName);
        lName.ifPresentOrElse(System.out::println, () -> callback.accept(firstName));
    }

    static void helloTwo(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        Optional<String> lName = Optional.ofNullable(lastName);
        lName.ifPresentOrElse(System.out::println, callback);
    }
    // Callbacks in JavaScript
//        function hello(firstName, lastName, callback) {
//            console.log(firstName);
//            if(lastName) {
//                console.log(lastName);
//            } else {
//                callback();
//            }
//        }
}
