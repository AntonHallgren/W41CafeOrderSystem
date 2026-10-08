public class Cafe
{
    private final Menu menu = new Menu();
    private Order currentOrder;

    public void process()
    {
        greetCustomer();
        menu.print();
        currentOrder.takeOrder(menu.size());
        currentOrder.printReceipt();
    }

    private void greetCustomer() {
        String customerName = Input.readString("Welcome! What is your name? ");
        IO.println("Hi " + customerName + "! Here is our menu:");
        currentOrder = new Order(customerName);
    }
}
