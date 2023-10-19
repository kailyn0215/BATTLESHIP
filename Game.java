import java.util.Scanner;

public class Game
{
    public Board player = new Board();
    
    //starts the game + prompts the user for game mode + lets them set up their board
    public void start() 
    {
        
        int mode;
        int create;
        int x; // changes length of rows + cols
        Scanner start = new Scanner(System.in);
        do
        {
            System.out.println("\n1 - Regular Mode\n2 - Fast Mode\n");
            mode = start.nextInt();
        }
        while(mode != 1 && mode != 2); // need to be able to take characters + ask again

        if(mode == 2) // fast mode
        {
            x = 8;
        }
        else // reg game
        {
            x = 10;
        }
    
        if(mode == 1) // if 2 player
        {
            System.out.println("\n\nPlayer 1's Board:\n");
            player.printBoard(true, x, x, 1, false);
            System.out.println("\n\nPlayer 2's Board:\n");
            player.printBoard(true, x, x, 2, false);
            do // ask p1 if they want to manually set up their board
            {
                System.out.println("\n\nPlayer 1:\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); // while out of bounds
            if(create == 2) // if auto
            {
                player.setBoardAuto(1, false); // p1 board gets set automatically
            }
            else if(create == 1) // if manual
            {
                player.setBoardManual(1); // p1 board gets set manually
            }
            System.out.print("\033[2J"); // clears the board for player 2s turn
            do // same thing for p2
            {
                System.out.println("\n\nPlayer 2:\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); 
            if(create == 2)
            {
                player.setBoardAuto(2, false); // p2 board gets set automatically
            }
            else if(create == 1)
            {
                player.setBoardManual(2); // p2 board gets set manually
            }
            System.out.print("\033[2J"); //clears board

            System.out.print("\n\n Player 1's turn:\n\n");
            player.guessPlayer(1); // player 1 guesses on p2's board
            System.out.print("\n\nPlayer 1's Board:\n\n");
            player.printBoard(false, 10, 10, 1, false);
            System.out.print("\n\nPlayer 2's Board:\n\n");
            player.printBoard(false, 10, 10, 2, true);
            //System.out.print("\033[2J");

            System.out.print("\n\n Player 2's turn:\n\n");
            player.guessPlayer(2); // player 2 guesses on p1's board
            System.out.print("\n\nPlayer 1's Board:\n\n");
            player.printBoard(false, 10, 10, 1, true);
            System.out.print("\n\nPlayer 2's Board:\n\n");
            player.printBoard(false, 10, 10, 2, false);
            System.out.print("\n\n");
            //System.out.print("\033[2J");

            player.play(false);
        }

        else if(mode == 2) // if fast mode
        {
            System.out.println("\n\nComputer's Board:\n");
            player.printBoard(true, x, x, 1, true);

            player.setBoardAuto(2, true);

            System.out.print("\n\n Player's turn:\n\n");
            player.guessPlayer(1); // player 1 guesses on p2's board
            System.out.print("\n\nComputer's Board:\n\n");
            player.printBoard(false, x, x, 1, true);

            player.play(true);
        }
        // need to keep working on fast mode especially, make it so the numbers of rows + cols match when making the board
    }

    public void text() // introductory text to the game
    {
        System.out.println("Welcome to battleship!!!\nIn the game of battleship your goal is to sink all of your opponents ships and keeping your own afloat.\n\nTo begin, you must set up your ships.\nYou can either set them up manually by entering the rows and columns of each point you would like a ship to be at or you can assign them randomly.\n\nAfter finishing assigning your ships, you will be able to start guessing where your opponents ships are located.\nIf you guess correctly, your opponents grid will have a X in their grid where you guessed correctly. If you guessed incorrectly, a O will appear on their grid instead. \nIf you sink one of your opponents ships, it will tell you by saying 'You sunk my ----!'\nYour goal is to sink all five of your oppenents ships.\n\nReady? Have fun!");
    }

    
}
