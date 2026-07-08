package ar.dinosurvival.Juego;

public class Consumable extends Item {

    protected float restoreAmount;
    protected String affectedStat;
    
    public Consumable() {}
    
    @Override
    public void use(Player player) {
        // Aquí aplicarías la curación al jugador usando 'affectedStat' (ej: "health", "water", "food")
        // y sumándole el 'restoreAmount'.
    }

    @Override
    public Item cloneWithAmount(int amount) {
        Consumable clone = new Consumable();
        clone.name = this.name;
        clone.weight = this.weight;
        clone.maxStack = this.maxStack;
        clone.texture = this.texture;
        clone.description = this.description;
        
        // Atributos específicos de Consumable
        clone.restoreAmount = this.restoreAmount;
        clone.affectedStat = this.affectedStat;
        
        clone.setCurrentAmount(amount);
        return clone;
    }

    // Getters específicos
    public float getRestoreAmount() { return restoreAmount; }
    public String getAffectedStat() { return affectedStat; }
}
