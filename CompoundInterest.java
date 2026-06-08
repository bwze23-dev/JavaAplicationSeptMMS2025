public class CompoundInterest {
    public static void main(String[] args) {
        double principal = 1000.0;
        int years = 10;

        // Loop through different interest rates (5% to 10%)
        for (int ratePercent = 5; ratePercent <= 10; ratePercent++) {
            double rate = ratePercent / 100.0;
            System.out.printf("%n--- Compound Interest Rate: %d%% ---%n", ratePercent);
            System.out.printf("%s%20s%n", "Year", "Amount on Deposit");

            for (int year = 1; year <= years; year++) {
                double amount = principal * Math.pow(1.0 + rate, year);
                System.out.printf("%4d%,20.2f%n", year, amount);
            }
        }
    }
}