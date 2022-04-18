package WordGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player{
    private int gameId;
    private String name;
    private int score;
    private List<Tile> letters;
    private Board board;
    public boolean playerPassed = false;
    public boolean playerLeft = false;

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
        if(!board.getDictionary().getWords().contains(word)) return false;
        int score = 0;
        if (word.length() > letters.size()) return false;
        word = word.toUpperCase();
        int lastIndex = 0;
        List<Tile> resultTileList = new ArrayList<>(letters);
        for (int index = 0; index < word.length(); index++) {
            lastIndex = checkLetterInList(word.charAt(index), resultTileList);
            if (lastIndex == -1) return false;
            score += resultTileList.get(lastIndex).getTilePoints();
            resultTileList.remove(lastIndex);
        }
        this.score += score;
        letters = resultTileList;
        return true;
    }

    public String tilesToString() {
        String result = new String();
        for (Tile iterator : letters) {
            result += iterator.getTileName();
            result += ' ';
        }
        return result;
    }

    public void restoreTileNumber() {
        int requiredTiles = 7 - letters.size();
        int totalTiles = board.getBag().tilesInTotal();
        if (requiredTiles == 0) {
            ;
        } else if (totalTiles >= requiredTiles) {
            extractTiles(requiredTiles);
        } else {
            extractTiles(totalTiles);
        }
        board.setBoardTiles(this, tilesToString());
    }

    public int validateMove(String move) {
        move = move.replaceAll(" ", "");
        move = move.toUpperCase();
        System.out.println("You played " + move);
        if (move.compareTo(":PASS") == 0) {
            //board.getBag().placeTilesBack(tilesToString());
            letters.clear();
            restoreTileNumber();
            return 1;
        } else if (move.compareTo(":BAGTILES") == 0) {
            board.getBag().showTilesStatus();
            return 2;
        } else if (move.compareTo(":LEAVE") == 0) {
            playerLeft = true;
            return 3;
        } else {
            if (playWord(move)) {
                playerPassed = false;
                return 0;
            }
            return -1;
        }
    }
    private Player nextPlayer(){
        if(gameId == board.getPlayerList().size()-1){
            return board.getPlayerList().get(0);
        }
        else{
            return board.getPlayerList().get(gameId+1);
        }
    }

    public void beginGame(){
        String playerMove;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Player " + (gameId + 1) + ":");

        restoreTileNumber();
        if(!letters.isEmpty() && playerPassed) showTiles();
        playerMove = myScanner.nextLine();
        int moveId = validateMove(playerMove);
        while (moveId == -1 || moveId == 2){
            if(moveId == -1){
                System.out.println("Word not accepted!");
            }
            else if(moveId == 2){
                System.out.println("Make a move!");
                System.out.println("Your tiles: " + board.getBoardTiles().get(this));
            }
            playerMove = myScanner.nextLine();
            moveId = validateMove(playerMove);
        }
        if(moveId == 1){
            playerPassed = true;
            board.cyclePlayer();

        }
        else if(moveId == 0){
            System.out.println("Word accepted!");
            System.out.println("Current score: " + getScore());
            board.cyclePlayer();


        }
        else if(moveId == 3){
            board.setGameEnded(true);
        }
    }

    @Override
    public String toString() {
        return name + " : " + score + " points";
    }
}
