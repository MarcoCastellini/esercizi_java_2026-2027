import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        try {
            // Crea un riferimento al file da leggere.
            File file = new File("file.txt");
            File output = new File("output.txt");
            // Apre il file per poterlo leggere con Scanner.
            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter(output);
            String riga;
            String[] parole;
            // Legge e stampa ogni riga fino alla fine del file.
            while (scanner.hasNextLine()) {
                riga = scanner.nextLine();
                parole = riga.split("[ ;.,:?!']");
                for (int i = 0; i < parole.length; i++) {
                    if (parole[i] != "") {
                        writer.println(parole[i]);
                    }
                }
            }
            // Chiude lo Scanner e libera la risorsa associata al file.
            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            // Mostra un messaggio se il file non esiste o non è accessibile.
            System.out.println(e.getMessage());
        }
    }
}