package ar.dinosurvival.Juego;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Item {
	
	protected TextureRegion texture;
	protected String name;
	protected String description;
	protected float weight;
	protected int currentAmount;
	protected int maxStack;
	
	
	public Item() {}
	
	public abstract void use(Player player);
	
}
