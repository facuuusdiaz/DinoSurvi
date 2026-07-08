package ar.dinosurvival.Juego;

import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Inventory {

	protected Item [] slots;
	protected int maxCapacity;
	protected float maxWeight;
	protected float currentWeight;
	
	public Inventory() {}
	
	public boolean addItem(Item newItem) {
		return true;
	}
	
	public void removeItem(int slotIndex) {}
	
	public boolean hasItem(String itemName, int amount) {
		return true;
	}
	
	public List <Item> extractItems(String itemName, int amount) {
		return null;
	}
	
	public void updateWeight() {}
	
}
