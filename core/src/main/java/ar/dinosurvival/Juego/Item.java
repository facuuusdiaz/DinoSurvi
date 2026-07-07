package ar.dinosurvival.Juego;

public abstract class Item {
	
	protected String name;
	protected String description;
	protected float weight;
	protected int currentAmount;
	protected int maxStack;
	protected TextureRegion texture;
	
	public Item() {}
	
	public abstract void use(Player player);
	
}
