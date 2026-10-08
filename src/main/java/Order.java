public class Order {
    private String customerName;

    private int itemId = 0;
    private int quantity = 0;

    public Order(String customer)
    {
        customerName = customer;
    }


    public void takeOrder(int maxItems)
    {
        itemId = Input.readInt("Enter item number (1 - " + maxItems + "): ");
        quantity = Input.readInt("How many? ");
        //TODO do loyalty member later.
    }

    public void printReceipt()
    {
        IO.println("Customer \t: " + customerName);
        IO.println("Item \t: " + itemId + " x " + quantity);//TODO need access to item name
        IO.println("Subtotal \t: " + 0 + " SEK");//TODO calculate cost

    }


}
