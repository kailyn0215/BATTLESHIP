import java.util.Scanner;

public class Game 
{
    public Board player1 = new Board();
    public Board comp = new Board();
    public Board player2 = new Board();
    public void start() //starts the game + prompts the user for 
    {
        
        int mode;
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
    }

    public void text()
    {
        System.out.println("Welcome to battleship!!!\nIn the game of battleship your goal is to sink all of your opponents ships and keeping your own afloat.\n\nTo begin, you must set up your ships.\nYou can either set them up manually by entering the rows and collumns of each point you would like a ship to be at or you can assign them randomly.");
    }

    public void guessPlayer()
    {

    }    

    public void guessComp()
    {
        
    }
}
