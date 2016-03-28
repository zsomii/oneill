package oneill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/*
 Attribútumok
 time: Date: a játék kezdetének idejét tárolja.
 game_time: Date: az aktuális átékidőt tárolja.
 highScore: int:  az eddig elért legmagasabb pontszámot tárolja.
 player: Player: a játékos
 map: Map: az aktuálisan játszott pálya
 Metódusok
 Game(Date currentTime): az objektum konstruktora, létrehozza azt, a megadott paraméterek alapján.
 void update():  frissíti a játékállást a Player cselekedetei alapján.
 void quit(): bezárja a játékot.
 void help(): megnyitja a Segítség menüt.
 void showHighScore(): kiírja az aktuális highscore-t.
 int getPlayerScore(): lekérdezi a játékos aktuális pontszámát */

//Date(int year, int month, int date, int hrs, int min, int sec)

public class Game {
	Date time;
	Date game_time;
	int highScore;
	static Player player;
	int locationX =0;
	int locationY = 0;
	int boxID = 1;
	int doorID = 1;
	int maxrows = 0;
	int maxcolumns = 0;
	static ArrayList<Component> components = new ArrayList<Component>();
	Game g = this;

	void loadMap() {
		System.out.println("	Game.loadMap()");
		try {
			File file = new File("src/map1.txt");
			Scanner scanner = new Scanner(file);
			String current = new String();
			while (scanner.hasNext()) {
				current = scanner.next();

				if (current.equals("|")) { // end of a row, next row comes
					if (locationX > maxcolumns)
						maxcolumns = locationX;	
					locationX = 0;								
					maxrows++;
					locationY++;
				}
				
				//Ha a betöltött karakter W, akkor épp egy falat töltöttünk be.
				else if (current.equals("W")) {
					Location loc = new Location(locationX, locationY);
					Wall w = new Wall(loc,'W');
					components.add(w);
					locationX++;
				}

				else if (current.equals("G")) { // GROUND was loaded
					Location loc = new Location(locationX, locationY);
					Ground g = new Ground(loc,'G');
					components.add(g);
					locationX++;
				}

				else if (current.equals("H")) { // HOLE was loaded
					Location loc = new Location(locationX, locationY);
					Hole h = new Hole(loc,'H');
					components.add(h);
					locationX++;
					
				} else if (current.contains("D")) { // DOOR was loaded
					Location loc = new Location(locationX, locationY);
					int SCALE_ID = Integer.parseInt(current.substring(
							current.indexOf('_') + 1, current.indexOf('-')));
					int DOOR_ID = Integer.parseInt(current.substring(
							current.indexOf('-') + 1, current.length()));

					Door d = new Door(loc, DOOR_ID, SCALE_ID,'D');
					components.add(d);
					locationX++;
					
				} else if (current.contains("Z")) { // ZPM was loaded
					Location loc = new Location(locationX, locationY);
					int ZPMvalue = Integer.parseInt(current.substring(
							current.indexOf('_') + 1, current.length()));
					ZPM zpm = new ZPM(loc, ZPMvalue,'Z');
					zpm.setSteppable(true);
					components.add(zpm);
					locationX++;
				}

				else if (current.contains("S")) { // SCALE was loaded
					Location loc = new Location(locationX, locationY);
					int DOOR_ID = Integer.parseInt(current.substring(
							current.indexOf('_') + 1, current.indexOf('-')));
					int SCALE_ID = Integer.parseInt(current.substring(
							current.indexOf('-') + 1, current.length()));
					Scale sc = new Scale(loc, SCALE_ID, DOOR_ID,'S');
					sc.setSteppable(true);
					components.add(sc);
					locationX++;
				}

				else if (current.equals("O")) { // Players start point was
												// loaded
					Location loc = new Location(locationX, locationY);
					player = new Player(loc,'O');
					components.add(player);
					locationX++;
				}

				else if (current.equals("B")) { // BOX was loaded
					Location loc = new Location(locationX, locationY);
					Box b = new Box(loc,'B');
					b.steppable = true;
					b.isCarried = false;
					b.box_ID = boxID;
					boxID++;
					components.add(b);
					locationX++;
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("	All components were loaded!");

	}

	Game(Date date) {
		System.out.println("Creating new game (constructor)");
		time = date;
		System.out.println("  Calling Game.loadMap()");
		loadMap();
	}

	/*
	 * Kirajzolja a teljes pályát a képernyőre W = wall G = ground H = hole B =
	 * box Z = zpm O = player D = door
	 */
	void update() throws IOException{
	System.out.println("	Game.update()");  
	//Runtime.getRuntime().exec("cls");
	
for (int i= 0; i  < maxrows ; i++)	{
	for (int j = 0; j < maxcolumns;j++){
		Component c = components.get(i*maxcolumns+j);
		System.out.print(c.getIcon()+"("+i+","+j+")		");
	}
	System.out.println("");	
}
	
}

	void quit() {
		System.out.println("Game.quit()");
		System.out.println("");
		System.out.println("＼( ･_･)");
		System.out.println("Bye!");
		
		
		
	}
	
	  void Idle() throws IOException{
	    	System.out.println("Merre akarsz lepni?");
	    	System.out.println("w - előre | a - balra | d - jobbra | s - hátra");
	    	
	    	   BufferedReader buffer = new BufferedReader(
	                   new InputStreamReader(System.in));
	          int c = 0;
	          while((c = buffer.read()) != -1) {
	              char character = (char) c;     
	            //0 = UP, 1 = DOWN, 2 = LEFT, 3= RIGHT
	                 if (character == 'w'){
	                	 player.setDirection(0);
	                	 player.Step(components,maxrows,maxcolumns,0);
	                	 update();
	                 }
	                 else if (character == 's'){
	                	 player.setDirection(1);	
	                	 player.Step(components,maxrows,maxcolumns,1);
	                	 update();
	                 }
	                 else if (character == 'a'){
	                	 player.setDirection(2);
	                	 player.Step(components,maxrows,maxcolumns,2);
	                	update();
	                 }
	                 else if (character == 'd'){
	                	 player.setDirection(3);	 
	                	 player.Step(components,maxrows,maxcolumns,3);
	                	 update();
	                 }
	          }       
	      } 

		static void checkEvents(Component comp)
		{
			if (comp.getClass().getName().equals("oneill.Hole") )
			{
				System.out.println("You were killed by a tiny hole! :(((");
				player.setState(false);
			}
			
			if (comp.getClass().getName().equals("oneill.Box") )
			{
				int  i = 0;
				player.setIcon('C');
				Component temp;
				Component foundComp=null;
				int pos = 0;

	
				
				ListIterator<Component> componentIterator = components.listIterator();				
				while (componentIterator.hasNext()) {					
					temp =  componentIterator.next();
					i++;
					 if (comp.getLocation() == temp.getLocation())	{					 
						 System.out.println("Found!");
						 foundComp = temp;
						 pos = i;
					 }
				}
				
				Ground g = new Ground(foundComp.getLocation(),'G');			
				components.set(pos, g);	
				
				System.out.println("You've picked up a box!");
				
			}		
			
			if (comp.getClass().getName().equals("oneill.Scale") )
			{
								
				int a = 0;	
				int pos = 0;
				Scale sc = (Scale) comp;				
				Scale tempScale = new Scale();
				Door door = null;
				Location foundLocation = null;
				
				ListIterator<Component> componentIterator2 = components.listIterator();				
				while (componentIterator2.hasNext()) {					
					door = (Door) componentIterator2.next();
					a++;
					 if (door.ID == sc.getDOOR_ID())	{					 
						 System.out.println("Found!");
						 pos = a;
						 foundLocation = new Location(tempScale.getLocation().getX(),tempScale.getLocation().getY());
					 }
				}
				
				
				
				Door d = new Door(foundLocation, door.getID(), door.getScale_ID(),' ');	
				d.setState(true);
				components.set(pos, d);	
				
				System.out.println("You are standing on a scale, so a door was opened.");
				
			}
			
			
		}
		
	void showHighScore() {
	}

	int getPlayerScore() {

		return player.getScore();
	}

}
