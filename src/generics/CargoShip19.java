package generics;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by qinbingbing on 2/6/16.
 */
class Item {
    private final int id;
    private String description;
    private String destination;
    private double price;
    public Item(int idNumber, String what, String whereTo, double price) {
        id = idNumber;
        description = what;
        description = whereTo;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ", " + description + ", " + "$" + price
                + ", to:" + description;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Item> generator = new Generator<Item>() {
        private Random rand = new Random();
        @Override
        public Item next() {
            return new Item(rand.nextInt(1000),
                    "Very nice...",
                    "Destination: ...",
                    Math.round(rand.nextDouble() * 1000.0));
        }
    };
}

class Shelf19 extends ArrayList<Item> {
    public Shelf19(int nItems) {
        Generators.fill(this, Item.generator, nItems);
    }
}

class StorageArea extends ArrayList<Shelf19> {
    public StorageArea(int nShelves, int nItems) {
        for (int i = 0; i < nShelves; i++)
            add(new Shelf19(nItems));
    }
}

class Deck extends ArrayList<StorageArea> {
    public Deck(int nStorageAreas, int nShelves, int nItems) {
        for (int i = 0; i < nStorageAreas; i++)
            add(new StorageArea(nShelves, nItems));
    }
}

class Office19 {}

public class CargoShip19 extends ArrayList<Deck> {
    private Office19 office19;
    public CargoShip19(int nDecks, int nStorageAreas, int nShelves, int nItems) {
        for (int i = 0; i < nDecks; i++)
            add(new Deck(nStorageAreas, nShelves, nItems));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Deck d : this)
            for (StorageArea sa : d)
                for (Shelf19 s : sa)
                    for (Item i : s)
                        result.append(i).append("\n");
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip19(3, 4, 3, 10));
    }
}
