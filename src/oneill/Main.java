package oneill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {

	    public static void main(String[] args) throws IOException {
	    	System.out.println("");
			System.out.println("");
		  /* Opciók kiírása */
			System.out.println("Szekvenciák:");
			System.out.println(" 1. New Game");
			System.out.println(" 2. Help");
			System.out.println(" 3. Exit Game");
			System.out.println(" 4. Exit Skeleton Test");
			System.out.println("");
			
			
			int choice= 0;
			
		do {
			do {
				try {
					System.out.print("Melyik szekvenciát szeretnéd látni? ");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String s= br.readLine();
					choice= Integer.parseInt(s);
				} catch (NumberFormatException e) {
					System.out.println("Számot adj meg!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (!(choice > 0 && choice <= 4));
			
	
			Game g;
			System.out.println("");
			//System.out.println("Játék elõkészítése...");
			System.out.println("");
			
			if (choice == 1) {			// new game			
				Date d = new Date();
				g = new Game(d);	
				g.update();
				System.out.println("Calling Game.Idle()");
				g.Idle();
				
			} else if (choice == 2) {	// help screen
				help();
			}/* else if (choice == 3) {	// step on ground
				g.quit();
			} else if (choice == 4) {	// step into hole
				stepIntoHole(g);
			} else if (choice == 5) {	// step into portal
				stepIntoPortal(g);
			} else if (choice == 6) {	// step on scale
				stepOnScale(g);
			} else if (choice == 7) {	// bump into wall
				bumpIntoWall(g);
			} else if (choice == 8) {	// step on ZPM
				stepOnZpm(g);
			} else if (choice == 9) {	// create portal
				createPortal(g);
			} else if (choice == 10) {	// pickup box
				pickupBox(g);
			} else if (choice == 11) {	// drop box
				dropBox(g);
			} else if (choice == 12) {	// put box on scale
				putBoxOnScale(g);
			} else if (choice == 13) {	// exit game
				exitGame(g);
			}*/
	} 	 while (choice != 4); 
	    
	    
	    if (choice == 4) {
	    	System.out.println("Finished Skeleton test.");
	    	System.exit(0);
	    	
	    }
}   
	    
	    static void help(){
	    	System.out.println("Main.help()");
	    	System.out.println("Kilépéshez nyomjon meg egy gombot!");
	    	try {
	            System.in.read();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    	
	    }
	    
	 
	    }

	
