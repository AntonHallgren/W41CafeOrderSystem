import java.util.Scanner;

public class CafeApp
{

    static Scanner sc;
    static String customerName = "";

    static void main()
    {
        sc = new Scanner(System.in);
        greetCustomer();
        //TODO Display menu
        //TODO let customer pick items and quantity
        //TODO ask for loyalty member
        //TODO calculate billing - discounts may apply
        //TODO print receipt
        //TODO keep organised

        sc.close();
    }

    static void greetCustomer()
    {
        IO.print("Welcome! What is your name? ");
        customerName = sc.nextLine();
        IO.println("Hi " + customerName + "! Here is our menu:");
    }

}
