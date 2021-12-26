import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import GameEngine.GameEngine;
import InputProcessor.*;
import OutputCreator.*;
import AI.*;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(isr);
        String table[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String game_status; // will have 3 values: game_over, turn player 1, turn player 2
        String player_array[] = GameEngine.ask_and_return_game_settings();
        String  Player_1= player_array[0];
        String Player_2 = player_array[1];
        GameEngine tictactoe = new GameEngine();
        game_status = tictactoe.choose_which_player_starts();
        tictactoe.print_field(table);
        while (game_status != "Game Over") {
            table = tictactoe.player_move_on_board(table,game_status,Player_1,Player_2); //if input is q make it a draw
            game_status = tictactoe.update_game_status(table,game_status);
        }
    }
}
// make smart ai
//fix bug that random ai takes random fields that are taken