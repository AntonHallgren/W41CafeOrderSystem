public class Order {
    private final String customerName;

    private int itemId = 0;
    private int quantity = 0;

    private double subtotal = 0;

    private final Menu menu;

    public Order(String customer, Menu menu)
    {
        customerName = customer;
        this.menu = menu;
    }

    private void calculatePrice()
    {
        subtotal = menu.getItem(itemId).getCost() * quantity;
    }

    public void takeOrder()
    {
        itemId = Input.readInt("Enter item number (1 - " + menu.size() + "): ") - 1;
        quantity = Input.readInt("How many? ");
        //TODO do loyalty member later.

        calculatePrice();
    }

    public void printReceipt()
    {
        IO.println("Customer \t: " + customerName);
        IO.println("Item \t: " + menu.getItem(itemId).getName() + " x " + quantity);//TODO need access to item name
        IO.println("Subtotal \t: " + subtotal + " SEK");//TODO calculate cost

    }

    public String getCustomerName()
    {
        return customerName;
    }

}
