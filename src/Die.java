
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
	//public String showDie(int value)
	
	public String getDiePic(int value, SkunkUI ui)
	{
		String showDie = ui.printDie(value);
		
	return showDie;
	}
}
