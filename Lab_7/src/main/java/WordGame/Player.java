package WordGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Player {
    private int gameId;
    private String name;
    private int score;
    private List<Tile> letters;
    private Board board;
    public boolean playerPassedOnce = false;
    public boolean playerPassedTwice = false;

    public Player(String name, int score, List<Tile> letters) {
        this.name = name;
        this.score = score;
        this.letters = letters;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.letters = new ArrayList<>();
    }

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        this.letters = new ArrayList<>();
    }

    // Setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Tile> getLetters() {
        return letters;
    }

    public void setLetters(List<Tile> letters) {
        this.letters = letters;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    // Game logic
    private boolean needsExtraction() {
        if (this.letters.size() < 7) return true;
        return false;
    }

    private void showTiles() {
        System.out.print(getName() + " tiles: ");
        for (Tile parser : letters) {
            System.out.print(parser.getTileName() + " ");
        }
        System.out.println();
    }

    public void extractTiles(int numberOfTiles) {
        Random random = new Random();
        int extracted = 0;

        while (extracted < numberOfTiles) {
            int index = random.nextInt(board.getBag().getTileNumber().size());
            while (!board.getBag().isTileAvailable(index)) {
                index = random.nextInt(board.getBag().getTileNumber().size());
            }
            letters.add(board.getBag().giveTile(index));
            extracted++;
        }

        showTiles();
    }

    private int checkLetterInTiles(char letter) {
        int index = 0;
        for (Tile iterator : letters) {
            if (iterator.getTileName() == letter) return index;
            index++;
        }
        return -1;
    }

    private int checkLetterInList(char letter, List<Tile> list) {
        int index = 0;
        for (Tile iterator : list) {
            if (iterator.getTileName() == letter) return index;
            index++;
        }
        return -1;
    }

    public boolean playWord(String word) {
        if (word.length() > letters.size()) return false;
        word = word.toUpperCase();
        int lastIndex = 0;
        List<Tile> resultTileList = new ArrayList<>(letters);
        for (int index = 0; index < word.length(); index++) {
            lastIndex = checkLetterInList(word.charAt(index), resultTileList);
            if (lastIndex == -1) return false;
            resultTileList.remove(lastIndex);
        }
        letters = resultTileList;
        return true;
    }

    public String tilesToString(){
        String result = new String();
        for(Tile iterator : letters){
            result += iterator.getTileName();
            result += ' ';
        }
        return result;
    }

    public void restoreTileNumber(){
        int requiredTiles = 7 - letters.size();
        int totalTiles = board.getBag().tilesInTotal();
        if( totalTiles >= requiredTiles){
            extractTiles(requiredTiles);
        }
        else{
            extractTiles(totalTiles);
        }
    }

    public int validateMove(String move){
        move.replaceAll("\\s","");
        move.toUpperCase();
        if(move == ":PASS"){
            return 1;
        }
        return 0;
    }
}
