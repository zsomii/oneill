package oneill;



public class Ground extends Component{
	Location location;
	boolean steppable;
	char icon;
	
	Ground(Location loc,char icon){
		System.out.println("		Ground(Location location) constructor. x="+loc.getX()+" y="+loc.getY());
		setLocation(loc);
		setIcon(icon);
		setSteppable(true);
		
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
