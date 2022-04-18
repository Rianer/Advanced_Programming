package WordGame;

import java.util.*;

public class Board {
    private Map<Player, String> boardTiles;
    private Bag bag;
    private Dictionary dictionary;
    private List<Player> playerList;
    private int currentPlayer = 0;
    private boolean gameEnded = false;

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

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void addPlayer(Player newPlayer){
        playerList.add(newPlayer);
        newPlayer.setGameId(playerList.size()-1);
    }

    public void cyclePlayer(){
        currentPlayer++;
        if(currentPlayer == playerList.size()) currentPlayer = 0;
    }

    public void setBoardTilesForPlayer(Player player, String tiles){
        this.boardTiles.put(player, tiles);
    }

    public void showGameResults(){
        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p1.getScore() - p2.getScore();
            }
        });
        System.out.println(playerList);
        System.out.println("Winner: " + playerList.get(playerList.size()-1).getName());
    }
}
