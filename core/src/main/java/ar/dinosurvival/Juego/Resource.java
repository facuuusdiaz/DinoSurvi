package ar.dinosurvival.Juego;

public class Resource extends Item {

    public Resource() {}
    
    @Override
    public void use(Player player) {
        // Los recursos generalmente no se "usan" directamente desde el inventario,
        // sino que se consumen al craftear. Podrías dejarlo vacío o mandar un mensaje.
    }

    @Override
    public Item cloneWithAmount(int amount) {
        Resource clone = new Resource();
        clone.name = this.name;
        clone.weight = this.weight;
        clone.maxStack = this.maxStack;
        clone.texture = this.texture;
        clone.description = this.description;
        
        clone.setCurrentAmount(amount);
        return clone;
    }
}
