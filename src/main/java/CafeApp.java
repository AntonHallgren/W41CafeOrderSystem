
public class CafeApp
{
    static String customerName = "";

    static void main()
    {
        Input.open();
        greetCustomer();
        //TODO Display menu
        //TODO let customer pick items and quantity
        //TODO ask for loyalty member
        //TODO calculate billing - discounts may apply
        //TODO print receipt
        //TODO keep organised

        Input.close();
    }

    static void greetCustomer()
    {
        customerName = Input.readString("Welcome! What is your name? ");
        IO.println("Hi " + customerName + "! Here is our menu:");
    }

}
