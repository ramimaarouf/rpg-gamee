import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
    public void add(Item item) {
        
    }
}