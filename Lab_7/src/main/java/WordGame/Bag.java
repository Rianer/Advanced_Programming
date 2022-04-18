package WordGame;

import java.util.*;

public class Bag {
    private List<Tile> tilePoints;
    private List<Integer> tileQuantity;

    public Bag(){ //default constructor for current instance of the game
        this.tilePoints = new ArrayList<>();
        this.tileQuantity = new ArrayList<>();
        tilePoints.add(new Tile('A',1));
        tilePoints.add(new Tile('B',3));
        tilePoints.add(new Tile('C',3));
        tilePoints.add(new Tile('D',2));
        tilePoints.add(new Tile('E',1));
        tilePoints.add(new Tile('F',4));
        tilePoints.add(new Tile('G',2));
        tilePoints.add(new Tile('H',4));
        tilePoints.add(new Tile('I',1));
        tilePoints.add(new Tile('J',8));
        tilePoints.add(new Tile('K',5));
        tilePoints.add(new Tile('L',1));
        tilePoints.add(new Tile('M',3));
        tilePoints.add(new Tile('N',1));
        tilePoints.add(new Tile('O',1));
        tilePoints.add(new Tile('P',3));
        tilePoints.add(new Tile('Q',10));
        tilePoints.add(new Tile('R',1));
        tilePoints.add(new Tile('S',1));
        tilePoints.add(new Tile('T',1));
        tilePoints.add(new Tile('U',1));
        tilePoints.add(new Tile('V',4));
        tilePoints.add(new Tile('X',8));
        tilePoints.add(new Tile('Y',4));
        tilePoints.add(new Tile('W',4));
        tilePoints.add(new Tile('Z',10));

        tileQuantity.add(9);
        tileQuantity.add(2);
        tileQuantity.add(2);
        tileQuantity.add(4);
        tileQuantity.add(12);
        tileQuantity.add(2);
        tileQuantity.add(3);
        tileQuantity.add(2);
        tileQuantity.add(9);
        tileQuantity.add(1);
        tileQuantity.add(1);
        tileQuantity.add(4);
        tileQuantity.add(2);
        tileQuantity.add(6);
        tileQuantity.add(8);
        tileQuantity.add(2);
        tileQuantity.add(1);
        tileQuantity.add(6);
        tileQuantity.add(4);
        tileQuantity.add(6);
        tileQuantity.add(4);
        tileQuantity.add(2);
        tileQuantity.add(2);
        tileQuantity.add(1);
        tileQuantity.add(2);
        tileQuantity.add(1);
    }

    public List<Tile> getTilePoints() {
        return tilePoints;
    }

    public void setTilePoints(List<Tile> tilePoints) {
        this.tilePoints = tilePoints;
    }

    public List<Integer> getTileNumber() {
        return tileQuantity;
    }

    public void setTileNumber(List<Integer> tileQuantity) {
        this.tileQuantity = tileQuantity;
    }

    public Tile getTileByName(char letter){
        return tilePoints.stream().filter(t -> t.getTileName()==letter).findFirst().orElse(null);
    }

    public void decreaseNumberOfTiles(char letter, int quantity){
        int tileIndex = tilePoints.indexOf(getTileByName(letter));
        int currentQuantity = tileQuantity.get(tileIndex);
        tileQuantity.set(tileIndex, currentQuantity - quantity);
    };

    public int getNumberOfTiles(char letter){
        int tileIndex = tilePoints.indexOf(getTileByName(letter));
        return tileQuantity.get(tileIndex);
    }

    public boolean isTileAvailable(int index){
        if(tileQuantity.get(index) >= 1) return true;
        return false;
    }

    public Tile giveTile(int index){
        int currentQuantity = tileQuantity.get(index);
        tileQuantity.set(index, currentQuantity-1);
        return tilePoints.get(index);
    }

    public int tilesInTotal(){
        int sum = 0;
        for(int iterator : tileQuantity){
            sum += iterator;
        }
        return sum;
    }
}
