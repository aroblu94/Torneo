import java.util.*;
import java.io.*;

public class Torneo {

    private static boolean debug = false;

	public static void main(String[] args) throws Exception {
		Vector<Squadra> t = new Vector<Squadra>();
		File f = new File("giocatori.txt"); // Leggo da file
		Scanner s = new Scanner(f);
		String g = s.next();
		String n = "";
		String c = "";
		String sq = "";
		String ruolo = "";
		double h = 0;
		Giocatore player = null;
		Squadra squadra = null;

        Scanner line = new Scanner(f);

        while (line.hasNextLine()) {

			Scanner tokenizer = new Scanner(line.nextLine());
			tokenizer.useDelimiter(",");

               /*
                * Prova a parsare la linea letta ...
                */
            	try {
      			    n=tokenizer.next();
			    	c=tokenizer.next();
			    	h=Double.parseDouble(tokenizer.next());
			    	sq=tokenizer.next();
			    	ruolo=tokenizer.next();
                }

               /*
                * NoSuchElementEx | IllegalStateEx
                * sollevate. Stampa un log ...
                */
                catch (RuntimeException e) {
                	System.err.println(e.getMessage());
                }

               /*
                * Stampa tutto quello che sei
                * riuscito a parsare ...
                */
                finally {
                	if (debug) {
                	    StringBuilder sb = new StringBuilder();
                	    sb.append("DEBUG: nome = "+n+"\n");
                        sb.append("DEBUG: altezza = "+h+"\n");
                        sb.append("DEBUG: squadra = "+sq+"\n");
                        sb.append("DEBUG: ruolo  = "+ruolo);
                        System.out.println(sb);
                    }
                // ...
                }

			squadra = new Squadra(sq);

            if (!t.contains(squadra)) {
            	t.add(squadra);
                if(debug) {
					System.out.println("Adding "+squadra);
				}
            }

			if (ruolo.equals("T")) { //crea Titolare o Riserva
				player = new Titolare(n, c, h, squadra);
				if(debug) {
					System.out.println("DEBUG: giocatore creato = "+player);
				}
			}
			else {
				player = new Riserva(n, c, h, squadra);
				if(debug) {
					System.out.println("DEBUG: giocatore creato = "+player);
				}
			}


			t.get(t.indexOf(squadra)).add(player); //aggiunge il giocatore appena creato alla squadra


		}//END while


		//ORA STAMPO TUTTO
		//Stampo le squadre...	
		for (Squadra x : t) {
			System.out.println(x.getNomeSquadra());
			x.sort();
			for (Giocatore y : x) {
			    System.out.println(y.senzaSquadra());
			}
			System.out.println();
		}
	
		System.out.println();

		//Stampo i giocatori
		System.out.println("GIOCATORI: "); 
		for (Squadra x : t) {
			for (Giocatore y : x)
				System.out.println(y);
		}

		System.out.println();		

		//Stampo i titolari...
		System.out.println("TITOLARI: "); 
		for (Squadra x : t) {
			for (Giocatore y : x) {
			    if (y instanceof Titolare)
				System.out.println(y.senzaRuolo());
			}
		}

		System.out.println();
	
		//Stampo le riserve...
		System.out.println("RISERVE: "); 
		for (Squadra x : t) {
			for (Giocatore y : x) {
			    if (y instanceof Riserva)
				System.out.println(y.senzaRuolo());
			}
		}
		
		System.out.println();

		if(debug) {
			System.out.println("DEBUG: grandezza vettore Torneo = " + t.size());
		}
		
	}//END main
		
	
}//END class
