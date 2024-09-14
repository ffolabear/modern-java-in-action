package chapter9.strategy;

public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        return strategy.execute(input);
    }

    Validator numericValidator = new Validator(new IsNumeric());
    boolean b1 = numericValidator.validate("aaaa");
    Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
    boolean b2 = lowerCaseValidator.validate("bbbb");

    Validator numericValidatorLambda = new Validator((String s) -> s.matches("\\d+"));
    Validator lowerCaseValidatorLambda = new Validator((String s) -> s.matches("[a-z]"));
}

interface ValidationStrategy {

    boolean execute(String s);
}

class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}