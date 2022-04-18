package WordGame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Dictionary {
    private List<String> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

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

    public void readDictionary(){
        try {
            File myObj = new File("C:\\Documents\\Java\\Advanced_Programming\\Lab_7\\src\\main\\resources\\dictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.toUpperCase(Locale.ROOT);
                words.add(data);
            }
            myReader.close();
        }
        catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
