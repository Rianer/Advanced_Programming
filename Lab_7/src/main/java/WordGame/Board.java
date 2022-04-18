package WordGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Player, String> boardTiles;
    private Bag bag;
    private List<Player> playerList;
    private int currentPlayer;

    public Board(Map<Player, String> boardTiles, Bag bag, List<Player> playerList, int currentPlayer) {
        this.boardTiles = boardTiles;
        this.bag = bag;
        this.playerList = playerList;
        this.currentPlayer = currentPlayer;
    }

    public Board(Bag bag) {
        this.boardTiles = new HashMap<>();
        this.bag = bag;
        this.playerList = new ArrayList<>();
        this.currentPlayer = 0;
    }

    public Map<Player, String> getBoardTiles() {
        return boardTiles;
    }

    public void setBoardTiles(Player player, String tiles){
        boardTiles.put(player, tiles);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void addPlayer(Player newPlayer){
        playerList.add(newPlayer);
        newPlayer.setGameId(playerList.size()-1);
    }

    public void setBoardTilesForPlayer(Player player, String tiles){
        this.boardTiles.put(player, tiles);
    }


}
