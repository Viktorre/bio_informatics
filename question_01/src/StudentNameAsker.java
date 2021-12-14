//1.Schreiben Sie ein Programm, dass Ihren Namen, Matrikel Nr und Studiengang
//erfragt und dann wieder ausgibt.

import java.io.*;

public class StudentNameAsker {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr;
        BufferedReader keyboard;
        String name;
        String student_id;
        String studiengang;

        isr = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr);
        System.out.print("Name?");
        name = keyboard.readLine();
        System.out.print("Matrikelnummer?");
        student_id = keyboard.readLine();
        System.out.print("Studiengang?");
        studiengang = keyboard.readLine();
        System.out.print("Hi "+name+"! Deine Matrkelnr lautet "+student_id+" und du bist für "+studiengang+
                " eingeschrieben.");
    }
}
