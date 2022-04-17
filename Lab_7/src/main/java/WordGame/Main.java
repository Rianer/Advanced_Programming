package WordGame;

public class Main {
    public static void main(String args[]){
        Bag myBag = new Bag();
        myBag.decreaseNumberOfTiles('A',5);
        System.out.println(myBag.getNumberOfTiles('A'));
    }
}
