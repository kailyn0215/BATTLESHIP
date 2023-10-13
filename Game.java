import java.util.Scanner;

public class Game
{
    public Board player1 = new Board();
    public Board comp = new Board();
    public Board player2 = new Board();

    public void start() //starts the game + prompts the user for game mode + lets them set up their board
    {
        
        int mode;
        int create;
        int x; // changes length of rows + cols
        Scanner start = new Scanner(System.in);
        do
        {
            System.out.println("\n1 - Single Player\n2 - Double Player\n3 - Fast Mode\n");
            mode = start.nextInt();
        }
        while(mode > 3 || mode < 1);
        if(mode == 3) // fast mode
        {
            x = 8;
        }
        else // reg game
        {
            x = 10;
        }
        
    
        if(mode == 2) // if 2 player
        {
            System.out.println("\n\nPlayer 1's Board:\n");
            player1.printBoard(true, x, x);
            System.out.println("\n\nPlayer 2's Board:\n");
            comp.printBoard(true, x, x);
            do // ask p1 if they want to manually set up their board
            {
                System.out.println("\n\nPlayer 1:\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); // while out of bounds
            if(create == 2) // if auto
            {
                player1.setBoardAuto(); // p1 board gets set automatically
            }
            else if(create == 1) // if manual
            {
                player1.setBoardManual(); // p1 board gets set manually
            }
            do // same thing for p2
            {
                System.out.println("\n\nPlayer 2:\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); 
            if(create == 2)
            {
                player2.setBoardAuto(); // p2 board gets set automatically
            }
            else if(create == 1)
            {
                player2.setBoardManual(); // p2 board gets set manually
            }
        }

        else if(mode == 1 || mode == 3) // if single player
        {
            System.out.println("\n\nPlayer's Board:\n");
            player1.printBoard(true, x, x);
            System.out.println("\n\nComputer's Board:\n");
            comp.printBoard(true, x, x);
            do
            {
                System.out.println("\n\n1 - Manual Board Creation\n2 - Auto Board Creation");
                create = start.nextInt();
            }
            while(create > 2 || create < 1); 
            if(create == 2)
            {
                player1.setBoardAuto(); // p1 board gets set automatically
            }
            else if(create == 1)
            {
                player1.setBoardManual(); // p1 board gets set manually
            }
        }
        player1.play();
        player1.printBoard(false, 10, 10);
    }

    public void text() // introductory text to the game
    {
        System.out.println("Welcome to battleship!!!\nIn the game of battleship your goal is to sink all of your opponents ships and keeping your own afloat.\n\nTo begin, you must set up your ships.\nYou can either set them up manually by entering the rows and columns of each point you would like a ship to be at or you can assign them randomly.\n\nAfter finishing assigning your ships, you will be able to start guessing where your opponents ships are located.\nIf you guess correctly, your opponents grid will have a X in their grid where you guessed correctly. If you guessed incorrectly, a O will appear on their grid instead. \nIf you sink one of your opponents ships, it will tell you by saying 'You sunk my ----!'\nYour goal is to sink all five of your oppenents ships.\n\nReady? Have fun!");
    }

    
}
