/**
 * Sets up the board with the phenotypic structure and random values. 
 * 
 * Gillian & Taylor
 */
import java.util.Scanner;
public class GameBoard{
    
    static int [][] board=new int[4][4]; 
    public boolean gameover=false;

    /**
     * Constructor for objects of class TwentyFortyEightGameBoard
     */
    public GameBoard()
    {
    }
    /**
     * Prints the image of the board with two random twos and initiates the Move class
     */
    public void print()
    {
        int another = 1;
        randomTwos();
        printBoard();
        while (another == 1) //continue scanning for new moves
        {
            Move m = new Move();
        }
    }
    
  
   
    /**
     * Prints the image of the board
     */
    public void printBoard(){
        System.out.println("_____________________");
        System.out.println("|    |    |    |    |");
        //for loops used to cycle through each spot in the 4x4 matrix
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //below: if the spot in the matrix is not a 0, it will print that number in the spot on the board. If the spot is a 0, it will print a blank space instead of the number 0.
                if(board[i][j] != 0) {
                    System.out.print(String.format("|%4d", board[i][j]));
                }else{
                    System.out.print("|    ");
                }
            }
            System.out.println("|\n|    |    |    |    |");
            if(i != 3) {
                System.out.println("|____|____|____|____|");
                System.out.println("|    |    |    |    |");
            } else {
                System.out.println("_____________________");
            }
        }
    }
    /**
     * Populates board with two 2 values randomly
     **/
    private int[][] randomTwos(){
        //below: randomly selects the first spot on the board
        int i= (int)(Math.random()*4);
        int j=(int)(Math.random()*4);
        board[i][j]=2;//assigns the value 2 to that spot
        j=(int)(Math.random()*4);
        if (board[i][j] == 0){//for the second spot, it chooses amongst all the spots that have a value of 0
            board[i][j]=2;
            return board;
        }else {//if randomly selected spot on board already has a value other than 0, it will select another spot on the board randomly.
        i= (int)(Math.random()*4);
        j= (int)(Math.random()*4);
        board[i][j]=2;
        return board;
       }   
    } 
}
