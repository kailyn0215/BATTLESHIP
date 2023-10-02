public class Tester 
{
    public static void main(String[] args) {
        Board player = new Board();
        Board comp = new Board();
        System.out.println("Player's Board:");
        player.printBoard(true);
        System.out.println("Computer's Board:");
        comp.printBoard(true);
        player.setBoardPlayer();
        player.printBoard(false);
    }
}
