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
        boolean game_not_over = true;
        String  Player= "Player";
        String Opponent = "human";

        GameEngine tictactoe = new GameEngine();
        tictactoe.print_field(table);
        while (game_not_over) {
            table = tictactoe.player_move_on_board(table,Player); //if input is q make it a draw
            //game_not_over = tictactoe.update_game_status(table,Player);
            //table = tictactoe.player_or_ai_move_on_board(table,Opponent);
            //game_not_over = tictactoe.update_game_status(table,Opponent);
        }
    }
}
