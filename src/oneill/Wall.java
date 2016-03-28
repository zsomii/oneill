package oneill;

public class Wall extends Component{
	Location location;
	boolean steppable;
	char icon;
	
	Wall(Location loc,char icon){
		  System.out.println("		Wall(Location location) constructor. x="+loc.getX()+" y="+loc.getY());
		  steppable = false;
		  location = loc;
		  setIcon(icon);
	}
	//konstruktor
	
	void setLocation(Location loc){
		location = loc;
	}
	
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
