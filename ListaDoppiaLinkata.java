public class ListaDoppiaLinkata {
    private Parola head;
    private Parola tail;

    public ListaDoppiaLinkata() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Cerca se la parola è già presente nella lista.
     * Restituisce l'oggetto Parola se trovato, altrimenti null.
     */
    public Parola cerca(String testo) {
        Parola corrente = head;
        while (corrente != null) {
            if (corrente.getTesto().equals(testo)) {
                return corrente;
            }
            corrente = corrente.next;
        }
        return null;
    }

    /**
     * Inserisce un nuovo oggetto Parola direttamente in ORDINE ALFABETICO.
     */
    public void inserisciInOrdine(Parola nuova) {
        // Caso A: Lista vuota
        if (head == null) {
            head = nuova;
            tail = nuova;
            return;
        }

        // Caso B: Inserimento prima di head (precede alfabeticamente la testa)
        if (nuova.compareTo(head) < 0) {
            nuova.next = head;
            head.prev = nuova;
            head = nuova;
            return;
        }

        // Caso C: Inserimento in mezzo o in coda
        Parola corrente = head;
        while (corrente.next != null && corrente.next.compareTo(nuova) < 0) {
            corrente = corrente.next;
        }

        nuova.next = corrente.next;
        nuova.prev = corrente;

        if (corrente.next != null) {
            corrente.next.prev = nuova;
        } else {
            tail = nuova; // Diventa l'ultimo elemento della lista
        }

        corrente.next = nuova;
    }

    /**
     * Stampa in ordine alfabetico le parole che compaiono almeno 'tot' volte.
     */
    public void stampaFiltrata(int tot) {
        Parola corrente = head;
        System.out.println("--- Parole presenti almeno " + tot + " volte (in ordine alfabetico) ---");
        while (corrente != null) {
            if (corrente.getContatore() >= tot) {
                System.out.println(corrente);
            }
            corrente = corrente.next;
        }
    }
}

