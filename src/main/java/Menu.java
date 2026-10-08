public class Menu {
    MenuItem[] items;

    public Menu()
    {
        makeStandardMenu();
    }

    private void makeStandardMenu()
    {
        items = new MenuItem[]{
                new MenuItem("Espresso", 25.0),
                new MenuItem("Cappuccino", 35.0),
                new MenuItem("Latte", 40.0),
                new MenuItem("Croissant", 30.0),
                new MenuItem("Sandwich", 55.0)
        };
    }

    public void print()
    {
        for(int i = 0; i < items.length; i++)
        {
            IO.print((i+1) + ". ");
            items[i].print();
        }
    }

    public MenuItem getItem(int id)
    {
        return items[id];
    }

    public int size()
    {
        return items.length;
    }
}
