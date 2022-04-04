import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bag {
    Map<Tile, Integer> tiles;
    int defaultQuantity;

    public Bag(Map<Tile, Integer> tiles, int defaultQuantity) {
        this.tiles = tiles;
        this.defaultQuantity = defaultQuantity;
    }

    public Bag(int defaultQuantity) {
        Random rand = new Random();
        this.tiles = new HashMap<>();
        this.defaultQuantity = defaultQuantity;
        for(char letter = 'a'; letter <= 'z'; letter++){
            tiles.put(new Tile(letter, rand.nextInt(10)+1), defaultQuantity);
        }
    }

    public Map<Tile, Integer> getTiles() {
        return tiles;
    }

    public void setTiles(Map<Tile, Integer> tiles) {
        this.tiles = tiles;
    }

    public int getDefaultQuantity() {
        return defaultQuantity;
    }

    public void setDefaultQuantity(int defaultQuantity) {
        this.defaultQuantity = defaultQuantity;
    }
}
