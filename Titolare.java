public class Titolare extends Giocatore
{
	//CAMPI
	
	//COSTRUTTORE
	public Titolare(String n, String c, double h, Squadra s)
	{
		super(n, c, h, s);
	}

	//METODI
	public String toString()
	{
		return (super.toString()+" titolare");
	}
}
