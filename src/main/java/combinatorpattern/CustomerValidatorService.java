package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNUmberValid(String phoneNumber) {
        return phoneNumber.startsWith("+91");
    }

    private boolean isAdult(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears() > 16;
    }
    
    public boolean isValid(Customer customer) {
        return isEmailValid(customer.getEmail()) &&
                isPhoneNUmberValid(customer.getPhoneNumber()) &&
                isAdult(customer.getDateOfBirth());
    }
}
