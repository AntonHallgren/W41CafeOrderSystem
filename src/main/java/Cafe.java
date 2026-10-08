import java.util.Locale;

public class Cafe
{
    private static final String thickLine
            = "==============================";

    private final String name;
    private final Menu menu = new Menu();
    private Order currentOrder;

    private int customersServed = 0;
    private double totalRevenue = 0;
    public boolean open = true;


    public Cafe(String name)
    {
        this.name = name;
    }

    public void process()
    {
        if(customersServed == 0)
        {
            greetCustomer();
        }
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
        customersServed++;
        totalRevenue += currentOrder.getRevenue();
        checkForNewCostomer();
    }

    private void greetCustomer() {
        String customerName = Input.readString("Welcome! What is your name? ");
        IO.println("Hi " + customerName + "! Here is our menu:");
        currentOrder = new Order(customerName, menu);
    }

    private void endInteraction()
    {
        IO.println("\tThank you, " + currentOrder.getCustomerName() + "!");
        IO.println("\tSee you next time.");
    }

    private void checkForNewCostomer()
    {
        String newName = Input.readString("Next customer name (or 'done' to close): ");
        if(newName.equalsIgnoreCase("done"))
        {
            open = false;
        }
        else
        {
            currentOrder = new Order(newName, menu);
        }
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

    public void printEndOfDayReport()
    {
        printLine();
        IO.println("\t END OF DAY REPORT");
        printLine();
        IO.println("Customers served : " + customersServed);
        IO.println(("Total revenue    : " + asSEK(totalRevenue)));
        printLine();
    }

    public static String asSEK(double amount)
    {
        return String.format(Locale.ENGLISH, "%.2f SEK", amount);
    }

}
