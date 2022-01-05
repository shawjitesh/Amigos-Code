package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer jitesh = new Customer("Jitesh", "8240875834");
        // Normal Java function
        greetCustomer(jitesh);
        // Consumer Functional Interface
        greetCustomerConsumer.accept(jitesh);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.customerName + ", thanks for registering phone number: " +
            customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number: " + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
