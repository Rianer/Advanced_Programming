import java.util.List;

public class Dictionary {
    private List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public boolean validateWord(String word){
        return words.contains(word);
    }
}
