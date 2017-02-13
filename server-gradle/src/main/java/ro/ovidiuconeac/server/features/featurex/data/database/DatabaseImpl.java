package ro.ovidiuconeac.server.features.featurex.data.database;

import ro.ovidiuconeac.server.features.featurex.models.Cheese;
import ro.ovidiuconeac.server.features.featurex.models.Fruit;
import ro.ovidiuconeac.server.features.featurex.models.Sweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovidiu on 2/7/17.
 */

public final class DatabaseImpl implements Database {

    private static DatabaseImpl INSTANCE;

    private List<Fruit> fruits;
    private List<Cheese> cheeses;
    private List<Sweet> sweets;

    private DatabaseImpl() {
        initFruits();
        initCheeses();
        initSweets();
    }

    private void initSweets() {
        sweets = new ArrayList<Sweet>();
        sweets.add(new Sweet("Apple cake"));
        sweets.add(new Sweet("Avocado cake"));
        sweets.add(new Sweet("Babka"));
        sweets.add(new Sweet("Battenberg cake"));
        sweets.add(new Sweet("Bienenstic"));
        sweets.add(new Sweet("Cassata"));
        sweets.add(new Sweet("Cheesecake"));
        sweets.add(new Sweet("Cupcake"));
        sweets.add(new Sweet("Dacquoise"));
        sweets.add(new Sweet("Dobos cake"));
        sweets.add(new Sweet("Jaffa Cakes"));
        sweets.add(new Sweet("Makowiec"));
        sweets.add(new Sweet("Muffin"));
        sweets.add(new Sweet("Pancake"));
        sweets.add(new Sweet("Rum cake"));
    }

    public static DatabaseImpl getInstance() {
        if (DatabaseImpl.INSTANCE == null) {
            DatabaseImpl.INSTANCE = new DatabaseImpl();
        }
        return DatabaseImpl.INSTANCE;
    }

    private void initCheeses() {
        cheeses = new ArrayList<Cheese>();
        cheeses.add(new Cheese("Abondance"));
        cheeses.add(new Cheese("Allgauer Emmentaler"));
        cheeses.add(new Cheese("Banon"));
        cheeses.add(new Cheese("Beaufort"));
        cheeses.add(new Cheese("Bethmale"));
        cheeses.add(new Cheese("Brie"));
        cheeses.add(new Cheese("Cheddar"));
        cheeses.add(new Cheese("Emmental"));
        cheeses.add(new Cheese("Feta"));
        cheeses.add(new Cheese("Gorgonzola"));
        cheeses.add(new Cheese("Gouda"));
        cheeses.add(new Cheese("Munster"));
        cheeses.add(new Cheese("Roquefort"));
        cheeses.add(new Cheese("Stilton"));
        cheeses.add(new Cheese("Valancay"));
    }

    private void initFruits() {
        fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit("Apple"));
        fruits.add(new Fruit("Blackcurrant"));
        fruits.add(new Fruit("Cherries"));
        fruits.add(new Fruit("Feijoa"));
        fruits.add(new Fruit("Guava"));
        fruits.add(new Fruit("Honeydew Melon"));
        fruits.add(new Fruit("Java-Plum"));
        fruits.add(new Fruit("Lime"));
        fruits.add(new Fruit("Lychee"));
        fruits.add(new Fruit("Mulberries"));
        fruits.add(new Fruit("Prunes"));
        fruits.add(new Fruit("Rhubarb"));
        fruits.add(new Fruit("Strawberries"));
        fruits.add(new Fruit("Tangerine"));
        fruits.add(new Fruit("Watermelon"));
    }

    public Fruit getFruitById(int id) {
        return fruits.get(id);
    }

    public Cheese getCheeseById(int id) {
        return cheeses.get(id);
    }

    public Sweet getSweetById(int id) {
        return sweets.get(id);
    }
}
