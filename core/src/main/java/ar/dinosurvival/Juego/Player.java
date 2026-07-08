package ar.dinosurvival.Juego;

public class Player extends Entity{

	protected Inventory mainInventory;
	protected Inventory extraInventory;
	protected Item [] hotbar;
	protected Item itemInHand;
	
	public Player() {

		super("Player", 100, 100, 100, 100, 10);
		this.mainInventory = new Inventory();
	}
	
	@Override
	public void death() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float elepsedTime) {
		// TODO Auto-generated method stub
		
	}
	
	

}
