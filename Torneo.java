import java.util.*;
import java.io.*;

public class Torneo 
{
	public static void main(String[] args) throws Exception
	{
		TorneoClass t = new TorneoClass();
		File f = new File("giocatori.txt"); // Leggo da file
		Scanner s = new Scanner(f);
		String g = s.next();
		String n="";
		String c="";
		String sq="";
		String ruolo="";
		double h=0;
		Giocatore player = null;
		Squadra squadra=null;
		boolean fine=false;
		boolean controllo;
		//Vector<Squadra> squadre = new Vector<Squadra>();
		while(!fine) //N.B. con un semplice do while o for "mangia" l'ultima riga del file di testo, con questo rude metodo no
		{
			Scanner tokenizer = new Scanner(g);
			tokenizer.useDelimiter(",");
			n=tokenizer.next();
			System.out.println("DEBUG: nome = "+n);
			c=tokenizer.next();
			System.out.println("DEBUG: cognome = "+c);
			h=Double.parseDouble(tokenizer.next());
			System.out.println("DEBUG: altezza = "+h);
			sq=tokenizer.next();
			System.out.println("DEBUG: squadra = "+sq);
			ruolo=tokenizer.next();
			System.out.println("DEBUG: ruolo = "+ruolo);
			squadra = new Squadra(sq); //crea Squadra
			if (ruolo.equals("T")) //crea Titolare o Riserva
			{
				player = new Titolare(n, c, h, squadra);
				System.out.println("DEBUG: giocatore creato = "+player);
				squadra.add(player);
			}
			else
			{
				player = new Riserva(n, c, h, squadra);
				System.out.println("DEBUG: giocatore creato = "+player);
				squadra.add(player);
			}
			//System.out.println("DEBUG: squadra= "+squadra.getSquadra());
			/*for(Squadra x : squadre) //controlla
			{
				if(!x.equals(squadra))
				{
					controllo=false;
				}
				else
					controllo=true;
				if(controllo=false)
					squadre.add(squadra);
			}*/
			
			t.addSquadra(squadra);

			System.out.println();

			if(!s.hasNext())
				fine=true;
			else
				g=s.next();
		}//END while

		t.sortSquadre(); 	//Stampo le squadre
		for (Squadra x : t) 
		{
			System.out.println(x.getNomeSquadra() + ":");
			x.sort();
			for (Giocatore y : x) 
			{
			    System.out.println(y);
			}
			System.out.println();
		}
	
		System.out.println();

		System.out.println("GIOCATORI: "); //Stampo i giocatori
		for (Squadra x : t)
		{
			for (Giocatore y : x)
				System.out.println(y);
		}

		System.out.println();		

		System.out.println("TITOLARI: "); //Stampo i titolari
		for (Squadra x : t) 
		{
			for (Giocatore y : x) 
			{
			    if (y instanceof Titolare)
				System.out.println(y);
			}
		}

		System.out.println();
	
		System.out.println("RISERVE: "); //Stampo le riserve
		for (Squadra x : t) 
		{
			for (Giocatore y : x) 
			{
			    if (y instanceof Riserva)
				System.out.println(y);
			}
		}
		
	}//END main
		
	
}//END class
