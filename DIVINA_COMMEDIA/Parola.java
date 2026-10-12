public class Parola implements Comparable<Parola> {

    private String testo;
    private int contatore = 1;

    public Parola(String testo, int contatore){
        this.testo = testo;
        this.contatore = contatore;
    }

    public Parola(String testo){
        this(testo, 1);
    }

    public void incrementa() {
        this.contatore++;
    }

    public String getTesto(){
        return testo;
    }

    @Override 
    public String toString(){
        return this.testo + ": " + this.contatore;
    }

    @Override
    public int compareTo(Parola o) {
        return o.contatore - this.contatore;
    }

}