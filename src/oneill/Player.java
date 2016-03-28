package oneill;

import java.util.ArrayList;

public class Player extends Component {

	Location location;
	int score;
	boolean isAlive;
	// Is he carrying something?
	boolean hand;
	int direction;
	char icon;

	Player(Location location, char icon) {
		setLocation(location);
		score = 0;
		setState(true);
		hand = false;
		direction = 0;
		setIcon(icon);
		System.out.println("		Player(Location location) constructor. x="
				+ location.getX() + " y=" + location.getY());
	}

	void setLocation(Location loc) {
		location = loc;

	}

	Location getLocation() {
		return location;
	}

	/*
	 * Beállítjuk, hogy éppen merre néz a játékos. 
	 * 0 = UP, 
	 * 1 = DOWN, 
	 * 2 = LEFT,
	 * 3= RIGHT
	 *	 * @param int dir
	 */
	void setDirection(int dir) {
		direction = dir;
		System.out.println("Player.setDirection() - the direction was set. ("
				+ (getDirection()) + ")");
	}

	void setScore(ZPM zpm) {
		score = score + zpm.getValue();
	}

	int getScore() {
		return score;
	}

	void setState(boolean b) {
		isAlive = b;
		System.out.println("Player.setState() was set to: " +b);
	}

	boolean getState() {
		return isAlive;
	}

	int getDirection() {
		return direction;
	}

	void pickUp(Box b) {
		// felvétel függvénye
		hand = true;
	}

	void Drop() {
		// eldobás függvénye
		hand = false;
	}

	boolean Carry() {
		return hand;
	}

	/*
	 * Portal YellowShot(){ //portálkészítés függvénye return;
	 * 
	 * }
	 * 
	 * Portal BlueShot(){ //portálkészítés függvénye return;
	 */

	void Step(ArrayList<Component> components, int maxrows, int maxcolumns, int direction) {
		
		// Ha felfelé szeretnénk lépni, akkor ez a rész megvizsgálja a felettünk
		// lévő mezőt,
		// megnézi, hogy arra lehet-e lépni, majd ha lehet, akkor megcseréli a
		// két komponenst.
	if ( direction == 0 ){
		if (getLocation().getX() != 0) {
			Component compForward = components.get((getLocation().getY() - 1)
					* maxcolumns + getLocation().getX());
			System.out.println("Component.getClass(): "	+ compForward.getClass());
			System.out.println("Component.getSteppable(): " + compForward.getSteppable());
			if ((compForward.getSteppable() == true) && (getDirection() == 0)) {
				System.out.println("This is a valid step!");
				
				Game.checkEvents(compForward);
				Location temp = new Location(getLocation().getX(),
						getLocation().getY() - 1);

				/* Kicseréljük a 2 komponenst */
				// A tégi komponens, amire léptünk
				Component tempComp = components.get((getLocation().getY() - 1)
						* maxcolumns + getLocation().getX());
				// A játékos komponense
				Component tempComp2 = components.get((getLocation().getY())
						* maxcolumns + getLocation().getX());

				components.set((getLocation().getY() - 1) * maxcolumns
						+ getLocation().getX(), tempComp2);
				components.set((getLocation().getY()) * maxcolumns
						+ getLocation().getX(), tempComp);
				setLocation(temp);

			}
		}
	}
			
		/*Hátralépés megvalósítása a fentihez hasonlóan.		 * 
		 * */
		else if ( direction == 1 ){
		 if (getLocation().getX() != maxcolumns) {
			Component compBackwards = components.get((getLocation().getY() +1)
					* maxcolumns + getLocation().getX());
			System.out.println("Component.getClass(): "	+ compBackwards.getClass());
			System.out.println("Component.getSteppable(): " + compBackwards.getSteppable());
			if ((compBackwards.getSteppable() == true)) {
				System.out.print("This is a valid step!");
				Game.checkEvents(compBackwards);
				
				Location temp = new Location(getLocation().getX(),
						getLocation().getY() + 1);

				// Kicseréljük a 2 komponenst 
				// A tégi komponens, amire léptünk
				Component tempComp = components.get((getLocation().getY() + 1)
						* maxcolumns + getLocation().getX());
				// A játékos komponense
				Component tempComp2 = components.get((getLocation().getY())
						* maxcolumns + getLocation().getX());

				components.set((getLocation().getY() + 1) * maxcolumns
						+ getLocation().getX(), tempComp2);
				components.set((getLocation().getY()) * maxcolumns
						+ getLocation().getX(), tempComp);
				setLocation(temp);
				System.out.println("  Player's new location is: x= "+ getLocation().getX() + " y=" + getLocation().getY());
			}
		}
	}
	
		else if ( direction == 2 ){
			 if (getLocation().getY() != 0) {
				Component compLeft = components.get((getLocation().getY())
						* maxcolumns + getLocation().getX()-1);
				System.out.println("Component.getClass(): "	+ compLeft.getClass());
				System.out.println("Component.getSteppable(): " + compLeft.getSteppable());
				if ((compLeft.getSteppable() == true)) {
					System.out.print("This is a valid step!");
					Game.checkEvents(compLeft);

					Location temp = new Location(getLocation().getX()-1,
							getLocation().getY());

					// Kicseréljük a 2 komponenst 
					// A tégi komponens, amire léptünk
					Component tempComp = components.get((getLocation().getY())
							* maxcolumns + getLocation().getX()-1);
					// A játékos komponense
					Component tempComp2 = components.get((getLocation().getY())
							* maxcolumns + getLocation().getX());

					components.set((getLocation().getY()) * maxcolumns
							+ getLocation().getX()-1, tempComp2);
					components.set((getLocation().getY()) * maxcolumns
							+ getLocation().getX(), tempComp);
					setLocation(temp);
				}
			}
		}
	
	
		else if ( direction == 3 ){
			 if (getLocation().getY() != maxrows) {
				Component compRight = components.get((getLocation().getY())
						* maxcolumns + getLocation().getX()+1);
				System.out.println("Component.getClass(): "	+ compRight.getClass());
				System.out.println("Component.getSteppable(): " + compRight.getSteppable());
				if ((compRight.getSteppable() == true)) {
					System.out.print("This is a valid step!");
					Game.checkEvents(compRight);

					Location temp = new Location(getLocation().getX()+1,
							getLocation().getY());
					if (compRight.getClass().getName().equals("oneill.Hole") )
					{
						System.out.println("You were killed by a tiny hole! :(((");
					}
					// Kicseréljük a 2 komponenst 
					// A tégi komponens, amire léptünk
					Component tempComp = components.get((getLocation().getY())
							* maxcolumns + getLocation().getX()+1);
					// A játékos komponense
					Component tempComp2 = components.get((getLocation().getY())
							* maxcolumns + getLocation().getX());

					components.set((getLocation().getY()) * maxcolumns
							+ getLocation().getX()+1, tempComp2);
					components.set((getLocation().getY()) * maxcolumns
							+ getLocation().getX(), tempComp);
					setLocation(temp);
					
					}
			}
		}
	       
       
	}

	char getIcon() {
		return icon;
	}

	void setIcon(char c) {
		icon = c;
	}
	

}
