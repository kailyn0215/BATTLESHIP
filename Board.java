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
        System.out.print("   0  1  2  3  4  5  6  7  8  9");
        for(int r = 0; r < numRows; r++)
        {
            System.out.print("\n" + r + "  ");
            for(int c = 0; c < numCols; c++)
            {
                if(start)
                {
                    gameBoard[r][c] = '~';
                }
                System.out.print(gameBoard[r][c] + "  ");
            }
        }
    }

    public void setBoardPlayer()
    {
        int row;
        int col;

        Scanner scan = new Scanner(System.in);

            //destroyer
            System.out.print("\nPlease start placing your ships.\n\nDestroyer (2 pegs)");
            for(int d = 1; d < 3; d++)
            {
                System.out.print("\nPeg " + d + " Row: ");
                row = scan.nextInt();
                System.out.print("\nPeg " + d + " Collumn: ");
                col = scan.nextInt();
                gameBoard[row][col] = '★';
            }
            
            //sub
            System.out.print("\n\nSubmarine (3 pegs)");
            for(int s = 1; s < 4; s++)
            {
                System.out.print("\nPeg " + s + " Row: ");
                row = scan.nextInt();
                System.out.print("\nPeg " + s + " Collumn: ");
                col = scan.nextInt();
                gameBoard[row][col] = '★';
            }

            //crusier
            System.out.print("\n\nCrusier (3 pegs)");
            for(int c = 1; c < 4; c++)
            {
                System.out.print("\nPeg " + c + " Row: ");
                row = scan.nextInt();
                System.out.print("\nPeg " + c + " Collumn: ");
                col = scan.nextInt();
                gameBoard[row][col] = '★';
            }

            //battleship
            System.out.print("\n\nBattleship (4 pegs)");
            for(int b = 1; b < 5; b++)
            {
                System.out.print("\nPeg " + b + " Row: ");
                row = scan.nextInt();
                System.out.print("\nPeg " + b + " Collumn: ");
                col = scan.nextInt();
                gameBoard[row][col] = '★';
            }

            //carrier
            System.out.print("\n\nCarrier (5 pegs)");
            for(int r = 1; r < 6; r++)
            {
                System.out.print("\nPeg " + r + " Row: ");
                row = scan.nextInt();
                System.out.print("\nPeg " + r + " Collumn: ");
                col = scan.nextInt();
                gameBoard[row][col] = '★';
            }
    }

    public void setBoardComputer()
    {

    }
    
}
