import java.util.Scanner;

public class Board
{
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5}; // or new int[5]

    boolean[][] destroyer;
    boolean[][] submarine;
    boolean[][] crusier;
    boolean[][] battleship;
    boolean[][] carrier;


    char[][] gameBoard = new char[numRows][numCols];


    //prints the board and sets up default if new game+
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


    //uses user input to set up ships
    public void setBoardManual()
    {
        int row;
        int col;

        Scanner scan = new Scanner(System.in);

            //destroyer
            System.out.print("\n\n\nPlease start placing your ships.\n\nDestroyer (2 pegs)");
            for(int d = 1; d < 3; d++)
            {
                do
                {
                    System.out.print("\nPeg " + d + " Row: ");
                    row = scan.nextInt();
                    System.out.print("\nPeg " + d + " Column: ");
                    col = scan.nextInt();
                }
                while(gameBoard[row][col] == '★' && row > 10 && col > 10);
                gameBoard[row][col] = '★';
            }
            
            //sub
            System.out.print("\n\nSubmarine (3 pegs)");
            for(int s = 1; s < 4; s++)
            {
                do
                {
                    System.out.print("\nPeg " + s + " Row: ");
                    row = scan.nextInt();
                    System.out.print("\nPeg " + s + " Column: ");
                    col = scan.nextInt();
                }
                while(gameBoard[row][col] == '★' && row > 10 && col > 10);
                gameBoard[row][col] = '★';
            }

            //crusier
            System.out.print("\n\nCrusier (3 pegs)");
            for(int c = 1; c < 4; c++)
            {
                do
                {
                    System.out.print("\nPeg " + c + " Row: ");
                    row = scan.nextInt();
                    System.out.print("\nPeg " + c + " Column: ");
                    col = scan.nextInt();
                }
                while(gameBoard[row][col] == '★');
                gameBoard[row][col] = '★';
            }

            //battleship
            System.out.print("\n\nBattleship (4 pegs)");
            for(int b = 1; b < 5; b++)
            {
                do
                {
                    System.out.print("\nPeg " + b + " Row: ");
                    row = scan.nextInt();
                    System.out.print("\nPeg " + b + " Column: ");
                    col = scan.nextInt();
                }
                while(gameBoard[row][col] == '★');
                gameBoard[row][col] = '★';
            }

            //carrier
            System.out.print("\n\nCarrier (5 pegs)");
            for(int r = 1; r < 6; r++)
            {
                do
                {
                    System.out.print("\nPeg " + r + " Row: ");
                    row = scan.nextInt();
                    System.out.print("\nPeg " + r + " Column: ");
                    col = scan.nextInt();
                }
                while(gameBoard[row][col] == '★');
                gameBoard[row][col] = '★';
            }
    }


    //sets the board automatically
    public void setBoardAuto()
    {
        //destroyer:
        int row = (int)(Math.random() * 10); // from 0 to 9
        int col = (int)(Math.random() * 10);
        double up = Math.random(); // up down left or right

        destroyer[row][col] = true;
        if(up < 0.25)
        {
            destroyer[row - 1][col] = true; // adds second point to the left if less than 0.26
        }
        else if(up < 0.5)
        {
            destroyer[row + 1][col] = true; // adds second point to the right if less than 0.26
        }
        else if(up < 0.75)
        {
            destroyer[row][col + 1] = true; // adds second point up one if less than 0.26
        }
        else
        {
            destroyer[row][col - 1] = true;
        }
    }

    public void guessManual()
    {
        Scanner guess = new Scanner()
        System.out.print("\n\nPlease enter coordinates to guess where your opponents ships are located.\n\nRow: ");

    }
    
}
