public class Cafe
{
    private static final String thickLine
            = "==============================";

    private final String name;
    private final Menu menu = new Menu();
    private Order currentOrder;

    public Cafe(String name)
    {
        this.name = name;
    }

    public void process()
    {
        greetCustomer();
        IO.println();
        printName(false);
        menu.print();
        printLine();
        IO.println();
        currentOrder.takeOrder();
        IO.println();
        printName(true);
        currentOrder.printReceipt();
        printLine();
        endInteraction();
        printLine();
    }

    private void greetCustomer() {
        String customerName = Input.readString("Welcome! What is your name? ");
        IO.println("Hi " + customerName + "! Here is our menu:");
        currentOrder = new Order(customerName, menu);
    }

    private void endInteraction()
    {
        IO.println("Thank you, " + currentOrder.getCustomerName() + "!");
        IO.println("See you next time.");
    }

    private void printLine()
    {
        IO.println(thickLine);
    }

    private void printName(boolean capitalise)
    {
        printLine();
        IO.println("\t" + (capitalise ? name.toUpperCase() : name));
        printLine();
    }

}
