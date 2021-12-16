package InputProcessor;

import java.util.Objects;

public class InputProcessor {

    public static String[] update_table(String[] table, String input,String sign) {
        //int field = Integer.parseInt(input);
        for (int i = 0; i < table.length; i++) {
            if (Objects.equals(table[i], input)) {
                table[i]=sign;
            }
        }
        return table;
    }

    public static boolean check_if_field_choice_is_taken(String[] table, String input) {
        return false;
    }
}
