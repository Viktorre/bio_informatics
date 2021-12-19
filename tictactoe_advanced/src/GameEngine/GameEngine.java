package GameEngine;

import InputProcessor.InputProcessor;
import OutputCreator.OutputCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

import static AI.AI.*;


public class GameEngine {

    String[] list_of_correct_user_inputs= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "q"};

    public String[] player_move_on_board(String[] table, String game_status, String player_1, String player_2)
            throws IOException, InterruptedException {
        Boolean move_is_not_finished = true;
        String input = "empty_string";
        while (move_is_not_finished) {
            //System.out.print(game_status + " Choose a field number to fill (or q to quit): ");
            input = return_input_from_player_or_ai(table, game_status,player_1,player_2);//keyboard.readLine();
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
        if (game_status=="Player 1 moves next!") {
            table = InputProcessor.update_table(table, input, "X");
        }
        if (game_status=="Player 2 moves next!") {
            table = InputProcessor.update_table(table, input, "@");
        }
        OutputCreator.print_field(table);
        return table;
    }

    private String return_input_from_player_or_ai(String[] table, String game_status, String player_1,
                                                  String player_2) throws IOException, InterruptedException {
        String selected_player;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(isr);
        if (game_status=="Player 1 moves next!") {
            selected_player = player_1;
        }
        else {
            selected_player = player_2;
        }
        if (selected_player=="human") {
            System.out.print(game_status + " Choose a field number to fill (or q to quit): ");
            return keyboard.readLine();
        }
        else if (player_1=="AI easy") {
            return make_random_move(table);
        }
        else { //case for hard ai
            return make_smart_ai_move(table);
        }
    }

    public void print_field(String[] table) {
        OutputCreator.print_field(table);
    }

    public String choose_which_player_starts() {
        int random_int = new Random().nextInt(2);
        String who_starts_string;
        if (random_int==0) {
            who_starts_string = "Player 1 moves next!";
        }
        else {
            who_starts_string = "Player 2 moves next!";
        }
        return who_starts_string;
    }

    public String update_game_status(String[] table, String game_status) {
        //this fct checks if game is over and
      if (InputProcessor.check_if_game_is_won_and_notify_if_so(table)) {
          return "Game Over";
          }
      if (InputProcessor.check_if_game_is_a_draw_and_notify_if_so(table)) {
          return "Game Over";
          }
      if (game_status=="Player 1 moves next!") {
          return "Player 2 moves next!";
      }
      if (game_status=="Player 2 moves next!") {
          return "Player 1 moves next!";
      }
      System.out.println("### update_game_status suffered a bug");
      return "Game Over"; //this line can theoretically never be run, but needs to be there due to syntax
    }
}

