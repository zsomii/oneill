package oneill;


public class Hole extends Component {
	Location location;
	boolean steppable;
	char icon;
	
	
	Hole(Location loc, char icon){
		System.out.println("		Hole(Location location) constructor. x="+loc.getX()+" y="+loc.getY());
		setSteppable(true);
		setLocation(loc);	
		setIcon(icon);
	}
	
	void kill(Player p){
		{
			System.out.println("You were killed by a tiny hole!");
		}
	}
	
	
	
	void destroy(Box b){}
	Location getLocation(){
		return location;
	}
	
	char getIcon(){
		return icon;
	}
	
	void setIcon(char c){
		icon = c;		
	}
}
