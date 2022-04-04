package WordGame;

import java.util.Map;

public class Tile {
    char tileName;
    int tilePoints;

    public Tile(char tileName, int tilePoints) {
        this.tileName = tileName;
        this.tilePoints = tilePoints;
    }

    public char getTileName() {
        return tileName;
    }

    public void setTileName(char tileName) {
        this.tileName = tileName;
    }

    public int getTilePoints() {
        return tilePoints;
    }

    public void setTilePoints(int tilePoints) {
        this.tilePoints = tilePoints;
    }
}
