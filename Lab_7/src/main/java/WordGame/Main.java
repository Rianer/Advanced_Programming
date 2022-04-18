package WordGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String args[]) {
        Scanner myScanner = new Scanner(System.in);
        Bag myBag = new Bag();
        Board gameBoard = new Board(myBag);
        int playerNumber = 0;
        System.out.println("How many players?");
        playerNumber = myScanner.nextInt();
        myScanner = new Scanner(System.in);
        for (int iterator = 1; iterator <= playerNumber; iterator++) {
            System.out.print("Player " + iterator);
            System.out.println(" Give player name: ");
            String playerName = myScanner.nextLine();
            gameBoard.addPlayer(new Player(playerName, gameBoard));
        }
        gameBoard.playerThreads = new ArrayList<>();
        for(int iterator = 0; iterator < playerNumber; iterator++){
            gameBoard.playerThreads.add(new Thread(gameBoard.getPlayerList().get(iterator)));
        }
        gameBoard.playerThreads.get(gameBoard.getCurrentPlayer()).start();



        /*Thread object = new Thread(player1);
        object.start();*/
    }
}
