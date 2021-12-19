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
        String  Player_1= "human";
        String Player_2 = "human";

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
// make option select for human ai usw
//fix bug that random ai takes random fields that are taken