public class LineItem
{
    private int quantity;
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

    public void printInfo()
    {
        IO.println("\t" + item.getName() + "\tx" + quantity + "\t" + Cafe.asSEK(cost()));
    }

}
