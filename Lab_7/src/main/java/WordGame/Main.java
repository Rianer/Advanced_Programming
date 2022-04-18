package WordGame;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner myScanner = new Scanner(System.in);
        Bag myBag = new Bag();
        Board gameBoard = new Board(myBag);
        Player player1 = new Player("Adrian", gameBoard);
        gameBoard.addPlayer(player1);
        System.out.println("Player id: " + player1.getGameId());
        String playerMove;

        while(!player1.playerPassedTwice){
            System.out.println("New turn!");
            player1.restoreTileNumber();
            playerMove = myScanner.nextLine();
            if(player1.validateMove(playerMove) == 1){
                if(player1.playerPassedOnce){
                    player1.playerPassedTwice = true;
                }
                else{
                    player1.playerPassedOnce = true;
                }
            }
            else{
                if(player1.playWord(playerMove)){

                }
            }
        }

    }
}
