package InputProcessor;

import java.util.Objects;

public class InputProcessor {

    public static String[] update_table(String[] table, String input, String sign) {
        //int field = Integer.parseInt(input);
        for (int i = 0; i < table.length; i++) {
            if (Objects.equals(table[i], input)) {
                table[i] = sign;
            }
        }
        return table;
    }

    public static boolean check_if_field_choice_is_taken(String[] table, String input) {
        int field = Integer.parseInt(input);
        if ((table[field - 1] == "X") | (table[field - 1] == "@")) {
            return true;
        }
        return false;
    }

    public static boolean check_if_game_is_won_and_notify_if_so(String[] table) {
        int[][] array_win_combos = { {0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},
                {1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6} };
        for (int i = 0; i < array_win_combos.length; ++i) {
            if ((Objects.equals(table[array_win_combos[i][0]], table[array_win_combos[i][1]])) &&
                    (Objects.equals(table[array_win_combos[i][1]], table[array_win_combos[i][2]]))) {
                //if 3 table elements in one of the win_combos are equal, execute following lines:
                if (table[array_win_combos[i][0]] == "X") {
                    System.out.println("Player 1 has won!");
                }
                if (table[array_win_combos[i][0]] == "@") {
                    System.out.println("Player 2 has won!");
                }
                return true;
            }
        }

        return false;
    }

    public static boolean check_if_game_is_a_draw_and_notify_if_so(String[] table) {
        String default_table[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < default_table.length; ++j) {
                //this double loop checks if any table element is still a default number from the start
                // and returns true if that is the case.
                if (Objects.equals(table[i], default_table[j])) {
                    return false;
                }
            }
        }
        System.out.println("Game ended in a draw!");
        return true;
    }
}