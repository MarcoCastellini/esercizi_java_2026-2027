import Parola;

package ListaDoppiaLinkata;
public class Parola implements Comparable<Parola> {
    private String testo;
    private int contatore;
    
    // Puntatori della lista doppiamente linkata
    public Parola prev;
    public Parola next;

    public Parola(String testo) {
        this.testo = testo;
        this.contatore = 1;
        this.prev = null;
        this.next = null;
    }

    public String getTesto() {
        return testo;
    }

    public int getContatore() {
        return contatore;
    }

    public void incrementa() {
        this.contatore++;
    }

    @Override
    public int compareTo(Parola altra) {
        return this.testo.compareTo(altra.testo);
    }

    @Override
    public String toString() {
        return testo + " (" + contatore + ")";
    }
}
