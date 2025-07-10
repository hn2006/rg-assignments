package Question_1;

public class TaxUtil {
    double rate = 0.15;

    // calculateTax() is not a pure function because it depends on the outside state (amount)
    public double calculateTax(double amount) {
        return amount * rate;
    }

    // Passing rate in the parameter makes the function as pure as the function now only depends on function parameters
    public double calculateTaxPure(double amount, double rate) {
        return amount * rate;
    }
}
