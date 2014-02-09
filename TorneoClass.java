import java.util.*;

public class TorneoClass extends Vector<Squadra> 
{

	//METODI
    public boolean addSquadra(Squadra s) 
	{
        return add(s);
    }
    
    public void sortSquadre() 
	{
        Collections.sort(this);
    }
		
	//Solo per debug...
	public int sizeTorneo()
	{
		return this.size();
	}

}
