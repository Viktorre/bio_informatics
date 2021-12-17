package GameEngine;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import InputProcessor.*;
import OutputCreator.*;
import AI.*;

public class GameEngine {

    String[] list_of_correct_user_inputs= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "q"};

    public String[] player_move_on_board(String[] table, String player) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(isr);
        Boolean move_is_not_finished = true;
        String input = "empty_string";
        //input = keyboard.readLine();
        while (move_is_not_finished) {
            System.out.print(player + " ,choose a field number to fill (or q to quit): ");
            input = keyboard.readLine();
            if (!Arrays.asList(list_of_correct_user_inputs).contains(input)) {
                System.out.println('"'+input+'"'+" is not a valid input. Only 1,2,3,4,5,6,7,8,9 and q are valid.");
                continue;
            }
            if (InputProcessor.check_if_field_choice_is_taken(table, input)) {
                System.out.println("Field is already taken!");
                continue;
            }
            move_is_not_finished = false;
        }
        table = InputProcessor.update_table(table, input, "X");
        OutputCreator.print_field(table);
        return table;
    }

    // public boolean update_game_status(String[] table, String s) {
    //  if (InputProcessor.check_if_game_is_won_and_notify_if_so(table)) {
    //      game_not_over = false;
    //      break;
    //  }
    //  if (InputProcessor.check_if_game_is_a_draw_and_notify_if_so(table)) {
    //      game_not_over = false;
    //      break;
    //  }
    //}

    //   public String[] player_or_ai_move_on_board(String[] table, String opponent) {
    //  System.out.println("AI is thinking...");
    //TimeUnit.SECONDS.sleep(1);
    //  table = AI.make_random_move(table);
    //  OutputCreator.print_field(table);
    //}

    public void print_field(String[] table) {
        OutputCreator.print_field(table);
    }
}

