import java.util.*;

class Guess_Number{
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print("Enter Upper Range <100: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int RandNo = random.nextInt(n) + 1;
        int count = 0,score=0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Guess a number between 1 and "+n+" : ");
            int guess = sc.nextInt();
            count++;
            if (guess == RandNo) {
                System.out.println("Congratulations.!! You guessed the number in " + count + " attemts.");
                score = 100 - (count * 5);
                System.out.println("Your score is: " + score+"%");
                break;
            } else if (guess < RandNo) {
                System.out.println("Too low !! Try again..");
            } else {
                System.out.println("Too high !! Try again..");
            }
            if (count >= 5) {
                System.out.println("You reached max attemts..");
                System.err.println("Guess Number is: "+ + RandNo);
                System.out.println("Plz Try again..");
                break;
            }
        }
        System.out.println("Thank You..!!");
        scanner.close();
        sc.close();
    }
}
