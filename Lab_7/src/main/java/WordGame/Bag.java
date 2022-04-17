package WordGame;

import java.util.*;

public class Bag {
    Map<Tile, Integer> tiles;

    public Bag(){ //default constructor for current instance of the game
        this.tiles = new HashMap<>();
        tiles.put(new Tile('A',1),9);
        tiles.put(new Tile('B',3),2);
        tiles.put(new Tile('C',3),2);
        tiles.put(new Tile('D',2),4);
        tiles.put(new Tile('E',1),12);
        tiles.put(new Tile('F',4),2);
        tiles.put(new Tile('G',2),3);
        tiles.put(new Tile('H',4),2);
        tiles.put(new Tile('I',1),9);
        tiles.put(new Tile('J',8),1);
        tiles.put(new Tile('K',5),1);
        tiles.put(new Tile('L',1),4);
        tiles.put(new Tile('M',3),2);
        tiles.put(new Tile('N',1),6);
        tiles.put(new Tile('O',1),8);
        tiles.put(new Tile('P',3),2);
        tiles.put(new Tile('Q',10),1);
        tiles.put(new Tile('R',1),6);
        tiles.put(new Tile('S',1),4);
        tiles.put(new Tile('T',1),6);
        tiles.put(new Tile('U',1),4);
        tiles.put(new Tile('V',4),2);
        tiles.put(new Tile('X',8),2);
        tiles.put(new Tile('Y',4),1);
        tiles.put(new Tile('W',4),2);
        tiles.put(new Tile('Z',10),1);
    }

    public Bag(Map<Tile, Integer> tiles) {
        this.tiles = tiles;
    }

    public Bag(int defaultQuantity) {
        Random rand = new Random();
        this.tiles = new HashMap<>();
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


}
