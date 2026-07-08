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
    
    // ==========================================
    //           GETTERS Y SETTERS
    // ==========================================

    public String getName() {
        return this.name;
    }

    public float getWeight() {
        return this.weight;
    }

    public int getCurrentAmount() {
        return this.currentAmount;
    }

    public void setCurrentAmount(int amount) {
        this.currentAmount = amount;
    }

    public int getMaxStack() {
        return this.maxStack;
    }

    public TextureRegion getTexture() {
        return this.texture;
    }

    public String getDescription() {
        return this.description;
    }

    // ==========================================
    //       MÉTODOS DE LÓGICA DE STACK
    // ==========================================

    /**
     * Agrega cantidad al stack actual respetando el maxStack.
     * @return El sobrante que no pudo entrar (0 si entró todo).
     */
    public int addAmount(int amountToAdd) {
        int spaceLeft = this.maxStack - this.currentAmount;
        
        if (amountToAdd <= spaceLeft) {
            this.currentAmount += amountToAdd;
            return 0; // Entró todo
        } else {
            this.currentAmount = this.maxStack; // Se llena el stack
            return amountToAdd - spaceLeft;     // Devuelve el sobrante
        }
    }

    
     //* Para solucionar el problema de la clase abstracta, obligamos a las
     //* subclases (Resource, Consumable, Tool) a implementar cómo clonarse a sí mismas.
     
    public abstract Item cloneWithAmount(int amount);
}
