public class Riserva extends Giocatore
{
	//CAMPI
	
	//COSTRUTTORE
	public Riserva(String n, String c, double h, Squadra s)
	{
		super(n, c, h, s);
	}

	//METODI
	public String toString()
	{
		return (super.toString()+" riserva");
	}
}
