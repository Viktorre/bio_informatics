package OutputCreator;

public class OutputCreator {

    public static void print_field(String[] table) {
        System.out.println("|:::::::::::::::::|");
        for (int i = 1; i < table.length; i += 3) {
            System.out.println("|  " + table[i - 1] + "  :  " + table[i] + "  :  " + table[i + 1] + "  |");
            System.out.println("|:::::::::::::::::|");
        }
    }
}
