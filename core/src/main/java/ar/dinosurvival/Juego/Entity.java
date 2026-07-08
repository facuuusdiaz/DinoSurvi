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
	
	public Entity(String name, float healthMax, float weightMax, float foodMax, float waterMax, float attackDamage) {
		this.name = name;
		this.healthMax = healthMax;
		this.weightMax = weightMax;
		this.foodMax = foodMax;
		this.waterMax = waterMax;
		this.attackDamage = attackDamage;
		this.currentHealth = healthMax;
		this.currentFood = foodMax;
		this.currentWater = waterMax;
		this.x = 0;
		this.y = 0;		
		this.speed = 0;
		this.level = 1;
		this.currentXP = 0;
	}
	
	public void move() {}

	public void attack(float amount) {}
	
	public void receiveDamage(float amount) {

		this.currentHealth -= amount;
		if(this.currentHealth <= 0){
			death();
		}
	}
	
	public void recoverHealth(float amount) {

		this.currentHealth += amount;
		if(this.currentHealth >= this.healthMax){
			this.currentHealth = this.healthMax;
		}
	}
	
	public void consumeEnergy() {}
	
	public void consumeStat() {}
	
	public Object getHitbox() {}
	
	public boolean isAlive() {

		if (this.currentHealth > 0){
			return true;
		}
		return false;
	}
	
	public abstract void death();
	
	public String updateStat() {}
	
	public void levelUp() {}
	
	public abstract void update(float elepsedTime);
	
	public float getX() {}
	
	public float getY() {}
	
}
