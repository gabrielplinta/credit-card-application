import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double creditCardLimit;

        List<Purchases> listOfPurchases = new ArrayList<>();
        Scanner read = new Scanner(System.in);

        System.out.printf("Provide your Credit Card Limit: ");
        creditCardLimit = read.nextDouble();

        double creditCardBalance = creditCardLimit;

        int userChoice = 1;

        while(userChoice==1) {

            System.out.printf("Please select 1 to add a purchase or 0 to exit the program: ");
            userChoice = read.nextInt();
            read.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.printf("Provide the Purchase Name: ");
                    String name = read.nextLine();
                    System.out.printf("Provide the Purchase Price: ");
                    Double price = read.nextDouble();
                    read.nextLine();

                    if (price <= creditCardBalance) {
                        listOfPurchases.add(new Purchases(name, price));
                        System.out.println("Purchase Confirmed!");
                        creditCardBalance -= price;
                    } else {
                        System.out.println("No sufficient balance.");
                    }

                    System.out.println("Credit Card Balance: " + creditCardBalance);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Option.");
            }

        }

        System.out.println("You exited the program!");


        System.out.println("*************************");
        System.out.println("PURCHASES MADE: ");

        listOfPurchases.sort(Comparator.comparing(Purchases::getPrice).reversed());

        for(Purchases items: listOfPurchases) {
            System.out.println(items);
        }
        System.out.println("*************************");
        System.out.println("Final Credit Card Balance: " + creditCardBalance);

    }
}


