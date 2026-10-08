public class LineItem
{
    private int quantity = 0;
    private final MenuItem item;

    public LineItem(MenuItem item, int quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity)
    {
        this.quantity += quantity;
    }

    public double cost()
    {
        return quantity * item.getCost();
    }

    public MenuItem getItem()
    {
        return item;
    }
}
