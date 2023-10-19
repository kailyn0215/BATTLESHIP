/**
 * Tester is the main class of battleship where we run the code
 * 
 * @author Kailyn Brown B)
 * 
 */
public class Tester 
{   

    /**
     * @param args (main method)     * 
     */
    public static void main(String[] args) 
    {
        Game y = new Game();
        y.text(); // introductory text to the game
        y.start(); //starts the game + prompts the user for game mode + lets them set up their board
        
    }
}
