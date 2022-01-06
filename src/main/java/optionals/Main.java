package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(null)
                .orElseGet(() -> "default value"));
        System.out.println(Optional.of("Hello")
                .orElseGet(() -> "default value"));
        try {
            System.out.println(Optional.ofNullable(null)
                    .orElseThrow(() -> new IllegalStateException("exception")));
        } finally {
            Optional.of("Jitesh")
                    .ifPresent(email -> System.out.println("Sending email to " + email.toLowerCase().concat("shaw93@gmail.com")));
            Optional.ofNullable(null)
                    .ifPresentOrElse(email -> System.out.println("Sending email to " + email.toString().toLowerCase().concat("@gmail.com")),
                            () -> System.out.println("Cannot send email. Invalid email-id"));
        }
    }
}
