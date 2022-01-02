package AI;
import InputProcessor.InputProcessor;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AI {
    public static String make_random_move(String[] table) throws InterruptedException {
        System.out.println("AI easy is thinking...");
        TimeUnit.SECONDS.sleep(1);
        int random_int = new Random().nextInt(9)+1;
        while (InputProcessor.check_if_field_choice_is_taken(table, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(9)+1;
        }
        return Integer.toString(random_int);
    }
    public static String make_smart_ai_move(String[] table) throws InterruptedException {
        //this fct will use a lot of if statements to recognize game situations and react to them.
        //if no if statement is triggered, it will move randomly.
        System.out.println("AI hard is thinking...");
        TimeUnit.SECONDS.sleep(1);

        if (check_if_midle_field_is_free(table)) {
            return Integer.toString(5);
        }
        int random_int = new Random().nextInt(9)+1;
        while (InputProcessor.check_if_field_choice_is_taken(table, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(9)+1;
        }
        return Integer.toString(random_int);
    }

    private static boolean check_if_midle_field_is_free(String[] table) {
        if ((table[4] == "X") | (table[4] == "@")) {
            return false;
        }
        return true;
    }

}