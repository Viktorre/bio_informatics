import java.io.*;
import java.util.Arrays;
import java.util.Objects;

import InputProcessor.*;
import OutputCreator.*;

public class Main {


    public static void main(String[] args) throws IOException {

        String table[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        InputStreamReader isr;
        BufferedReader keyboard;
        String input = "empty";
        isr = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr);
        String[] list_of_correct_user_inputs= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "q"};
        boolean run_game = true;
        OutputCreator.print_field(table);

        while (run_game) {
            System.out.print("Choose a tile number to fill (or q to quit): ");
            input = keyboard.readLine();
            if (Objects.equals(input, "q")) { //cecks if input=="q"
                System.out.println("Quitting game...");
                run_game=false;
                break;
            }
            if (!Arrays.asList(list_of_correct_user_inputs).contains(input)) {
                System.out.println('"'+input+'"'+" is not a valid input. Only 1,2,3,4,5,6,7,8,9 and q are valid.");
                continue;
            }
            if (InputProcessor.check_if_field_choice_is_taken(table,input)) {
                System.out.println("Field is already taken!");
                //hier noch für q accounten!!! sonst endlosschleife
                continue;
            }
            table = InputProcessor.update_table(table,input,"X");
            OutputCreator.print_field(table);
        }

    }
}
