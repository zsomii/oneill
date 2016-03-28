package oneill;


/*
 * 4.3.11 Scale
● Felelősség
Alapból inaktív állapotban van, ha súly kerül rá(Box, Player), aktiválódik és kinyitja a hozzá
tartozó Door-t.
● Ősosztályok
abstract Component
● Interfészek
Nincsenek
● Attribútumok
● location: Location: ebben tároljuk el egy adott objektum koordinátáit.
● isActive: boolean: megadja, hogy van-e súly az adott objektumon.
● ID: int: az adott objektumhoz tartozó azonosító szám.
● Door_ID: az adott objektumhoz tartozó Door objektum azonosító száma.
● Metódusok
● Scale(Location location): az osztály konstruktora, beállítja a paraméterként
megadott értékeket.
● void setState(boolean b): beállítja egy Scale objektum isActive értékét a
paraméterben megadott értékre
● boolean getState(): visszaadja az adott objektum isActive attribútumának értékét
● Location getLocation(): megadja az adott objektum pozícióját.
● void OpenDoor(): a hozzá tartozó Door state-jét open-re változtatja.
● void CloseDoor(): a hozzá tartozó Door state-jét closed-ra változtatja.
 */
public class Scale extends Component{
	Location location;
	boolean isActive;
	int ID;
	int Door_ID;
	char icon;
	
	
	Scale(Location loc, int scale_id, int doorID,char icon){
		setIcon(icon);
		setLocation(loc);
		setState(false);
		setSteppable(true);		
		setDoor(Door_ID);
		System.out.println("		Scale(Location location) constructor.");
		System.out.println("		 x="+loc.getX()+" y="+loc.getY()+" ID="+getID()+" DOOR_ID="+getDOOR_ID());
		setScaleID(scale_id);
		
	}
	
	public Scale() {
		// TODO Auto-generated constructor stub
	}

	void setScaleID(int scale_id) {
		ID = scale_id;		
	}

	void setState(boolean b){
		isActive = b;
	}
	
	boolean getState(){
		return isActive;
	}
	
	Location getLocation(){
		return location;
	}
	
	void setDoor(int doorID){
		Door_ID = doorID;
	}
	
	int getDOOR_ID(){
		return Door_ID;
	}
	
	int getID(){
		return ID;
	}
	
	char getIcon(){
		return icon;
	}
	
	void setIcon(char c){
		icon = c;		
	}
	
	void OpenDoor(){}
	void CloseDoor(){}
		
}
