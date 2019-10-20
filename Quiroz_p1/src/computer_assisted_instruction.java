import java.security.SecureRandom;
import java.util.Scanner;

public class computer_assisted_instruction {

    public static int arithmeticType() {

        System.out.println("Select a type or arithmetic: (1 = addition, 2 = multiplication, 3 = subtraction, 4 = division, 5 = mix) ");

        Scanner scan = new Scanner(System.in);
        int arithmetic = scan.nextInt();

        return arithmetic;
    }

    public static int difficultyLevel() {

        System.out.println("Select a difficulty level: (1 = 1 digit, 2 = 2 digits, 3 = 3 digits, 4 = 4 digits) ");

        Scanner scan = new Scanner(System.in);
        int level = scan.nextInt();

        int bound = 0;

        if (level == 1) {
            bound = 10;
        }
        else if (level == 2) {
            bound = 100;
        }
        else if (level == 3) {
            bound = 1000;
        }
        else if (level == 4) {
            bound = 10000;
        }

        return bound;
    }

    public static void response(boolean positiveResponse) {

        SecureRandom rand = new SecureRandom();

        int randResponse = rand.nextInt(4) + 1;

        if(positiveResponse) {
            switch (randResponse) {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        } else {
            switch (randResponse) {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don’t give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }

    }

    public static void newQuestion(int bound, int type) {

        double rightAnswer = 0.0;
        int numRightAns = 0;
        int numWrongAns = 0;
        int num1 = 0, num2 = 0;
        double total;
        double userAns = 0.0;
        boolean mixType = false;

        SecureRandom rand = new SecureRandom();

        Scanner scan = new Scanner(System.in);

        // Asking 10 questions per session using random numbers
        for (int i = 0; i < 10; i++) {
            num1 = rand.nextInt(bound);
            num2 = rand.nextInt(bound);

            if (type == 1) {
                System.out.println("How much is " + num1 + " + " + num2 + "?");
                rightAnswer = (double) num1 + num2;
                userAns = scan.nextDouble();
                if (mixType){
                    type++;
                }
            } else if (type == 2){
                System.out.println("How much is " + num1 + " * " + num2 + "?");
                rightAnswer = (double) num1 * num2;
                userAns = scan.nextDouble();
                if (mixType){
                    type++;
                }
            } else if (type == 3){
                System.out.println("How much is " + num1 + " - " + num2 + "?");
                rightAnswer = (double) num1 - num2;
                userAns = scan.nextDouble();
                if (mixType){
                    type++;
                }
            } else if (type == 4){
                if (num2 == 0) {
                    num2 = 1;
                }
                System.out.println("How much is " + num1 + " / " + num2 + "? (two decimals)");
                rightAnswer = (double) num1 / num2;
                userAns = scan.nextDouble();
                if (mixType){
                    type = 1;
                }
            } else {
                System.out.println("How much is " + num1 + " * " + num2 + "?");
                rightAnswer = (double) num1 * num2;
                userAns = scan.nextDouble();
                mixType = true;
                type = rand.nextInt(4) + 1;
            }

            if (Math.abs(userAns - rightAnswer) < 0.01) {
                response(true);
                numRightAns++;
            } else {
                response(false);
                numWrongAns++;
            }
        }

        // Getting results
        System.out.println("Number of correct answers: " + numRightAns);
        System.out.println("Number of incorrect answers: " + numWrongAns);

        total = ((double)numRightAns / 10) * 100;

        if (total < 75) {
            System.out.println("Please ask your teacher for extra help.");
        }
        else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }

    }

    public static void main (String args[]) {

        Scanner scan = new Scanner(System.in);

        boolean newSession = true;

        while (newSession) {

            int level = difficultyLevel();

            int arithmetic = arithmeticType();

            newQuestion(level, arithmetic);


            System.out.println("Do you wish to begin a new session? (y/n)");
            char newSessionYN = scan.next().charAt(0);

            if (newSessionYN == 'y') {
                newSession = true;
            } else if (newSessionYN == 'n') {
                newSession = false;
            }

        }

    }

}
