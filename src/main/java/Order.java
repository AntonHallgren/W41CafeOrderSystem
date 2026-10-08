public class Order {
    private final String customerName;

    private int itemId = 0;
    private int quantity = 0;

    private double subtotal = 0;
    private boolean hasLoyaltyDiscount = false;
    private double discounts = 0;
    private double vat = 0;
    private double total = 0;


    private final static double loyaltyDiscount = 0.15;
    private final static double quantityDiscount = 0.10;
    private final static double vatPercentage = 0.12;




    private final Menu menu;

    public Order(String customer, Menu menu)
    {
        customerName = customer;
        this.menu = menu;
    }

    private void calculatePrice()
    {
        subtotal = menu.getItem(itemId).getCost() * quantity;
        if(hasLoyaltyDiscount)
        {
            discounts = subtotal * loyaltyDiscount;
        }
        else if(subtotal >= 150)
        {
            discounts = subtotal * quantityDiscount;
        }
        vat = (subtotal - discounts) * vatPercentage;
        total = subtotal - discounts + vat;
    }

    public void takeOrder()
    {
        itemId = Input.readInt("Enter item number (1 - " + menu.size() + "): ") - 1;
        quantity = Input.readInt("How many? ");
        String loyaltyMemberAnswer = Input.readString("Loyalty member? (yes/no): ");
        switch (loyaltyMemberAnswer.toLowerCase())
        {
            case "yes", "y" -> hasLoyaltyDiscount = true;
            case "no", "n" -> hasLoyaltyDiscount = false;
            default ->
            {
                IO.println("Interpreting invalid response as 'no'");
                hasLoyaltyDiscount = false;
            }
        }
        calculatePrice();
    }

    public void printReceipt()
    {
        IO.println("Customer \t: " + customerName);
        IO.println("Item     \t: " + menu.getItem(itemId).getName() + " x " + quantity);
        IO.println("Subtotal \t: " + Cafe.asSEK(subtotal));
        IO.println("Discount \t: -" + Cafe.asSEK(discounts));
        IO.println("VAT      \t: " + Cafe.asSEK(vat));
        IO.println("------------------------------");
        IO.println("TOTAL    \t: " + Cafe.asSEK(total));
    }

    public String getCustomerName()
    {
        return customerName;
    }

}
