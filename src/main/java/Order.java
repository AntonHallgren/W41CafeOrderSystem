public class Order {
    private final String customerName;

    private int itemId = 0;
    private int quantity = 0;

    private double subtotal = 0;
    private boolean hasLoyaltyDiscount = false;
    private double discount = 0;
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
            discount = subtotal * loyaltyDiscount;
        }
        else if(subtotal >= 150)
        {
            discount = subtotal * quantityDiscount;
        }
        vat = (subtotal - discount) * vatPercentage;
        total = subtotal - discount + vat;
    }

    public void takeOrder()
    {
        askItemId();
        askItemQuantity();
        askLoyalty();

        calculatePrice();
    }

    private void askItemId()
    {
        itemId = Input.readInt("Enter item number (1 - " + menu.size() + "): ");
        while(itemId < 1 || itemId > menu.size())
        {
            itemId = Input.readInt("Pick a value in the range 1 to " + menu.size() + ": ");
        }
        itemId -= 1;
    }

    private void askItemQuantity()
    {
        quantity = Input.readInt("How many? ");
        while(quantity <= 0)
        {
            quantity = Input.readInt("Pick a value greater than 0: ");
        }
    }

    private void askLoyalty()
    {
        String loyaltyMemberAnswer = Input.readString("Loyalty member? (yes/no): ");
        boolean validInputGiven = false;
        while(!validInputGiven)
        {
            switch (loyaltyMemberAnswer.toLowerCase())
            {
                case "yes", "y" -> {
                    hasLoyaltyDiscount = true;
                    validInputGiven = true;
                }
                case "no", "n" -> {
                    hasLoyaltyDiscount = false;
                    validInputGiven = true;
                }
                default -> loyaltyMemberAnswer = Input.readString("Answer yes or no: ");
            }
        }

    }

    public void printReceipt()
    {
        IO.println("Customer \t: " + customerName);
        IO.println("Item     \t: " + menu.getItem(itemId).getName() + " x " + quantity);
        IO.println("Subtotal \t: " + Cafe.asSEK(subtotal));
        if(discount > 0)
        {
            IO.println("Discount \t: -" + Cafe.asSEK(discount));
        }
        IO.println("VAT      \t: " + Cafe.asSEK(vat));
        IO.println("------------------------------");
        IO.println("TOTAL    \t: " + Cafe.asSEK(total));
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public double getRevenue()
    {
        return total;
    }
}
