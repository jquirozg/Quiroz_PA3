public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate / 100;
    }

    public void setSavingsBalance(double setBalance) {
        this.savingsBalance = setBalance;
    }

    public double calculateMonthlyInterest() {
        savingsBalance = savingsBalance + (savingsBalance * (annualInterestRate / 12));
        return  savingsBalance;
    }
}
