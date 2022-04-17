package WordGame;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return tileName == tile.tileName;
    }
}
