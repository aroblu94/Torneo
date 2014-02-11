public abstract class Giocatore implements Comparable<Giocatore>
{
	//CAMPI
	private String nome;
	private String cognome;
	private double altezza;
	private Squadra squadra;

	//COSTRUTTORE
	public Giocatore(String n, String c, double h, Squadra s) {
		nome = n;
		cognome = c;
		altezza = h;
		squadra = s;
	}

	//METODI
	
	//Get
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public double getAltezza() {
		return altezza;
	}

	//toString
	public String toString() {
		return (nome+" "+cognome+" "+altezza+"m "+squadra);
	}

	public String senzaSquadra() {
		return (nome + " " + cognome + " " + altezza + "m ");
	}

	public String senzaRuolo() {
		return (nome+" "+cognome+" "+altezza+"m "+squadra);
	}

	//compareTo
    public int compareTo(Giocatore g) {
		if (this.altezza > g.altezza) { // Confronto le altezze
	    	return 1;
		} 
		else 
			if (this.altezza < g.altezza) {
	    		return -1;
			} 
			else 	// Se hanno altezza uguale confronto il cognome
				if (this.cognome.compareTo(g.cognome) > 0) {
	    			return 1;
				} 
				else 
					if (this.cognome.compareTo(g.cognome) < 0) {
	    				return -1;
					}
				return 0;	// Se hanno anche lo stesso cognome si attaccano
    }


}
