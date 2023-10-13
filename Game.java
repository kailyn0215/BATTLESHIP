import java.util.Scanner;

public class Game // creates the game boards + asks user what type of game they want to play
{
    public Board player1 = new Board();
    public Board comp = new Board();
    public Board player2 = new Board();
    public void start() //starts the game + prompts the user for game mode + lets them set up their board
    {
        
        int mode;
        int create;
        Scanner start = new Scanner(System.in);
        do
        {
            System.out.println("1 - Single Player\n2 - Double Player\n3 - Fast Mode");
            mode = start.nextInt();
        }
        while(mode > 3 || mode < 1);
        if(mode == 1) // single player
        {
            System.out.println("\n\nPlayer's Board:\n");
            player1.printBoard(true, 10, 10);
            System.out.println("\n\nComputer's Board:\n");
            comp.printBoard(true, 10, 10);
        }
        else if(mode == 2) // two player
        {
            System.out.println("\n\nPlayer 1's Board:\n");
            player1.printBoard(true, 10, 10);
            System.out.println("\n\nPlayer 2's Board:\n");
            player2.printBoard(true, 10, 10);
        }
        else if(mode == 3) // FAST mode (single player, 8-8 grid)
        {
            System.out.println("\n\nPlayer's Board:\n");
            player1.printBoard(true, 8, 8);
            System.out.println("\n\nComputer's Board:\n");
            player2.printBoard(true, 8, 8);
        }
        System.out.println("1 - Manual Board Creation\n2 - Auto Board Creation");
    
        if(mode == 2)
        {
            do
            {
                System.out.println("\nPlayer 1:\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); 
            if(create == 2)
            {
                player1.setBoardAuto();
            }
            else if(create == 1)
            {
                player1.setBoardManual();
            }
            do
            {
                System.out.println("\nPlayer 2:\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); 
            if(create == 2)
            {
                player2.setBoardAuto();
            }
            else if(create == 1)
            {
                player2.setBoardManual();
            }
        }
        else
        {
            do
            {
                System.out.println("\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); 
            if(create == 2)
            {
                player1.setBoardAuto();
            }
            else if(create == 1)
            {
                player1.setBoardManual();
            }
        }

    }

    public void text()
    {
        System.out.println("Welcome to battleship!!!\nIn the game of battleship your goal is to sink all of your opponents ships and keeping your own afloat.\n\nTo begin, you must set up your ships.\nYou can either set them up manually by entering the rows and columns of each point you would like a ship to be at or you can assign them randomly.\n\nAfter finishing assigning your ships, you will be able to start guessing where your opponents ships are located.\nIf you guess correctly, your opponents grid will have a X in their grid where you guessed correctly. If you guessed incorrectly, a O will appear on their grid instead. \nIf you sink one of your opponents ships, it will tell you by saying 'You sunk my ----!'\nYour goal is to sink all five of your oppenents ships.\n\nReady? Have fun!");
    }

    public void guessPlayer()
    {

    }    

    public void guessComp()
    {
        
    }
}
