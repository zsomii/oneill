package oneill;

public abstract class Component {
	Location location;
	boolean steppable;
	char icon;
	
	Location getLocation()
	{
		return location;
	}
	
	void setLocation(Location value)
	{
	}
	
	boolean getSteppable(){
		
		return steppable;
	}
	
	void setSteppable(boolean b){
		steppable = b;
	}
	
	char getIcon(){
		return icon;
	}
	
	void setIcon(char c){
		icon = c;		
	}
}
