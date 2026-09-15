import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {
            // Crea un riferimento al file da leggere.
            File file = new File("file.txt");
            // Apre il file per poterlo leggere con Scanner.
            Scanner scanner = new Scanner(file);
            // Legge e stampa ogni riga fino alla fine del file.
            while (scanner.hasNextLine()) {
                String riga = scanner.nextLine();
                String[] parole = riga.split(" ");
                for (String parola : parole) {
                    System.out.println(parola);
                }
            }
            // Chiude lo Scanner e libera la risorsa associata al file.
            scanner.close();
        } catch (FileNotFoundException e) {
            // Mostra un messaggio se il file non esiste o non è accessibile.
            System.out.println(e.getMessage());
        }
    }
}