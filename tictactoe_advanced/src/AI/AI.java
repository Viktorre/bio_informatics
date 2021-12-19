package AI;
import InputProcessor.InputProcessor;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AI {
    public static String make_random_move(String[] table) throws InterruptedException {
        System.out.println("AI easy is thinking...");
        TimeUnit.SECONDS.sleep(1);
        int random_int = new Random().nextInt(8)+1;
        while (InputProcessor.check_if_field_choice_is_taken(table, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(8)+1;
        }
        return Integer.toString(random_int);
    }
    public static String make_smart_ai_move(String[] table) throws InterruptedException {
        System.out.println("AI hard is thinking...");
        TimeUnit.SECONDS.sleep(1);
        int random_int = new Random().nextInt(8)+1;
        while (InputProcessor.check_if_field_choice_is_taken(table, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(8)+1;
        }
        return Integer.toString(random_int+1);
    }
}