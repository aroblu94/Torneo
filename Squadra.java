import java.util.*;
import java.io.*;

public class Squadra  implements Iterable<Giocatore>, Comparable<Squadra>
{
	//CAMPI
	private String nomeSquadra;
	private Vector<Giocatore> squadra; //Set permetterebbe di non avere i doppioni nella lista

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

	public Iterator<Giocatore> iterator() 	// <--- thanks to giuscri https://github.com/giuscri
	{
    	Iterator<Giocatore> it = new Iterator<Giocatore>() 
		{
	    	private int currentIndex = 0;
	    
	    	@Override
	    	public boolean hasNext() 
			{
	        	return (currentIndex < squadra.size() && !squadra.isEmpty());
	    	}
	    
	    	@Override
	    	public Giocatore next() 
			{
	        	return squadra.get(currentIndex++);
	    	}
	    
	    	@Override
			public void remove() 
			{
			    squadra.remove(currentIndex -1);
			}
	
	    
		};
	
		return it;
    }
	

	public void sort()
	{
		Collections.sort(squadra);
	}

	public int compareTo(Squadra s)
	{
		return this.getNomeSquadra().compareTo(s.getNomeSquadra());
	}

	public String toString()
	{
		return "SQUADRA " + nomeSquadra;		
	}

        @Override
        public boolean equals(Object o) {
            boolean out = false;

            if (o instanceof Squadra) {
                Squadra s = (Squadra)o;
                out = this.getNomeSquadra().equals(s.getNomeSquadra());
            } else {
                out = false;
            }

            return out;
        }

	public String getNomeSquadra() // solito metodo Get
	{
                return nomeSquadra.toLowerCase();
	}
}
