package ar.dinosurvival.Juego;

public class Dino extends Entity{

	protected Inventory saddleBag;
	protected boolean tamed;
	protected String behavior;
	protected boolean followPlayer;
	protected String diet;
	
	public Dino(){

		super("Dino", 100, 100, 100, 100, 10);
		this.saddleBag = new Inventory(10, 50.0f);
		this.tamed = false;
		this.behavior = "Passive";
		this.followPlayer = false;
		this.diet = "Herbivore";
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
