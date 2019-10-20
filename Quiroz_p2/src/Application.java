import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Application {

    @Test
    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        double saver1Balance = 0.00;
        double saver2Balance = 0.00;

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);

        saver1.modifyInterestRate(4);
        saver2.modifyInterestRate(4);

        for (int i = 0; i < 12; i++) {
            saver1Balance = saver1.calculateMonthlyInterest();
            saver2Balance = saver2.calculateMonthlyInterest();
        }

        System.out.printf("%s%.2f%n", "Saver1's new balance after 12 months is $", saver1Balance);
        System.out.printf("%s%.2f%n", "Saver2's new balance after 12 months is $", saver2Balance);

        saver1.modifyInterestRate(5);
        saver2.modifyInterestRate(5);

        saver1Balance = saver1.calculateMonthlyInterest();
        saver2Balance = saver2.calculateMonthlyInterest();

        System.out.println();
        System.out.printf("%s%.2f%n", "Saver1's new balance after one more month is $", saver1Balance);
        System.out.printf("%s%.2f%n", "Saver2's new balance after one more month is $", saver2Balance);

    }
}