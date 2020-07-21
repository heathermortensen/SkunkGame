
public class Roll {
	private int lastTotal;
	
	public Roll()
	{
		lastTotal=rollDie(); 
		lastTotal=+rollDie();
	}
	
	public int rollDie()
	{
		return lastTotal=(int)Math.random()*6+1;
	}
	public int getLastTotal(){
		return lastTotal; 
	}
	

}
