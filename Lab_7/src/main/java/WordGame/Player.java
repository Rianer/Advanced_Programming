package WordGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<Tile> letters;

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

    public void getTiles(Bag bag, int numberOfTiles){
        bag.provideTiles(numberOfTiles);
    }

    public boolean submitWord(String word){
        for(int index = 0; index < word.length(); index++){
            char letter = word.charAt(index);
            if(letters.contains(new Tile(letter, 5))){
                //implement elimination of letter from reserve
            }
            else{
                return false;
            }
        }
        return true;
    }
}
