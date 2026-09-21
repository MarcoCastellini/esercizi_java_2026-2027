import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

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
            boolean trovato = false;
            String parola;
            // dichiaro un ArrayList di parola
            ArrayList<Parola> lista = new ArrayList<>();

            // Legge e stampa ogni riga fino alla fine del file.
            while (scanner.hasNextLine()) {
                riga = scanner.nextLine();
                parole = riga.split("[ ;.,:?!']");
                for (int i = 0; i < parole.length; i++) {
                    parola = parole[i].toLowerCase().trim();
                    if (!parola.equals(" ") && parola.length() > 3) {
                        writer.println(parola);
                        // se non è presente
                        for (Parola parolaInLista : lista) {
                            trovato = false;
                            if (parola.equals(parolaInLista.getTesto())) {
                                parolaInLista.incrementa();
                                trovato = true;
                                break;
                            }
                        }
                        if (!trovato) {
                            // aggiunge in coda alla lista
                            lista.add(new Parola(parola));
                        }

                    }
                }
            }
            // Chiude lo Scanner e libera la risorsa associata al file.
            Collections.sort(lista);
            System.out.println(lista);
            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            // Mostra un messaggio se il file non esiste o non è accessibile.
            System.out.println(e.getMessage());
        }
    }
}