/**
 * 
 */
package oneill;

/**
 * @author Adam
 *
 */



public class Box extends Component{
	Location location;
	boolean isCarried;
	int box_ID;
	char icon;
	
	Box(Location loc, char icon){
		setLocation(loc);
		setState(false);
		setIcon(icon);
		System.out.println("		Box(Location location, int value) constructor. x="+location.getX()+" y="+loc.getY());			
	}
	
	void setState(boolean b){
		isCarried = b;
	}
	
	boolean getState(){
		return isCarried;
	}
	
	Location getLocation(){
		return location;
	}
	void setLocation(Location value)
	{
		location = value;
	}
	char getIcon(){
		return icon;
	}
	
	void setIcon(char c){
		icon = c;		
	}	
	

}
