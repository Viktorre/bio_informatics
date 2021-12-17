package AI;
import InputProcessor.InputProcessor;
import java.util.Random;

public class AI {
    public static String[] make_random_move(String[] table) {
        int random_int = new Random().nextInt(9)+1;
        while (InputProcessor.check_if_field_choice_is_taken(table, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(9)+1;
        }
        table[random_int-1] = "@";
        return table;
    }
}