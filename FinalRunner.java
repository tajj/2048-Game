
/**
 * Runs the game.
 * 
 * Taylor & Gillian
 * Nov 17th, 2015
 */
import java.util.Scanner;
public class FinalRunner
{
   public static void main (String[] args){
       System.out.println("Welcome to 2048. \nUse your keys to move the tiles. \n'W' moves the tile up.\n'A' moves the tile left. \n'S' moves the tile down. \n'D' moves the tile right. \nWhen two tiles with the same number touch, they add and merge into one.\nAfter each move, a new number 2 will randomly appear on the board. \nTry your best to reach the highest score possible.\n");
       GameBoard gb = new GameBoard();
       gb.print();
    }
}
