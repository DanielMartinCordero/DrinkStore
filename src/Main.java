import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;
public class Main {
    public static int fnumber(Scanner sc){
        while (true) {
            System.out.println("How much people will buy?");
            try {
                int number = sc.nextInt();
                sc.nextLine();
                if (number >=1) {
                    return number;
                }
                else {
                    System.out.println("Please, choose a higher number of 0");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, write a valid integer number");
                sc.nextLine();
                continue;
            }
        }
    }
    public static int famount(Scanner sc, int i){
        while (true){
            System.out.println("How much drinks want to buy the buyer "+i+"? The price of each drink of 300 ml is 2,50$");
            try{
                int amount = sc.nextInt();
                sc.nextLine();
                if (amount >=1){
                    System.out.println("Perfect! "+amount+" drink/s for the "+i+" buyer");
                    return amount;
                }
                else {
                    System.out.println("Please, buy a valid amount of drinks");
                    continue;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Write a valid integer number of drinks");
                sc.nextLine();
                continue;
            }
        }
    }
    public static double fdiscount(double amount){
        if (amount >=10) {
            double price = amount * 2.50;
            double percentage = price * 0.10;
            double discount = price - percentage;
            System.out.println("The discount have been applied! From " + price + "$ to " + discount + "$!");
            System.out.println("You are paying " + discount + "$");
            return discount;
        }
        else{
            double price =  amount * 2.50;
            System.out.println("You are paying "+price+"$");
            return price;
        }
    }
    public static boolean fpay(Scanner sc){
    boolean bucle = true;
        while(bucle){
        System.out.println("Do you want to buy that? Answer with yes or no");
        String buy = sc.nextLine();
        if (buy.equalsIgnoreCase("yes")) {
            System.out.println("Thanks for your purchase! The drinks will come to your direction between 2-5 days");
            return false;
        }
        else if (buy.equalsIgnoreCase("no")) {
            while(true) {
            System.out.println("Do you want to change the amount of drinks or just pass to other buyer? Answer with change or pass");
            String cancel = sc.nextLine();
                if (cancel.equalsIgnoreCase("change")) {
                    System.out.println("Perfect, coming back to the amount selector...");
                    return true;
                } else if (cancel.equalsIgnoreCase("pass")) {
                    System.out.println("Ok, cancelling purchase...");
                    return false;
                } else {
                    System.out.println("Please, answer with change to change the amount of drinks or pass to go out without a purchase");
                    continue;
                }
            }
        }
        else {
            System.out.println("Please, answer with yes or no");
            continue;
        }
    }
        return false;
    }
    public static void fmonthlyoffer(){
        System.out.println("If the number of drinks is more than 10 for individual client, you will get a discount of 10%!");
    }
    public static boolean ffinish(Scanner sc){
        while(true) {
            System.out.println("Do you want to do another purchase? Answer with yes or no");
            String decision = sc.nextLine();
            if (decision.equalsIgnoreCase("yes")) {
                System.out.println("Coming back...");
                return true;
            } else if (decision.equalsIgnoreCase("no")) {
                System.out.println("Ok, thanks for your time!");
                return false;
            } else {
                System.out.println("Please, answer with yer or no");
                continue;
            }
        }
    }
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        boolean bucle = true;
        while (bucle) {
            System.out.println("Welcome to the EnergyBoost shop!");
            System.out.println("Our monthly offer is:");
            fmonthlyoffer();
            int number = fnumber(sc);
            for (int i = 1; i <= number; i++) {
                boolean bucle1 = true;
                while (bucle1) {
                    int amount = famount(sc, i);
                    fdiscount(amount);
                    bucle1 = fpay(sc);
                }
            }
            bucle = ffinish(sc);
        }
    }
}
