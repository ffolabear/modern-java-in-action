package chapter11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalTest {

    public static void main(String[] args) {

        //Optional.map
//        Insurance insurance = new Insurance();
//        String name = null;
//        if (insurance != null) {
//            name = insurance.getName();
//        }
//
//        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
//        Optional<String> optionalName = optionalInsurance.map(Insurance::getName);

        //flatMap
        Person person = new Person();

        //컴파일에러
//        Optional<Person> optionalPerson = Optional.of(person);
//        Optional<String> name = optionalPerson.map(Person::getCar)
//                .map(Car::getInsurance)
//                .map(Insurance::getName);

        Optional<Person> optionalPerson = Optional.of(person);
        Optional<String> name = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName);

    }

    public String getCarInsurance(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    public static Optional<Integer> stringToInt(String string) {
        try {
            return Optional.of(Integer.parseInt(string));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
