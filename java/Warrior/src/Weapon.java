public class Weapon 
{
	private String name;
	private int damage;
	private int critical;
	
	/**
	 * the constructor for a weapon
	 */
	public Weapon(String name, int damage, int critical)
	{
		this.name = name;
		this.damage = damage;
		this.critical = critical;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getDamage()
	{
		return this.damage;
	}
	
	public int getCritical()
	{
		return this.critical;
	}
}
