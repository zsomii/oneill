package oneill;


/*● Felelősség
Ezeket képes felvenni a játékos. Minden egyes felvett ZPM után nő a játékos pontja.
Ha az összes ilyen objektumot összeszedte a játékos, akkor vége az adott pályának.
● Ősosztályok
abstract Component
● Interfészek
Nincsenek.
● Attribútumok

● location: Location: ebben tároljuk el egy adott objektum koordinátáit.
● value : int : megadja, hogy az adott ZPM mennyit ér
● isActive: boolean : megadja egy adott ZPM-ről, hogy az aktív-e. Akkor aktív egy
ZPM, ha azt még nem szedték fel. Amennyiben felszedték, akkor átvált hamisra a
változó.
● Metódusok
● ZPM(Location location, int value): a ZPM osztály konstruktora, létrehoz egy ZPM-et
● int getValue(): lekérdezi egy adott ZPM pontértékét
● void setState(boolean b): az adott ZPM isActive változóját állítja
● boolean getState(): az adott ZPM isActive változóját kérdezi le
● Location getLocation(): lekérdezi az adott objektum pozícióját
● void setLocation(Location value): beállíthatjuk egy adott objektum helyét a
képernyőn*/


public class ZPM extends Component{
	Location location;
	int value;
	boolean isActive;
	char icon;
	
	ZPM(Location loc, int value,char icon){
		setValue(value);
		setSteppable(true);
		setIcon(icon);
		
		System.out.println("		ZPM(Location location, int value) constructor. ");
		System.out.println("			x="+loc.getX()+" y="+loc.getY()+" value="+getValue());
	}
	
	int getValue(){
		return value;
	}
	
	void setValue(int v){
		 value = v;
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
	
	void setLocation(Location loc){
		location = loc;
	}
	
	char getIcon(){
		return icon;
	}
	
	void setIcon(char c){
		icon = c;		
	}
}
