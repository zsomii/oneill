package oneill;

/*
 * 4.3.10 Portal

● Felelősség
Ebben az osztályban tároljuk az adott portál helyét és állapotát. Eltároljuk benne, hogy épp
milyen színű a kilőtt portál és ha van egy valid kék és egy valid sárga portál, akkor a játékos
“átmehet a falon”.
● Ősosztályok
abstract Component
● Interfészek
Nincsenek.
● Attribútumok
● location: Location: ebben tároljuk el egy adott objektum koordinátáit.
● color: int : megadja, hogy egy adott kilőtt portál milyen színű
● isValid: boolean : eltároljuk, hogy egy adott lövés érvényes volt-e, azaz képes-e a
falon portált nyitni
● isActive: boolean : ha mind a kék és mind a sárga portál képes volt arra, hogy
portált nyisson, akkor a féregjárat elérhetővé válik, ezt tároljuk ebben a változóban.
● Metódusok
● Portal(int c, Location location): létrehoz egy c színű portált a Location helyen.
● void setPlayerLocation(Player p, Location loc): ha egy játékos átment egy
portálon, akkor a helyzete megváltozik,ez a függvény átállítja azt.
● void setValid(boolean value) : beállítja egy adott portálra, hogy az érvényes
lövésből származik-e
● boolean getValid(): visszaadja, hogy a portál érvényes lövésből származik-e
● void setActive(boolean value): beállítja mind a 2 helyen, ha létezik érvényes átjáró
a 2 pont között
● boolean getActive(): lekérdezi, hogy van-e érvényes átjáró a 2 pont között
0 - kék
1 - sárga*/

public class Portal extends Component {
	Location location;
	int color;
	boolean isValid;
	boolean isActive;
	
	Portal(Location loc, int c){
		//kifejteni
	}
	void setPlayerLocation(Player p,Location loc){
		//kifejteni
	}
	
	void setValid(boolean b){
		isValid = b;
	}
	
	boolean getValid(){
		return isValid;
	}
	
	void setActive(boolean b){
		isActive = b;
	}
	
	boolean getActive(){
		return isActive;
	}
}
