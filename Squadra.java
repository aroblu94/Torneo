import java.util.*;
import java.io.*;

public class Squadra  implements Iterable<Giocatore>
{
	//CAMPI
	private String nomeSquadra;
	private Vector<Giocatore> squadra; //Set permette di non avere i doppioni nella lista

	//COSTRUTTORE
	public Squadra(String ns)
	{
		nomeSquadra = ns;
		squadra = new Vector<Giocatore>();
	}

	//METODI
	public void add(Giocatore g)
	{
		squadra.add(g);
	}

	public Iterator<Giocatore> iterator()
	{
		return squadra.iterator();
	}

	public void sort()
	{
		Collections.sort(squadra, Comparator Giocatore.compareTo());
	}

	public String getSquadra()
	{
		String s = "SQUADRA " + nomeSquadra.toUpperCase() + ":" + "\n"; 
		s = s + squadra;
		return s;		
	}

	public String toString()
	{
		return nomeSquadra;
	}
}
