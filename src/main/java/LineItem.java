public class LineItem
{
    private int quantity = 0;
    private MenuItem item;

    public LineItem(MenuItem item, int quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity)
    {
        this.quantity += quantity;
    }

    private double cost()
    {
        return quantity * item.getCost();
    }
}
