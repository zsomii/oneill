package oneill;


/*Olyan objektum amely zárt állapotban áthatolhatatlan viszont nyitott állapotban a játékos át tud haladni rajta. 
Minden egyes ilyen Door objektumhoz tartozik egy Scale objektum amely az adott objektumhoz tartozó scale_ID azonosít.
Ha az ehhez tartozó Scale objektumra Box vagy Player objektum kerül akkor ez a Door objektum nyitva lesz.*/
public class Door  extends Component{
	Location location;
	boolean isOpen;
	int scale_ID;
	int ID;
	char icon;
	
	//A Door osztály konstruktora, ami  létrehoz egy Door objektumot a megadott függvényparaméterekkel
	Door(Location loc, int ID, int SCALE_ID, char icon){
		setLocation(loc);
		setState(false);
		setSteppable(false);				
		setScale_ID(SCALE_ID);
		setIcon(icon);
		
		System.out.println("		Door(Location location, int SCALE_ID) constructor.");
		System.out.println("			x=" +location.getX()+ " y=" +location.getY()+ " SCALE_ID=" +getScale_ID());
	}
	
	public Door() {
		// TODO Auto-generated constructor stub
	}

	//Beállítja egy Door objektum isOpen értékét a paraméterben megadott értékre
	void setState(boolean b){
		isOpen = b;
	 
	}
	
	//Vissza adja az adott objektum isOpen attribútumának értékét
	boolean getState(){
		return isOpen;
	}
	
	//Vissza adja az adott Door objektumhoz tartozó Scale objektum azonosító számát (scale_ID)
	int getScale_ID(){
		return scale_ID;
	}
	
	void setScale_ID(int SCALE_ID){
		scale_ID = SCALE_ID;
	}
	
	Location getLocation(){
		return location;
	}
	
	void setID(int v){
		ID = v;
	}
	
	int getID(){
		return ID;
	}
	
	/*Beállíthatjuk egy adott objektum helyét a képernyõn*/
	void setLocation(Location loc){
		location = loc;
	}
	
	char getIcon(){
		return icon;
	}
	
	void setIcon(char c){
		icon = c;		
		if (getState())
			icon =' ';
		else icon = c;	
	}
}

