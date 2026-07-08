package ar.dinosurvival.Juego;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

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
	public void update(float elapsedTime) {
		
		float direccionX = 0f;
		float direccionY = 0f;

		if(Gdx.input.isKeyPressed(Keys.W)) {
			direccionY += 1f;
		}

		if(Gdx.input.isKeyPressed(Keys.S)){

			direccionY -= 1f;
		}

		if(Gdx.input.isKeyPressed(Keys.A)) {
			direccionX -= 1f;
		}

		if(Gdx.input.isKeyPressed(Keys.D)) {
			direccionX += 1f;
		}

		//Logic to ensure that moving diagonally is not faster than moving normally.
		if(direccionX != 0 || direccionY != 0) {
		float length = (float) Math.sqrt(direccionX * direccionX + direccionY * direccionY);
		direccionX /= length;
		direccionY /= length;

		move(direccionX, direccionY, elapsedTime);
		}
		
	}
	
	

}
