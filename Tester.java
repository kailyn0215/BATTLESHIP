public class Tester 
{
    public static void main(String[] args) 
    {
        Board player = new Board();
        Board comp = new Board();
        System.out.println("\n\nPlayer's Board:\n");
        player.printBoard(true);
        System.out.println("\n\nComputer's Board:\n");
        comp.printBoard(true);
        player.setBoardManual();
        player.printBoard(false);
    }
}
