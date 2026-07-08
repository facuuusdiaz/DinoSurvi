package ar.dinosurvival.Juego;

// IMPORT CORRECTO PARA LOGICA DE DATOS
import java.util.List;
import java.util.ArrayList; 

public class Inventory {

    protected Item[] slots;
    protected int maxCapacity;
    protected float maxWeight;
    protected float currentWeight;
    
    public Inventory(int maxCapacity, float maxWeight) {
        this.maxCapacity = maxCapacity;
        this.maxWeight = maxWeight;
        this.slots = new Item[maxCapacity]; // Inicializás el array con la capacidad máxima
        this.currentWeight = 0.0f;
    }














///////////////////////////////////////////////////////////////////////
    
    public boolean addItem(Item newItem) {
    // 1. Validar si el peso del nuevo ítem supera el límite máximo
    float itemTotalWeight = newItem.getWeight() * newItem.getCurrentAmount();
    if (this.currentWeight + itemTotalWeight > this.maxWeight) {
        return false; // Inventario lleno por peso
    }

    // 2. Intentar agrupar (Stackear) si el ítem lo permite
    // Recorremos los slots buscando un ítem igual que no esté al máximo de su capacidad de stack
    for (int i = 0; i < slots.length; i++) {
        if (slots[i] != null && slots[i].getName().equals(newItem.getName())) {
            // Asumiendo que Item tiene un método para sumarle cantidad y maneja su maxStack
            int remaining = slots[i].addAmount(newItem.getCurrentAmount()); 
            if (remaining == 0) {
                updateWeight();
                return true; // Se pudo meter todo en este slot
            }
            // Si quedó un sobrante (porque el stack se llenó), actualizamos el newItem con lo que quedó
            newItem.setCurrentAmount(remaining);
        }
    }

    // 3. Si no se pudo stackear por completo, buscar el primer slot vacío
    for (int i = 0; i < slots.length; i++) {
        if (slots[i] == null) {
            slots[i] = newItem;
            updateWeight();
            return true;
        }
    }

    return false; // No hay slots libres (Inventario lleno por espacio)
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






    
    public void removeItem(int slotIndex) {
    // Validar que el índice esté dentro del rango del array
    if (slotIndex >= 0 && slotIndex < slots.length) {
        slots[slotIndex] = null; // Vaciamos el slot
        updateWeight();          // Al quitar algo, el peso actual disminuye
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





    
   public boolean hasItem(String itemName, int amount) {
    int totalFound = 0;

    // Recorremos todo el inventario sumando las cantidades del ítem buscado
    for (Item item : slots) {
        if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            totalFound += item.getCurrentAmount();
            
            // Si ya encontramos la cantidad necesaria, no hace falta seguir buscando
            if (totalFound >= amount) {
                return true;
            }
        }
    }
    return false;
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
 

public List<Item> extractItems(String itemName, int amount) {
    List<Item> extractedList = new ArrayList<>();
    int amountNeeded = amount;

    for (int i = 0; i < slots.length; i++) {
        if (slots[i] != null && slots[i].getName().equalsIgnoreCase(itemName)) {
            int available = slots[i].getCurrentAmount();

            if (available <= amountNeeded) {
                // El slot tiene menos o igual de lo que necesito: me llevo todo el slot
                extractedList.add(slots[i]);
                amountNeeded -= available;
                slots[i] = null; // El slot queda vacío
            } else {
                // El slot tiene más de lo que necesito: clono el ítem con la cantidad exacta que me falta
                Item partialItem = slots[i].cloneWithAmount(amountNeeded); // Método auxiliar ficticio para clonar
                extractedList.add(partialItem);
                
                // Restamos la cantidad del slot original
                slots[i].setCurrentAmount(available - amountNeeded);
                amountNeeded = 0;
            }
        }

        // Si ya conseguimos todo lo requerido, terminamos el bucle
        if (amountNeeded == 0) {
            break;
        }
    }

    updateWeight();
    return extractedList;
}
    






//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




   public void updateWeight() {
    float totalWeight = 0.0f;

    for (Item item : slots) {
        if (item != null) {
            // Peso del ítem individual * cuántos hay en el stack
            totalWeight += item.getWeight() * item.getCurrentAmount();
        }
    }

    this.currentWeight = totalWeight;
}




}
