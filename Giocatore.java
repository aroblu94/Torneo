public abstract class Giocatore implements Comparable<Giocatore>
{
	//CAMPI
	private String nome;
	private String cognome;
	private double altezza;
	private Squadra squadra;

	//COSTRUTTORE
	public Giocatore(String n, String c, double h, Squadra s)
	{
		nome = n;
		cognome = c;
		altezza = h;
		squadra = s;
	}

	//METODI
	public String getNome()
	{
		return nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public Squadra getSquadra()
	{
		return squadra;
	}

	public double getAltezza()
	{
		return altezza;
	}

	public String toString()
	{
		return (nome+", "+cognome+", "+altezza+"m, "+squadra);
	}

	public int compareTo(Giocatore g)
	{
		if(this.altezza == g.altezza) //this ha la stessa altezza di g
		{
			if (this.cognome != g.cognome) //ergo ordine alfabetico
				return (this.cognome.compareTo(g.cognome));
			else return (this.nome.compareTo(g.nome));
		}
		else
		{
			if (this.altezza > g.altezza)
				return 1; // => this e' piu' alto di g
			else return -1; // => this e' piu' basso di g
		}
		
	}


}