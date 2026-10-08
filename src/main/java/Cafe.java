public class Cafe
{
    private String customerName = "";
    private final Menu menu = new Menu();

    public void process()
    {
        greetCustomer();
        menu.print();
    }

    private void greetCustomer() {
        customerName = Input.readString("Welcome! What is your name? ");
        IO.println("Hi " + customerName + "! Here is our menu:");
    }
}
