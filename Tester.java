import java.util.Scanner;

public class Tester 
{
    public static void main(String[] args) 
    {
        Scanner start = new Scanner(System.in);
        System.out.println("1 - Single Player\n2 - Double Player");
        int players = start.nextInt();
        Board player1 = new Board();
        Board player2 = new Board();
        Board comp = new Board();
        System.out.println("\n\nPlayer's Board:\n");
        player1.printBoard(true);
        System.out.println("\n\nComputer's Board:\n");
        comp.printBoard(true);
        player1.setBoardManual();
        player1.printBoard(false);
        if(players == 1)
        {
            System.out.println("\n\nPlayer's Board:\n");
            player1.printBoard(true);
            System.out.println("\n\nComputer's Board:\n");
            comp.printBoard(true);
        }
        
        
        
    }
}
