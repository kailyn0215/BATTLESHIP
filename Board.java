import java.util.Scanner;

public class Board
{
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5}; // or new int[5]

    char[][] gameBoard = new char[numRows][numCols];

    public void printBoard(boolean start)
    {
        //gameBoard[3][3] = 1;
        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                if(start)
                {
                    gameBoard[r][c] = '~';
                }
                System.out.print(gameBoard[r][c] + " ");
            }
            System.out.print("\n");
        }
    }

    public void getBoard(boolean start)
    {
        Scanner scan = new Scanner(System.in);
        if(start)
        {
            System.out.println("Please start placing your ships.\nDestroyer (2 pegs)\n Peg 1 Row:");
            
        }
    }

    public void setBoard()
    {

    }
    
}
