
public class Die 
{
	private int value;
	
	 Die()
	{
		value = 0;
	}
	public int getValue()
	{
		return this.value;
	}
	public void setValue(int die_value)
	{
		this.value =  die_value;
	}
	public int roll()
	{
		int roll = 0;
		int SIDE = 6;
		
		//generate a random number between 1 and 6.....
        roll = 1 + (int) (Math.random() * SIDE);
      
		return roll;
		
	}
	//Put this inside the UISkunk class......
	public String showDie(int value)
	{
		String diePicture = "";
		
		diePicture = diePicture.concat("     ______\n");
		diePicture = diePicture.concat("    |      |\\\n");
		diePicture = diePicture.concat("    |  "+ value+"   | |\n");	
		diePicture = diePicture.concat("    |______| |\n");
		diePicture = diePicture.concat("     \\______\\|\n");
	
		//diePicture = diePicture.concat("   Move this into UI class  \n");
		
		return diePicture;
	}
	
}
