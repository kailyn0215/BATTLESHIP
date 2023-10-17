import java.util.Scanner;

public class Board
{
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5}; // or new int[5]

    int destroyer = 0 ; // 2 hp
    int submarine = 0; // 3 hp
    int crusier = 0; // 3 hp
    int battleship = 0; // 4 hp
    int carrier = 0; // 5 hp

    // need 17 hits to win the game
    int hits1 = 0; // p1
    int hits2 = 0; // p2
    int hitsc = 0; // computer

    boolean end;

    char[][] gameBoard = new char[numRows][numCols]; // makes a new game board based off of the number of columns and number of rows
    char[][] guessBoard = new char[numRows][numCols]; // duplicate board but doesnt show the boats to allow other player to guess
    char[][] tracker = new char[numRows][numCols]; // keeps track of diff ships maybe ??? cant quite figure out how to do that yet


    public void printBoard(boolean start, int numCols, int numRows, boolean guess) // prints the board and sets up default if new game+
    {
        //gameBoard[3][3] = 1;
        if(numCols == 10)
        {
            System.out.print("   0  1  2  3  4  5  6  7  8  9"); // adds ten rows if normal sized board
        }
        else
        {
            System.out.print("   0  1  2  3  4  5  6  7"); // adds 8 rows for fast game
        }
        
        if(!guess)
        {
           for(int r = 0; r < numRows; r++)
            {
                System.out.print("\n" + r + "  ");
                for(int c = 0; c < numCols; c++)
                {
                    if(start)
                    {
                        gameBoard[r][c] = '~';
                        guessBoard[r][c] = '~';
                    }
                    System.out.print(gameBoard[r][c] + "  ");
                }
            } 
        }
        else if(guess)
        {
            for(int r = 0; r < numRows; r++)
            {
                System.out.print("\n" + r + "  ");
                for(int c = 0; c < numCols; c++)
                {
                    System.out.print(guessBoard[r][c] + "  ");
                }
            } 
        }
        
    }


    public void setBoardManual() //uses user input to set up ships
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
                while(gameBoard[row][col] == '@' && row > 10 && col > 10);
                gameBoard[row][col] = '@';
                tracker[row][col] = 'd';
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
                while(gameBoard[row][col] == '@' && row > 10 && col > 10);
                gameBoard[row][col] = '@';
                tracker[row][col] = 's';
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
                while(gameBoard[row][col] == '@' && row > 10 && col > 10);
                gameBoard[row][col] = '@';
                tracker[row][col] = 'c';
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
                while(gameBoard[row][col] == '@' && row > 10 && col > 10);
                gameBoard[row][col] = '@';
                tracker[row][col] = 'b';
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
                while(gameBoard[row][col] == '@' && row > 10 && col > 10);
                gameBoard[row][col] = '@';
                tracker[row][col] = 'r';
            }
    }

    //sets the board automatically
    public void setBoardAuto(boolean p, boolean m) // p - if its the player, m - if its fast mode (only first 3 ships)
    {
        // need to continue with the different ships + make it so that they dont collide with each other :( (just didnt have time to fill it out yet)

        int row = (int)(Math.random() * 10); // from 0 to 9
        int col = (int)(Math.random() * 10);
        double up = Math.random(); // up down left or right
        int srow;
        int scol;
        int max; // maximum row or col

        // destroyer
        if(m)
        {
            max = 7;
            while(gameBoard[row][col] == '@' || row > 7 || col > 7)
            {
                row = (int)(Math.random() * 10);
                col = (int)(Math.random() * 10);
            }
        }
        else
        {
            max = 10;
            while(gameBoard[row][col] == '@')
            {
                row = (int)(Math.random() * 10);
                col = (int)(Math.random() * 10);
            }
        }

        tracker[row][col] = 'd';
        if(p)
        {
            gameBoard[row][col] = '@';
        }

        if(up < 0.25) // down
        {
            if(m && col > max)
            {
                // need to add more here
            }
        }

        /*tracker[row][col] = 'd';
        if(p = true)
        {
            gameBoard[row][col] = '@';
        }

        if(up < 0.25) // up 1
        {
            if (col == 9) // unless on bottom of grid already
            {
                col = col--;
            }
            else
            {
                col = col++;
            }
            tracker[row][col] = 'd';
            if(p = true)
            {
                gameBoard[row][col] = '@';
            }
        }
        else if(up < 0.5) // down 1
        {
            if (col == 0) // unless on top of grid
            {
                col = col++;
            }
            else
            {
                col = col--;
            }
            tracker[row][col] = 'd';
            if(p = true)
            {
                gameBoard[row][col] = '@';
            }
        }
        else if(up < 0.75) // left 1
        {
            if (row == 0) // unless on left of grid
            {
                row = row++;
            }
            else
            {
                row = row--;
            }
            tracker[row][col] = 'd';
            if(p = true)
            {
                gameBoard[row][col] = '@';
            }
        }
        else // right 1
        {
            if (row == 0) // unless on right of grid
            {
                row = row--;
            }
            else
            {
                row = row++;
            }
            tracker[row][col] = 'd';
            if(p = true)
            {
                gameBoard[row][col] = '@';
            }
        }

        // submarine
        do
        {
            row = (int)(Math.random() * 10); // from 0 to 9
            col = (int)(Math.random() * 10);
            up = Math.random(); // up down left or right
        }
        while(tracker[row][col] == 'd' || tracker[row][col] == 'c' || tracker[row][col] == 'b' || tracker[row][col] == 'r' || tracker[row][col] == 's');
        
        tracker[row][col] = 's';
        if(p = true)
        {
            gameBoard[row][col] = '@';
        }

        for(int s = 0; s > 2; s++) //repeat 2x for 3 points
        {
            if(up < 0.25) // up 1
            {
                if (col == 8) // unless on bottom of grid already
                {
                    col = col--;
                }
                else
                {
                    col = col++;
                }
                tracker[row][col] = 's';
                if(p = true)
                {
                    gameBoard[row][col] = '@';
                }
            }
            else if(up < 0.5) // down 1
            {
                if (col == 1) // unless on top of grid
                {
                    col = col++;
                }
                else
                {
                    col = col--;
                }
                tracker[row][col] = 's';
                if(p = true)
                {
                    gameBoard[row][col] = '@';
                }
            }
            else if(up < 0.75) // left 1
            {
                if (row == 1) // unless on left of grid
                {
                    row = row++;
                }
                else
                {
                    row = row--;
                }
                tracker[row][col] = 's';
                if(p = true)
                {
                    gameBoard[row][col] = '@';
                }
            }
            else // right 1
            {
                if (row == 8) // unless on right of grid
                {
                    row = row--;
                }
                else
                {
                    row = row++;
                }
                tracker[row][col] = 's';
                if(p = true)
                {
                    gameBoard[row][col] = '@';
                }
            }
        }

        //crusier
        do
        {
            row = (int)(Math.random() * 10); // from 0 to 9
            col = (int)(Math.random() * 10);
            up = Math.random(); // up down left or right
        }
        while(tracker[row][col] == 'd' || tracker[row][col] == 'c' || tracker[row][col] == 'b' || tracker[row][col] == 'r' || tracker[row][col] == 's');
        
        tracker[row][col] = 'c';
        if(p = true)
        {
            gameBoard[row][col] = '@';
        }

        //battleship
        do
        {
            row = (int)(Math.random() * 10); // from 0 to 9
            col = (int)(Math.random() * 10);
            up = Math.random(); // up down left or right
        }
        while(tracker[row][col] == 'd' || tracker[row][col] == 'c' || tracker[row][col] == 'b' || tracker[row][col] == 'r' || tracker[row][col] == 's');
        
        tracker[row][col] = 'b';
        if(p = true)
        {
            gameBoard[row][col] = '@';
        }

        //carrier
        do
        {
            row = (int)(Math.random() * 10); // from 0 to 9
            col = (int)(Math.random() * 10);
            up = Math.random(); // up down left or right
        }
        while(tracker[row][col] == 'd' || tracker[row][col] == 'c' || tracker[row][col] == 'b' || tracker[row][col] == 'r' || tracker[row][col] == 's');
        
        tracker[row][col] = 'r';
        if(p = true)
        {
            gameBoard[row][col] = '@';
        } */
    }

    public void play()
    {
            guessPlayer();
            guessComp();
    }

    // allows the user to guess the opponents ships
    public void guessPlayer()
    {
        Scanner guess = new Scanner(System.in);
        System.out.print("\n\nPlease enter coordinates to guess where your opponents ships are located.\n\nRow: ");
        int gR = guess.nextInt();
        System.out.print("\n\nColumn: ");
        int gC = guess.nextInt();
        if(tracker[gR][gC] == 'd' || tracker[gR][gC] == 's' || tracker[gR][gC] == 'c' || tracker[gR][gC] == 'b' || tracker[gR][gC] == 'r') // need to make it so computer ships dont show the star
        {
            System.out.print("Hit!\n\n");
            gameBoard[gR][gC] = 'X';
            hits1++;
            if(tracker[gR][gC] == 'd')
            {
                destroyer++;
                hits1++;
            }
            else if(tracker[gR][gC] == 's')
            {
                submarine++;
                hits1++;
            }
            else if(tracker[gR][gC] == 's')
            {
                submarine++;
                hits1++;
            }
            else if(tracker[gR][gC] == 'c')
            {
                crusier++;
                hits1++;
            }
            else if(tracker[gR][gC] == 'b')
            {
                battleship++;
                hits1++;
            }
            else if(tracker[gR][gC] == 'r')
            {
                carrier++;
                hits1++;
            }
            // need to add something to keep track off what ship is hit
        }
        else 
        {
            System.out.print("Miss!\n\n");
            gameBoard[gR][gC] = 'O';
        }
        win();
    }    

    public void guessComp()
    {
        
    }

    public void win() // tells the user if they sink a ship or game ends
    {
        if(destroyer == 2)
        {
            System.out.print("You sank the destroyer!");
            destroyer = 0;
        }
        else if(submarine == 3)
        {
            System.out.print("You sank the submarine!");
            submarine = 0;
        }
        else if(crusier == 3)
        {
            System.out.print("You sank the crusier!");
            crusier = 0;
        }
        else if(battleship == 4)
        {
            System.out.print("You sank the battleship!");
            battleship = 0;
        }
        else if(carrier == 3)
        {
            System.out.print("You sank the carrier!");
            carrier = 0;
        }
        if(hits1 == 17)
        {
            System.out.println("Congrats! Player 1 wins!");
            end = true;
        }
        else if (hits2 == 17)
        {
            System.out.println("Congrats! Player 2 wins!");
            end = true;
        }
        else if (hitsc == 17)
        {
            System.out.println("Sorry! The computer wins!");
            end = true;
        }
    }
}
