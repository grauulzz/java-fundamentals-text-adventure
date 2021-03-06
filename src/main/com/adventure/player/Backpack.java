package main.com.adventure.player;

import main.com.adventure.world.objects.Tangible;

import java.util.ArrayList;

/**
 * Stores any Tangible item up to the MAX_CAPACITY.
 */
public class Backpack {

    private static final int MAX_CAPACITY = 5;

//    ArrayList<Tangible> items = new ArrayList<>();

    private final Tangible[] items = new Tangible[MAX_CAPACITY];

    /**
     * Add an item to the end of the backpack array and only if there's enough room in the backpack.
     * @param item - item to add to the backpack array.
     * @return - true if the item is added. Otherwise, false.
     */
    public boolean addItem(Tangible item) {
//        if (items.size() >= MAX_CAPACITY) {
//            return false;
//        }
//        items.add(item);
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (items[i] == null) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks each backpack item's name to see if it matches the given name.
     * @param name - the name of the item to search for.
     * @return - the item if it exists. Otherwise, null.
     */
    public Tangible getItem(String name) {
//        return items.stream()
//                .filter(item -> name.equals(item.getName()))
//                .findAny()
//                .orElse(null);
        for (Tangible item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if the given item exists in the backpack and removes it if it is.
     * @param item - item to remove
     * @return - true if the item was removed. Otherwise, false.
     */
    public boolean removeItem(Tangible item) {
//        return items.remove(item);

//        for (Tangible item1 : items) {
//            if (item1.equals(item)) {
//                item.equals(null);
//            }
//        }

        for (int i=0; i < MAX_CAPACITY; i++) {
            if (items[i] == item) {
                items[i] = null;
                return true;
            }

        }

        return false;

    }

    /**
     * Prints the contents of the backpack. Before printing the contents, the following line should
     * be printed:
     *
     *          "Here are the items in your backpack:"
     *
     * Then each item should be printed with " - " before it.
     */
    public void printItems() {
        System.out.println("Here are the items in your backpack:");
//        items.forEach(item -> System.out.println(" - " + item.getName()));
        for (Tangible dumbItem : items) {
            System.out.println(" - " + dumbItem.getName());
        }
    }
}
