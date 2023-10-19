import java.util.Scanner;
import java.util.Random;

public class Board
{
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5}; // or new int[5]

    int pRows;
    int pCols;

    int destroyer = 0 ; // 2 hp
    int submarine = 0; // 3 hp
    int crusier = 0; // 3 hp
    int battleship = 0; // 4 hp
    int carrier = 0; // 5 hp

    int destroyer2 = 0 ; // 2 hp
    int submarine2 = 0; // 3 hp
    int crusier2 = 0; // 3 hp
    int battleship2 = 0; // 4 hp
    int carrier2 = 0; // 5 hp

    // need 17 hits to win the game
    int hits1 = 0; // p1
    int hits2 = 0; // p2

    boolean p1; // p1 wins
    boolean p2; // p2 wins

    char[][] gameBoard1 = new char[numRows][numCols]; // makes a new game board based off of the number of columns and number of rows
    char[][] gameBoard2 = new char[numRows][numCols];
    char[][] guessBoard1 = new char[numRows][numCols];
    char[][] guessBoard2 = new char[numRows][numCols]; // duplicate board but doesnt show the boats to allow other player to guess
    char[][] tracker1 = new char[numRows][numCols];
    char[][] tracker2 = new char[numRows][numCols]; // keeps track of diff ships maybe ??? cant quite figure out how to do that yet

    // prints the board of the player, prints guess board, + initializes new boards
    public void printBoard(boolean start, int numCols, int numRows, int player, boolean guess)
    {
        //gameBoard[3][3] = 1;
        if(start) // makes perm cols and rows so if input changes board doesnt break
        {
            pCols = numCols;
            pRows = numRows;
        }

        if(pCols == 10)
        {
            System.out.print("   0  1  2  3  4  5  6  7  8  9"); // adds ten rows if normal sized board
        }
        else
        {
            System.out.print("   0  1  2  3  4  5  6  7"); // adds 8 rows for fast game
        }
        
        if(!guess) // if its not a guess board
        {
           for(int r = 0; r < pRows; r++)
            {
                System.out.print("\n" + r + "  ");
                for(int c = 0; c < pCols; c++)
                {
                    if(start) // if is the beginning create board
                    { 
                        if(player == 1)
                        {
                            gameBoard1[r][c] = '~';
                            guessBoard1[r][c] = '~';
                            tracker1[r][c] = '~';
                        }
                        else
                        {
                            gameBoard2[r][c] = '~';
                            guessBoard2[r][c] = '~';
                            tracker2[r][c] = '~';
                        }                        
                    }
                    if(player == 1)
                    {
                        System.out.print(gameBoard1[r][c] + "  ");
                    }
                    else
                    {
                        System.out.print(gameBoard2[r][c] + "  ");
                    }                   
                }
            } 
        }

        else // guess board
        {
            for(int r = 0; r < pRows; r++)
            {
                System.out.print("\n" + r + "  ");
                for(int c = 0; c < pCols; c++)
                {
                    if(start) // if is the beginning create board
                    { 
                        if(player == 1)
                        {
                            gameBoard1[r][c] = '~';
                            guessBoard1[r][c] = '~';
                            tracker1[r][c] = '~';
                        }
                        else
                        {
                            gameBoard2[r][c] = '~';
                            guessBoard2[r][c] = '~';
                            tracker2[r][c] = '~';
                        }                        
                    }
                    if(player == 1)
                    {
                        System.out.print(guessBoard1[r][c] + "  ");
                    }
                    else
                    {
                        System.out.print(guessBoard2[r][c] + "  ");
                    }
                }
            }        
        }
    }
        
    

    // lets the user set the ships manually
    public void setBoardManual(int player)
    {
        int row;
        int col;

        Scanner scan = new Scanner(System.in);

            //destroyer
            System.out.print("\n\n\nPlease start placing your ships.\n\nDestroyer (2 pegs)");
            for(int d = 1; d < 3; d++)
            {
                if(player == 1)
                {
                    do
                    {
                        System.out.print("\nPeg " + d + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + d + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard1[row][col] == '@' && row > 10 && col > 10);
                    gameBoard1[row][col] = '@';
                    tracker1[row][col] = 'd';
                }
                else
                {
                    do
                    {
                        System.out.print("\nPeg " + d + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + d + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard2[row][col] == '@' && row > 10 && col > 10);
                    gameBoard2[row][col] = '@';
                    tracker2[row][col] = 'd';
                }   
            }
            
            //sub
            System.out.print("\n\nSubmarine (3 pegs)");
            for(int s = 1; s < 4; s++)
            {
                if(player == 1)
                {
                    do
                    {
                        System.out.print("\nPeg " + s + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + s + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard1[row][col] == '@' && row > 10 && col > 10);
                    gameBoard1[row][col] = '@';
                    tracker1[row][col] = 's';
                }
                else
                {
                    do
                    {
                        System.out.print("\nPeg " + s + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + s + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard2[row][col] == '@' && row > 10 && col > 10);
                    gameBoard2[row][col] = '@';
                    tracker2[row][col] = 's';
                }
            }

            //crusier
            System.out.print("\n\nCrusier (3 pegs)");
            for(int c = 1; c < 4; c++)
            {
                if(player == 1)
                {
                    do
                    {
                        System.out.print("\nPeg " + c + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + c + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard1[row][col] == '@' && row > 10 && col > 10);
                    gameBoard1[row][col] = '@';
                    tracker1[row][col] = 'c';
                }
                else
                {
                    do
                    {
                        System.out.print("\nPeg " + c + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + c + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard2[row][col] == '@' && row > 10 && col > 10);
                    gameBoard2[row][col] = '@';
                    tracker2[row][col] = 'c';
                }
            }

            //battleship
            System.out.print("\n\nBattleship (4 pegs)");
            for(int b = 1; b < 5; b++)
            {
                if(player == 1)
                {
                    do
                    {
                        System.out.print("\nPeg " + b + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + b + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard1[row][col] == '@' && row > 10 && col > 10);
                    gameBoard1[row][col] = '@';
                    tracker1[row][col] = 'b';
                }
                else
                {
                    do
                    {
                        System.out.print("\nPeg " + b + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + b + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard2[row][col] == '@' && row > 10 && col > 10);
                    gameBoard2[row][col] = '@';
                    tracker2[row][col] = 'b';
                }
            }

            //carrier
            System.out.print("\n\nCarrier (5 pegs)");
            for(int r = 1; r < 6; r++)
            {
                if(player == 1)
                {
                    do
                    {
                        System.out.print("\nPeg " + r + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + r + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard1[row][col] == '@' && row > 10 && col > 10);
                    gameBoard1[row][col] = '@';
                    tracker1[row][col] = 'r';
                }
                else
                {
                    do
                    {
                        System.out.print("\nPeg " + r + " Row: ");
                        row = scan.nextInt();
                        System.out.print("\nPeg " + r + " Column: ");
                        col = scan.nextInt();
                    }
                    while(gameBoard2[row][col] == '@' && row > 10 && col > 10);
                    gameBoard2[row][col] = '@';
                    tracker2[row][col] = 'r';
                }
            }
    }

    //sets the board automatically
    public void setBoardAuto(int player, boolean m) // p - if its the player, m - if its fast mode (only first 3 ships)
    {
        // need to continue with the different ships + make it so that they dont collide with each other :( (just didnt have time to fill it out yet)

        int row = (int)(Math.random() * 10); // from 0 to 9
        int col = (int)(Math.random() * 10);
        Random random = new Random();
        boolean up = random.nextBoolean(); // vertical or horizontal

        int max; // maximum row or col
        String letters = "dscbr"; // destroyer, submarine, cruiser, battleship, carrier
        String fast = "dsc";
        int[] numbers = {2, 3, 3, 4, 5};
        int length = 0;

        int v = 0;
        int c = 0;

        // destroyer
        if(m)
        {
            max = 7;
            for(int f = 0; f < fast.length() - 1; f++)// goes thru the first 3 ships (2, 3, 3)
            {
                do
                {
                    up = random.nextBoolean();
                    row = (int)(Math.random() * 8); // chooses a random number between 0 - 7
                    col = (int)(Math.random() * 8);
                    /*for(int l = 0; l <= 5; l++) // if the point is surrounded
                    {
                        if(tracker2[row + 1][col] == letters.charAt(f) && up)
                        {
                            v++;
                        }
                        if(tracker2[row - 1][col] == letters.charAt(f) && up)
                        {
                            v++;
                        }
                        if(tracker2[row][col + 1] == letters.charAt(f) && !up)
                        {
                            c++;
                        }
                        if(tracker2[row][col - 1] == letters.charAt(f) && !up)
                        {
                            c++;
                        }
                    }*/
                }
                while(tracker2[row][col] == 'd' || tracker2[row][col] == 's' || tracker2[row][col] == 'c' || tracker2[row][col] == 'b' || tracker2[row][col] == 'r');
                tracker2[row][col] = letters.charAt(f);
                length = numbers[f]; // length of the current ship being placed
                if(up) // vertical
                {
                    if(col + length > max || tracker2[row][col + 1] == 'd' || tracker2[row][col + 1] == 's' || tracker2[row][col + 1] == 'c' || tracker2[row][col + 1] == 'b' || tracker2[row][col + 1] == 'r' || tracker2[row][col + 2] == 'd' || tracker2[row][col + 2] == 's' || tracker2[row][col + 2] == 'c' || tracker2[row][col + 2] == 'b' || tracker2[row][col + 2] == 'r')
                    {
                        for(int u = 1; u <= length; u++)
                        {
                            col--;
                            tracker2[row][col] = letters.charAt(f);
                        }
                    }
                    else
                    {
                        for(int d = 1; d <= length; d++)
                        {
                            col++;
                            tracker2[row][col] = letters.charAt(f);
                        }
                    }
                }
                else
                {
                    if(row + length > max || tracker2[row + 1][col] == 'd' || tracker2[row + 1][col] == 's' || tracker2[row + 1][col] == 'c' || tracker2[row + 1][col] == 'b' || tracker2[row + 1][col] == 'r' || tracker2[row + 2][col] == 'd' || tracker2[row + 2][col] == 's' || tracker2[row + 2][col] == 'c' || tracker2[row + 2][col] == 'b' || tracker2[row + 2][col] == 'r')
                    {
                        for(int u = 1; u <= length; u++)
                        {
                            row--;
                            tracker2[row][col] = letters.charAt(f);
                        }
                    }
                    else
                    {
                        for(int d = 1; d <= length; d++)
                        {
                            row++;
                            tracker2[row][col] = letters.charAt(f);
                        }
                    }
                }
            }
        }
        else if(player == 1)
        {
            max = 9;
            for(int r = 0; r < letters.length() - 1; r++)
            {
                do
                {
                    up = random.nextBoolean();
                    row = (int)(Math.random() * 10); // chooses a random number between 0 - 9
                    col = (int)(Math.random() * 10);
                    /*for(int l = 0; l < 6; l++) // if the point is surrounded
                    {
                        if(tracker1[row + 1][col] == letters.charAt(r) && up)
                        {
                            v++;
                        }
                        if(tracker1[row - 1][col] == letters.charAt(r) && up)
                        {
                            v++;
                        }
                        if(tracker1[row][col + 1] == letters.charAt(r) && !up)
                        {
                            c++;
                        }
                        if(tracker1[row][col - 1] == letters.charAt(r) && !up)
                        {
                            c++;
                        }
                    }*/
                }
                while(tracker1[row][col] == 'd' || tracker1[row][col] == 's' || tracker1[row][col] == 'c' || tracker1[row][col] == 'b' || tracker1[row][col] == 'r' || v == 2 || c == 2);
                
                tracker1[row][col] = letters.charAt(r);
                gameBoard1[row][col] = '@';
                
                length = numbers[r]; // goes thru the first 3 ships (2, 3, 3)
                
                
                if(up) // vertical
                {
                    if(col + length > max/* || tracker2[row][col + 1] == 'd' || tracker2[row][col + 1] == 's' || tracker2[row][col + 1] == 'c' || tracker2[row][col + 1] == 'b' || tracker2[row][col + 1] == 'r' || tracker2[row][col + 2] == 'd' || tracker2[row][col + 2] == 's' || tracker2[row][col + 2] == 'c' || tracker2[row][col + 2] == 'b' || tracker2[row][col + 2] == 'r'*/)
                    {
                        for(int u = 1; u <= length; u++)
                        {
                            col--;
                            tracker1[row][col] = letters.charAt(r);
                            gameBoard1[row][col] = '@';
                        }
                    }
                    else
                    {
                        for(int d = 1; d <= length; d++)
                        {
                            col++;
                            tracker1[row][col] = letters.charAt(r);
                            gameBoard1[row][col] = '@';
                        }
                    }
                }
                else
                {
                    if(row + length > max/* || tracker2[row + 1][col] == 'd' || tracker2[row + 1][col] == 's' || tracker2[row + 1][col] == 'c' || tracker2[row + 1][col] == 'b' || tracker2[row + 1][col] == 'r' || tracker2[row + 2][col] == 'd' || tracker2[row + 2][col] == 's' || tracker2[row + 2][col] == 'c' || tracker2[row + 2][col] == 'b' || tracker2[row + 2][col] == 'r'*/)
                    {
                        for(int u = 1; u <= length; u++)
                        {
                            row--;
                            tracker1[row][col] = letters.charAt(r);
                            gameBoard1[row][col] = '@';
                        }
                    }
                    else
                    {
                        for(int d = 1; d <= length; d++)
                        {
                            row++;
                            tracker1[row][col] = letters.charAt(r);
                            gameBoard1[row][col] = '@';
                        }
                        
                    }
                }
            }
        }
        else
        {
            max = 9;
            for(int r = 0; r < letters.length() - 1; r++)
            {
                do
                {
                    up = random.nextBoolean();
                    row = (int)(Math.random() * 10); // chooses a random number between 0 - 9
                    col = (int)(Math.random() * 10);
                    /*for(int l = 0; l < 6; l++) // if the point is surrounded
                    {
                        if(tracker2[row + 1][col] == letters.charAt(r) && up)
                        {
                            v++;
                        }
                        if(tracker2[row - 1][col] == letters.charAt(r) && up)
                        {
                            v++;
                        }
                        if(tracker2[row][col + 1] == letters.charAt(r) && !up)
                        {
                            c++;
                        }
                        if(tracker2[row][col - 1] == letters.charAt(r) && !up)
                        {
                            c++;
                        }
                    }*/
                }
                while(tracker2[row][col] == 'd' || tracker2[row][col] == 's' || tracker2[row][col] == 'c' || tracker2[row][col] == 'b' || tracker2[row][col] == 'r' || v == 2 || c == 2);
                
                tracker2[row][col] = letters.charAt(r);
                gameBoard2[row][col] = '@';
                
                length = numbers[r]; // goes thru the first 3 ships (2, 3, 3)
                
                
                if(up) // vertical
                {
                    if(col + length > max/* || tracker2[row][col + 1] == 'd' || tracker2[row][col + 1] == 's' || tracker2[row][col + 1] == 'c' || tracker2[row][col + 1] == 'b' || tracker2[row][col + 1] == 'r' || tracker2[row][col + 2] == 'd' || tracker2[row][col + 2] == 's' || tracker2[row][col + 2] == 'c' || tracker2[row][col + 2] == 'b' || tracker2[row][col + 2] == 'r'*/)
                    {
                        for(int u = 1; u <= length; u++)
                        {
                            col--;
                            tracker2[row][col] = letters.charAt(r);
                            gameBoard2[row][col] = '@';
                        }
                    }
                    else
                    {
                        for(int d = 1; d <= length; d++)
                        {
                            col++;
                            tracker2[row][col] = letters.charAt(r);
                            gameBoard2[row][col] = '@';
                        }
                    }
                }
                else
                {
                    if(row + length > max/* || tracker2[row + 1][col] == 'd' || tracker2[row + 1][col] == 's' || tracker2[row + 1][col] == 'c' || tracker2[row + 1][col] == 'b' || tracker2[row + 1][col] == 'r' || tracker2[row + 2][col] == 'd' || tracker2[row + 2][col] == 's' || tracker2[row + 2][col] == 'c' || tracker2[row + 2][col] == 'b' || tracker2[row + 2][col] == 'r'*/)
                    {
                        for(int u = 1; u <= length; u++)
                        {
                            row--;
                            tracker2[row][col] = letters.charAt(r);
                            gameBoard2[row][col] = '@';
                        }
                    }
                    else
                    {
                        for(int d = 1; d <= length; d++)
                        {
                            row++;
                            tracker2[row][col] = letters.charAt(r);
                            gameBoard2[row][col] = '@';
                        }
                    }
                }
            }
        }
    }

    // allows the user to guess the opponents ships
    public void guessPlayer(int player)
    {
        Scanner guess = new Scanner(System.in);
        System.out.print("\n\nPlease enter coordinates to guess where your opponents ships are located.\n\nRow: ");
        int gR = guess.nextInt();
        System.out.print("\n\nColumn: ");
        int gC = guess.nextInt();
        if(player == 1)
        {
            while(tracker2[gR][gC] == '!')
            {
                System.out.print("\nStop wasting missiles! Choose a coordinate you haven't already targeted.\n\nRow: ");
                gR = guess.nextInt();
                System.out.print("\nColumn: ");
                gC = guess.nextInt();
            }
            if(tracker2[gR][gC] == 'd' || tracker2[gR][gC] == 's' || tracker2[gR][gC] == 'c' || tracker2[gR][gC] == 'b' || tracker2[gR][gC] == 'r')
            {
                System.out.print("Hit!\n\n");
                guessBoard1[gR][gC] = 'X'; // the p2 board that p1 sees gets X
                hits1++;
                if(tracker2[gR][gC] == 'd')
                {
                    destroyer++;
                    hits1++;
                }
                else if(tracker2[gR][gC] == 's')
                {
                    submarine++;
                    hits1++;
                }
                else if(tracker2[gR][gC] == 'c')
                {
                    crusier++;
                    hits1++;
                }
                else if(tracker2[gR][gC] == 'b')
                {
                    battleship++;
                    hits1++;
                }
                else if(tracker2[gR][gC] == 'r')
                {
                    carrier++;
                    hits1++;
                }
            }
            else
            {
                System.out.print("Miss!\n\n");
                guessBoard1[gR][gC] = 'O';
            }
            tracker2[gR][gC] = '!';
        }
        else
        {
            while(tracker1[gR][gC] == '!')
            {
                System.out.print("\nStop wasting missiles! Choose a coordinate you haven't already targeted.\n\nRow: ");
                gR = guess.nextInt();
                System.out.print("\nColumn: ");
                gC = guess.nextInt();
            }
            if(tracker1[gR][gC] == 'd' || tracker1[gR][gC] == 's' || tracker1[gR][gC] == 'c' || tracker1[gR][gC] == 'b' || tracker1[gR][gC] == 'r')
            {
                System.out.print("Hit!\n\n");
                guessBoard1[gR][gC] = 'X';
                hits1++;
                if(tracker1[gR][gC] == 'd')
                {
                    destroyer2++;
                    hits2++;
                }
                else if(tracker1[gR][gC] == 's')
                {
                    submarine2++;
                    hits2++;
                }
                else if(tracker1[gR][gC] == 'c')
                {
                    crusier2++;
                    hits2++;
                }
                else if(tracker1[gR][gC] == 'b')
                {
                    battleship2++;
                    hits2++;
                }
                else if(tracker1[gR][gC] == 'r')
                {
                    carrier2++;
                    hits2++;
                }
            }
            else
            {
                System.out.print("Miss!\n\n");
                guessBoard1[gR][gC] = 'O';
            }
            tracker1[gR][gC] = '!';
        }    
        win();    
    }    
    
    // continuation of start in game.java, plays the different versions of the game until someone wins
    public void play(boolean m) 
        if(m)
        {
            do
            {
                System.out.print("\n\n Player's turn:\n\n");
                guessPlayer(1); // player 1 guesses on p2's board
                System.out.print("\n\nComputer's Board:\n\n");
                printBoard(false, 8, 8, 1, true);
            }
            while(hits1 < 17);
        }
        else
        {
            do
            {
                System.out.print("\n\n Player 1's turn:\n\n");
                guessPlayer(1); // player 1 guesses on p2's board
                System.out.print("\n\nPlayer 1's Board:\n\n");
                printBoard(false, 10, 10, 1, false);
                System.out.print("\n\nPlayer 2's Board:\n\n");
                printBoard(false, 10, 10, 2, true);
                //weird error here but commenting nothing fixes it?
                System.out.print("\033[2J");

                System.out.print("\n\n Player 2's turn:\n\n");
                guessPlayer(2); // player 2 guesses on p1's board
                System.out.print("\n\nPlayer 1's Board:\n\n");
                printBoard(false, 10, 10, 1, true);
                System.out.print("\n\nPlayer 2's Board:\n\n");
                printBoard(false, 10, 10, 2, false);
                System.out.print("\033[2J");
            }
            while(hits1 < 17 && hits2 < 17);
        }
    }

    // tells the user if they sink a ship or if game ends
    public void win() 
    {
        if(destroyer == 2 || destroyer2 == 2)
        {
            System.out.print("You sank the destroyer!");
            destroyer = 0;
        }
        if(submarine == 3 || submarine2 == 3)
        {
            System.out.print("You sank the submarine!");
            submarine = 0;
        }
        if(crusier == 3 || crusier2 == 3)
        {
            System.out.print("You sank the crusier!");
            crusier = 0;
        }
        if(battleship == 4 || battleship2 == 4)
        {
            System.out.print("You sank the battleship!");
            battleship = 0;
        }
        if(carrier == 3 || carrier2 == 3)
        {
            System.out.print("You sank the carrier!");
            carrier = 0;
        }
        if(hits1 == 17)
        {
            hits1 = 0;
            System.out.println("Player 1 wins!");
            return;
        }
        if (hits2 == 17)
        {
            hits2 = 0;
            System.out.println("Player 2 wins!");
            return;
        }
    }
}
