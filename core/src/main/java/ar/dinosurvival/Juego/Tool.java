package ar.dinosurvival.Juego;

public class Tool extends Item {

    protected float currentDurability;
    protected float baseDamage;
    protected String toolType;
    
    public Tool() {}
    
    @Override
    public void use(Player player) {
        // Equipar la herramienta en la mano del jugador
    }

    @Override
    public Item cloneWithAmount(int amount) {
        Tool clone = new Tool();
        clone.name = this.name;
        clone.weight = this.weight;
        clone.maxStack = this.maxStack;
        clone.texture = this.texture;
        clone.description = this.description;
        
        // Atributos específicos de Tool
        clone.currentDurability = this.currentDurability;
        clone.baseDamage = this.baseDamage;
        clone.toolType = this.toolType;
        
        clone.setCurrentAmount(amount);
        return clone;
    }

    // Getters específicos
    public float getCurrentDurability() { return currentDurability; }
    public float getBaseDamage() { return baseDamage; }
    public String getToolType() { return toolType; }
    
    public void setCurrentDurability(float durability) { this.currentDurability = durability; }
}
