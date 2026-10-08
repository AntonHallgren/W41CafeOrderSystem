public class MenuItem {
    private final String name;
    private final double cost;

    public MenuItem(String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public void print()
    {
        IO.println(name + "\t" + cost + " SEK");
    }

}
