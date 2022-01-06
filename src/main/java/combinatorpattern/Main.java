package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer jitesh = new Customer(
                "Jitesh",
                "jiteshshaw93gmail.com",
                "+9-8240875834",
                LocalDate.of(1993, 12, 8));
        Customer asmita = new Customer(
                "Asmita",
                "asmitabiswas1505@gmail.com",
                "+91-9674508255",
                LocalDate.of(1995, 5, 15));

//        System.out.println(new CustomerValidatorService().isValid(jitesh));
//        System.out.println(new CustomerValidatorService().isValid(asmita));

        System.out.println("Using combinator pattern");
        ValidationResult jiteshValidity = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(jitesh);
        ValidationResult asmitaValidity = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(asmita);
        System.out.println(jiteshValidity);
        System.out.println(asmitaValidity);

        if(jiteshValidity != ValidationResult.SUCCESS)
            throw new IllegalStateException(jiteshValidity.name());
        if(asmitaValidity != ValidationResult.SUCCESS)
            throw new IllegalStateException(asmitaValidity.name());
    }
}
