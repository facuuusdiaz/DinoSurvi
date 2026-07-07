package ar.dinosurvival.Juego;

public abstract class Entity {

	protected String name;
	protected float healthMax;
	protected float weightMax;
	protected float foodMax;
	protected float waterMax;
	protected float attackDamage;
	
	protected float currentHealth;
	protected float currentFood;
	protected float currentWater;
	
	protected float x;
	protected float y;
	protected float speed;
	protected int level;
	protected float currentXP;
	
	public Entity() {}
	
	public void move() {}

	public void attack(float amount) {}
	
	public void receiveDamage(float amount) {}
	
	public void recoverHealth(float amount) {}
	
	public void consumeEnergy() {}
	
	public void consumeStat() {}
	
	public Object getHitbox() {}
	
	public boolean isAlive() {}
	
	public abstract void death();
	
	public String updateStat() {}
	
	public void levelUp() {}
	
	public abstract void update(float elepsedTime);
	
	public float getX() {}
	
	public float getY() {}
	
}
