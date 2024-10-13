package chapter10;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculator {

    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurcharge;

    public TaxCalculator withTaxRegional() {
        useRegional = true;
        return this;
    }

    public TaxCalculator withTaxGeneral() {
        useGeneral = true;
        return this;
    }

    public TaxCalculator withTaxSurcharge() {
        useSurcharge = true;
        return this;
    }

    public static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
        double value = order.getValue();
        if (useRegional) {
            value = Tax.regional(value);
        }
        if (useGeneral) {
            value = Tax.general(value);
        }
        if (useSurcharge) {
            value = Tax.surcharge(value);
        }
        return value;
    }

    public double calculate(Order order) {
        return calculate(order, useRegional, useGeneral, useSurcharge);
    }

    //래팩토링
    DoubleUnaryOperator taxFunction = d -> d;

    public TaxCalculator with(DoubleUnaryOperator taxFunction) {
        taxFunction = taxFunction.andThen(taxFunction);
        return this;
    }

    public double calculateRefactor(Order order) {
        return taxFunction.applyAsDouble(order.getValue());
    }
}
