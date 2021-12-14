//2.Schreiben Sie ein Programm, dass eine DNA einliest und in den komplementären
//Strang überträgt
// NOTE: ICH BIN KEIN BIOLOGE. Ich nehme an eine DNA ist zB ATTGCCTAAGCACCG.

import java.io.*;

public class DNAUebertraeger {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr;
        BufferedReader keyboard;
        String dna;
        isr = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr);
        System.out.print("Input DNA: ");
        dna = keyboard.readLine();
        String new_dna = "";
        for(int i = 0; i<dna.length(); i++) {
            char a = dna.charAt(i);
            if (a=='T') {
                new_dna = new_dna + 'A';
            }
            if (a=='A') {
                new_dna = new_dna + 'T';
            }
            if (a=='C') {
                new_dna = new_dna + 'G';
            }
            if (a=='G') {
                new_dna = new_dna + 'C';
            }
        }
        System.out.print(new_dna);
    }
}
