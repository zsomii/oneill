package oneill;

public interface Events {
       
	void checkEvents(Component c,Player p){
		if (c.getClass().getName().equals("oneill.Hole") )
					{
						System.out.println("You were killed by a tiny hole! :(((");
						kill(p);
						
					}
		if (c.getClass().getName().equals("oneill.ZPM") )
					{
						System.out.println("You picked up a ZPM module");
						setScore(c);
					}
		if (c.getClass().getName().equals("oneill.Box") )
					{
						System.out.println("U can pick up the box");
						
					}
		if (c.getClass().getName().equals("oneill.Wall") )
					{
						System.out.println("You bumped into a wall");
					}
		if (c.getClass().getName().equals("oneill.Ground") )
					{
						System.out.println("You stepped one");
						
					}
		if (c.getClass().getName().equals("oneill.Portal") )
					{	if(c.getValid())//nem vágom
						System.out.println("You will teleport now");
						else
						System.out.println("You need another portal to teleport");
						
					}
		if (c.getClass().getName().equals("oneill.Door") )
					{	
						if(c.GetState())
						System.out.println("You passed a door");
						else 
						System.out.println("You bumped into a closed door");
						
					}
		
	}
}
