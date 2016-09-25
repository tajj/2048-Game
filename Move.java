/**
 * The Move Class is called to engage user input and output the gameboard after each movement,
 * with a random number.
 * 
 * Taylor & Gillian
 * Nov 17, 2015
 */
import java.util.Scanner;
import java.util.Random;
import java.lang.Object;
public class Move
{
    GameBoard b1 = new GameBoard();
    Random r = new Random();
    boolean done=true;
    
  public Move(){
       
      while(done==true){
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
        
            //assigns keys to up down left and right methods
            if (input.equalsIgnoreCase ("w")){
                movingup();
                done=true;
            }
            else if (input.equalsIgnoreCase("d")){
                movingright();
                done=true;
            }
            else if (input.equalsIgnoreCase("a")){
                movingleft();
                done=true;
            }
            else if (input.equalsIgnoreCase("s")){
                movingdown();
                done=true;
            } 
            else if (input.equalsIgnoreCase("stop")){
                System.out.println("Thanks for Playing!!");
                
            }else{
                System.out.println("Please input 'w,' 'a,' 's' or 'd.'");
            }
            
            if (input.equalsIgnoreCase("d") || input.equalsIgnoreCase ("w") || input.equalsIgnoreCase ("a") || input.equalsIgnoreCase ("s")){
            random(); 
            b1.printBoard();
      
            //Checks if game is over
            int count=0;
      for (int j = 0; j < 3; j++){
          for (int i = 0; i < 3; i++){
              if (b1.board[i][j]!= 0 && b1.board[i][j]!=b1.board[i+1][j] && b1.board[i][j]!=b1.board[i][j+1]){
                  count++;
                }
            }
        }
      for (int j= 0; j < 3; j++){
          if (b1.board[3][j]!= 0 && b1.board[3][j] != b1.board[3][j+1]){
              count++;
            }
        }
      for (int i = 0; i<3; i++){
          if (b1.board[i][3]!= 0 && b1.board[i][3]!=b1.board[i+1][3]){
              count++;
            }
        }
      if (count >= 15){
          System.out.println("Game Over");
        }
     }
   }

          }
        
        /**
     * Randomly prints a new number two on the board 
     */
  public int[][] random()
  {
       int cont = 1;
       for (int j = 0; j < 4; j++){
          for (int i = 0; i < 4; i++){
              if (b1.board[i][j] == 0){
                  while (cont == 1){
                      //picks a random spot
                      int a = r.nextInt(4);
                      int b = r.nextInt(4);
                      // if that spot has a value of 0, reassign the value to 2
                      if (b1.board[a][b] == 0){
                          b1.board[a][b] = 2;
                          cont = 2;
                        }
                }
            }
            if (b1.board[i][j] == 2048){
                System.out.println("Congratulations!!!! YOU WIN!");
            }
        }
        }
    return b1.board;
}
        
   public boolean movingup(){
            System.out.println("Moving Up!");
            boolean moved = false;
            boolean again;
            //loops check through each spot in the matrix and do-while repeats the checking for each spot so that a number can move more than once in one play
        for(int j = 0; j < 4; j++){
            do{
                again=true;
                for(int i = 0; i < 4; i++){
                    if((i < 3) && b1.board[i+1][j] != 0 ){ 
                            //adds two numbers if they are equal
                            if(b1.board[i][j] == b1.board[i+1][j])
                                {
                                    b1.board[i][j]+=b1.board[i+1][j];
                                    b1.board[i+1][j] = 0;
                                    moved = true;
                                }
                            }
                        }
                for(int i = 0; i < 4; i++){
                    if((i < 3) && b1.board[i+1][j] != 0 ){  
                            //if the spot is not on the top or bottom row and has a value of 0, the number below it can be shifted up
                            if (i > 0 && b1.board[i][j] == 0)
                            {
                                b1.board[i][j] = b1.board[i+1][j];
                                b1.board[i+1][j]= 0;
                                again =false;
                                moved = true;
                            }
                            //if the spot is on the top row, and has a value of 0, the number below it can be shifted up
                            if (i == 0 && b1.board[i][j] ==0)
                            {
                                b1.board[i][j] = b1.board[i+1][j];
                                b1.board[i+1][j]=0;
                                moved = true;
                            }
                    }
                }
            }while(!again);
        }
            
        return moved;
    }

    public boolean movingdown(){
            System.out.println("Moving Down!");
            boolean moved = false;
            boolean again;
            //loops check through each spot in the matrix and do-while repeats the checking for each spot so that a number can move more than once in one play
           do{
                again=true;
                for(int j = 3; j > -1; j--){
                    for(int i = 3; i > -1; i--){
                        if ((i < 3) && b1.board[i][j] != 0){
                            //shifts a number down if there is an empty spot below it and  it is not on the bottom row
                            if (b1.board[i+1][j] == 0){
                                b1.board[i+1][j] = b1.board[i][j];
                                b1.board[i][j] = 0;
                                moved = true;
                                again = false;
                        
                            }
                            //adds two of the same number if the numbers are not on the bottom row
                            if (b1.board[i+1][j] == b1.board[i][j]){
                                b1.board[i+1][j] += b1.board[i][j];
                                b1.board[i][j] = 0;
                                moved = true;
                        
                            }
                        }
                        //shifts a number down to the bottom row
                        if (i == 3 && b1.board[i][j] == 0){
                            b1.board[i][j] = b1.board[i-1][j];
                            b1.board[i-1][j] = 0;
                            moved = true;
                    
                        }
                    }   
                }
            }while(!again);

            
        return moved;
    }

   public boolean movingright(){
            System.out.println("Moving Right!");
            boolean moved = false;
            boolean again;
            //loops check through each spot in the matrix and do-while repeats the checking for each spot so that a number can move more than once in one play
        for(int i = 0; i < 4; i++){
            do{
                again=true;
                for(int j = 3; j >-1; j--){
                    if((j >0) && b1.board[i][j-1] != 0 ){
                        if(b1.board[i][j] == b1.board[i][j-1] )
                            { //sums
                                b1.board[i][j]+= b1.board[i][j-1];
                                b1.board[i][j-1] = 0;
                                moved = true;
                                again=false;
                            }
                        if (b1.board[i][j] == 0){
                            b1.board[i][j] = b1.board[i][j-1];
                            b1.board[i][j-1] = 0;
                            moved = true;
                            again = false;
                        }
                    }
                }
            }while(!again);
            
        }
    
            
        return moved;
    }
    public boolean movingleft(){
            System.out.println("Moving Left!");
            boolean moved = false;
            boolean again;
        for(int i = 0; i < 4; i++){
            do{
                again=true;
                for(int j = 0; j <4; j++){
                    if((j <3) && b1.board[i][j+1] != 0 ){ 
                    
                        if(b1.board[i][j] == b1.board[i][j+1])
                            {b1.board[i][j]+=b1.board[i][j+1];
                            b1.board[i][j+1] = 0;
                            moved = true;
                            again=false;
                            }
                        if (b1.board[i][j] == 0)
                        {   b1.board[i][j] = b1.board[i][j+1];
                            b1.board[i][j+1]= 0;
                            again =false;
                            moved = true;
                        }
                       
                    }
                     
                }
            }while(!again);
           
        }
         
               
        return moved;
    }
    
}
