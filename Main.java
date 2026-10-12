import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("testo.txt");
            File output = new File("output.txt");

            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter(output);
            String riga;
            String[] parole;
            String testoParola;

            // Uso della lista doppiamente linkata custom
            ListaDoppiaLinkata lista = new ListaDoppiaLinkata();

            while (scanner.hasNextLine()) {
                riga = scanner.nextLine();
                parole = riga.split("[ ;.,:?!']");
                for (int i = 0; i < parole.length; i++) {
                    testoParola = parole[i].toLowerCase().trim();
                    if (!testoParola.equals("") && testoParola.length() > 3) {
                        writer.println(testoParola);

                        // Cerca se la Parola (nodo) esiste già
                        Parola parolaInLista = lista.cerca(testoParola);

                        if (parolaInLista != null) {
                            parolaInLista.incrementa();
                        } else {
                            // Se non esiste, crea il nodo Parola e inseriscilo in ordine
                            lista.inserisciInOrdine(new Parola(testoParola));
                        }
                    }
                }
            }

            // Stampa le parole che compaiono almeno 'tot' volte (es. tot = 2)
            int tot = 2;
            lista.stampaFiltrata(tot);

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

