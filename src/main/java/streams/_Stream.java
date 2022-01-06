package streams;

import java.util.List;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Jitesh", MALE),
                new Person("Asmita", FEMALE),
                new Person("Jitu", MALE),
                new Person("Sonu", FEMALE)
        );

        System.out.println("Genders:");
        people.stream()
                .map(person -> person.gender)
                .forEach(System.out::println);

        System.out.println("Names:");
        people.stream()
                .map(person -> person.name)
                .forEach(System.out::println);

        System.out.println("Lengths of all names:");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println("Is every person MALE: " +
                people.stream()
                        .allMatch(person -> MALE.equals(person.gender)));

        System.out.println("Is any person FEMALE: " +
                people.stream()
                        .anyMatch(person -> FEMALE.equals(person.gender)));

        System.out.println("Is none of the person PREFER_NOT_TO_SAY: " +
                people.stream()
                        .noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender)));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
