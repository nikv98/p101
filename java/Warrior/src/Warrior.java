import java.util.Random;

public class Warrior 
{	
	public String name;
	public int hp;
	
	private int ac;
	private int mBab;
	private int rBab;
	private int str; //a character's strength in combat
	private int dex; //a character's nimbleness and proficiency with ranged weapons
	private int con; //a character's fortitude 
	private int intel; //a character's intelligence and craftiness
	private int wis; //will power and intuition
	private int cha; //is a character's street smarts, personality, and persuade
	private int maxDice;
	private Random rand;
	private Dice r2d10;
	
	/**
	 * This initalizes all the variables to create a warrior
	 */
	public Warrior(String name)
	{	
		r2d10 = new Dice(2, 10);
		
		rand = new Random();
		this.name = name;
		
		str = getAbilityScore();
		dex = getAbilityScore();
		con = getAbilityScore();
		intel = getAbilityScore();
		wis = getAbilityScore();
		cha = getAbilityScore();
		hp = new Dice(2, 10).roll() + con; //lets roll a d8 + con modifier for hp
		//ac is 10 + dex modifier
		ac = 10 + getAbilityModifier(dex);
		//base attack bonus + str mod + size human medium = 0
		mBab = 1 + getAbilityModifier(str) + 0;
		//base attack bonus + dex mod + size
		rBab = 1 + getAbilityModifier(dex) + 0;
		
		maxDice = 8;
	}
	
	public int getAbilityScore()
	{
		Dice r1d6 = new Dice(1, 6);
		int[] diceRolls = new int[4];
		//rolls a d6 4 times
		for(int n = 0; n < diceRolls.length; n++){
			diceRolls[n] = r1d6.roll();
		}
		
		int largest = diceRolls[0];
		int second = diceRolls[1];
		
		for(int i = 1; i < diceRolls.length; i++){
			if(diceRolls[i] > largest){
				second = largest;
				largest = diceRolls[i];
			}else if(diceRolls[i] > second){
				second = diceRolls[i];
			}
		}
		return largest + second;
	}
	
	public int getAbilityModifier(int abilityScore)
	{
		//the algorithm for ability modifiers > 3.0
		return abilityScore/2-5;
	}
	
	/**
	 * @return 1d20 + skill modifier
	 */
	public int getSkillCheck(int ability)
	{
		Dice r1d20 = new Dice(1, 20);
		return r1d20.roll() + getAbilityModifier(ability);
	}
	
	/**
	 * roll to see who attacks first
	 */
	public int rollForInitiative()
	{
		return getSkillCheck(dex);
	}
	
	public void attack(Warrior opponent)
	{
		//roll a d20
		int attackRoll = new Dice(1, 20).roll();
		int damage = 0;
		if(attackRoll == 20){
			//a critical hit
			//lets calculate damage
			damage = getDamage() + maxDice;
			opponent.hp -= damage;
		}else if(attackRoll == 1){
			//this is a special case where we, not our opponent are delt damage
			damage = getDamage();
			this.hp -= damage;
		}else{
			//in this situation, wwe need to check that our attack landed
			if(passAC(attackRoll, opponent)){
				damage = getDamage();
				opponent.hp -= damage;
			}
		}
	}
	
	/**
	 * Checks if the dice roll + correct BAB is greater then the opponent's AC
	 * @param opponentAC
	 * @return
	 */
	public boolean passAC(int attackRoll, Warrior opponent)
	{
		if(attackRoll + mBab > opponent.ac){
			return true;
		}else{ //our roll was less then the opponent's AC
			return false;
		}
	}
	
	/**
	 * This calculates the damage of our weapon
	 * @return
	 */
	public int getDamage()
	{
		//a longsword has 1d8 damage
		return new Dice(1, maxDice).roll();
	}
	
	public String toString()
	{
		return this.name + '\n' +
			   "hp: "+ this.hp + '\n' +
			   "ac: " + this.ac + '\n' +
			   "mBab: " + this.mBab + '\n' +
			   "rBab: " + this.rBab + '\n' +
			   "str: " + this.str + '\n' +
			   "dex: " + this.dex + '\n' +
			   "con: " + this.con + '\n' +
			   "intel: " + this.intel + '\n' +
			   "wis: " + this.wis + '\n' +
			   "cha: " + this.cha;
	}
}