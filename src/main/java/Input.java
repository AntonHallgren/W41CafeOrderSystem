import java.util.Scanner;

public class Input {

    private static Scanner sc;

    public static void open()
    {
        sc = new Scanner(System.in);
    }

    public static void close()
    {
        sc.close();
    }

    public static String readString(String question)
    {
        IO.print(question);
        return sc.nextLine();
    }

    public static int readInt(String question)
    {
        IO.print(question);
        while(!sc.hasNextInt())
        {
            sc.nextLine();
            IO.print("Invalid input. Try with an integer: ");
        }
        int answer = sc.nextInt();
        sc.nextLine();
        return answer;
    }
}
