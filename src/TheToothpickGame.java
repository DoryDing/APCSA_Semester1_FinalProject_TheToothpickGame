
/**
 * The Toothpick Game is the the most amazing game EVER!
 * 
 * @author Someone
 */
public class TheToothpickGameTemplate
{

    public static void main(String[] args)
    {
        displayWelcomeBanner();
        getStartingInformation();           

        while (player1Wins != winsNeeded && player2Wins != winsNeeded)
            playOneGame();

        displayFinalStats();
    }

    /**
     * The displayWelcomeBanner method should be your take on a welcome message.
     * 
     * Be creative.
     */

    
    /**
     * The getStartingInformation method, um, gets the starting information.
     * 
     * In the course of running, setGameParameters uses three helper
     * methods -- choosePlayers(), getWinsNeeded(), and choooseMaxToothpicksPerTurn()
     */
    private static void getStartingInformation()
    {
        choosePlayers();
        
        System.out.println();
        
        winsNeeded = getWinsNeeded();
        
        System.out.println();
        
        chooseMaxToothpicksPerTurn();
    }
    
    /**
     * The choosePlayers method gets player 1's name, determines whether the 
     * second player is human or computer.
     * 
     * If the second player is human, ask for their name and set that variable.
     * 
     * If the second player is a computer, have them choose a skill level to 
     * set that variable, and then set player 2's name variable to be the name
     * of that particular skill level for the computer.
     * 
     * Postcondition:  computerOpponent gets properly set;  
     * 
     *                 The player 1's name and player 2's name varaibles are set properly;  
     *                 
     *                 If playing against a computer then compSkillLevel is also
     *                 set properly.
     */

   
    /**
     * The getWinsNeeded method asks player 1 how many games they are playing
     * in their series, and returns how many wins are needed for one player
     * to win the series.
     * 
     * @return an integer representing the number of wins needed in order for
     *         one player to win the whole series
     */

    
    /**
     * The chooseMaxToothpicksPerTurn method asks player 1 how many toothpicks will be
     * the maximum number that they can choose per turn, or whether they
     * want the maximum randomly determined before the start of each game.
     * 
     * Postcondition:  A global boolean variable is set showing whether or not the max 
     *                 toothpicks per turn should be randomly determined before each
     *                 game.
     *                 
     *                 A global max toothpicks per turn variable is set with the 
     *                 correct maximum, but only if it is NOT being randomly determined
     *                 before each game.
     */

    
    /**
     * The playOneGame method plays a single round of the Toothpick Game from
     * start to finish.
     */
    private static void playOneGame()
    {
        initializeGame();           

        while (toothpicksRemaining > 0)
        {
            if (toothpicksRemaining == 1)
                System.out.println("\nThere is 1 toothpick remaining.");
            else
                System.out.println("\nThere are " + toothpicksRemaining + " toothpicks remaining.");        

            currentPlayerTakesTurn();

            if (toothpicksRemaining != 0)
                currentPlayer = (currentPlayer % 2) + 1; //switch current player
        }

        congratulateWinner();
    }
    
    /**
     * The initializeGame method will get a Toothpick Game ready to go.
     * 
     * A random number from 20 to 39 is generated for the number of toothpicks remaining.  
     * The result is printed to the screen.
     * 
     * A coin is flipped to see who will go first.  The result of the coin flip is 
     * output to the screen.
     * 
     * ***IF*** they have chosen to have a random amount of max toothpicks per turn, 
     * then that value needs to be generated and stored in the correct variable.
     * Only if that value was randomly generated will something be output to the screen.
     * 
     * Postcondition:  toothpicksRemaining, currentPlayer, and whatever you named the
     *                 variable holding the maximum number per turn are all properly set
     */
    
    
    /**
     * The congratulateWinner method will congratulate the winner!
     * 
     * Postcondition:  After printing to the screen a relevant congratulations,
     *                 the appropriate player's win total has been incremented.
     */
    
    
    /**
     * The current player takes turn method determines who is supposed to be going
     * right now, and calls the appropriate method to make that happen.
     */
    private static void currentPlayerTakesTurn()
    {
        if (currentPlayer == 1)
            player1TakesTurn();
        else if (computerOpponent == false)
            player2TakesTurn();
        else if (compSkillLevel == EASY)
            easyComputerTakesTurn();
        else if (compSkillLevel == MEDIUM)
            mediumComputerTakesTurn();
        else if (compSkillLevel == HARD)
            hardComputerTakesTurn();
        else
        {
            System.out.println("It should have been impossible to get here");
            System.out.println("Something is definitely wrong.");
        }
    }    
    
    /**
     * The player1TakesTurn method lets player 1, um, take a turn.
     * 
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    
    
    /**
     * The player2TakesTurn method lets player 2, well, take a turn.
     * 
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    
    
    /**
     * The getRandomChoice method will return a random number of toothpicks
     * between 1 and the max per turn.  It will also never pick a random
     * number which will make the pile go negative.
     * 
     * @return an integer representing a randomly selected amount of toothpicks 
     *         from 1 to the max per turn (inclusive).  The number returned must
     *         also NOT be greater than the number of toothpicks left in the pile.
     */
    
    
    /**
     * The getOptimalChoice method will return the number of toothpicks that
     * needs to be taken to force a win, if it exists.
     * 
     * @return an integer representing the optimal number of toothpicks to take
     *         in order to force a win, if it exists;
     *         this will return -1 if it is impossible to force a win at this time
     */
    
    
    /**
     * The easyComputerTakesTurn method will always take a random number of 
     * toothpicks and then output their choice to the screen after calling
     * getEasyTurnDescription.
     * 
     * Reminder!  In the The Toothpick Game.pdf file, I told you this method
     * (and the next five methods after it!!) should not be using any global
     * variables.  Only local is needed due to the paramater lists.
     */
    
    
    /**
     * getEasyTurnDescription will return a randomly selected String showing
     * what the Easy Computer decided to do this turn.  The method will be 
     * randomly choosing from at least four different possible Strings.
     * 
     * The String returned will reflect the easy computer's personality. 
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @return a String which describes what the easy computer does this turn
     */
    
    
    /**
     * The mediumComputerTakesTurn method will sometimes take a random amount
     * of toothpicks and sometimes take the optimal amount.  Once determined,
     * it will use getMediumTurnDescription in order to determine what to 
     * print to the screen.
     */
    
    
    /**
     * getMediumTurnDescription will return a randomly selected String showing
     * what the Medium Computer decided to do this turn.  The method will be 
     * randomly choosing from at least four different possible Strings.
     * 
     * The String returned will reflect the easy computer's personality. 
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @return a String which describes what the medium computer does this turn
     */
    
    
    /**
     * The hardComputerTakesTurn method will always try to do the optimal choice.
     * 
     * Sometimes there is no optimal choice, so it will resort to a random
     * amount instead.  
     * 
     * Once the method determines what its choice is, it will use 
     * getHardTurnDescription in order to determine what to print to the screen.
     * Unlike the Easy Computer and the Medium Computer, this computer player will
     * know whether it is playing optimally or not, so when it calls
     * getHardTurnDescription, it will also include a boolean variable 
     * relaying whether this turn he will be forcing a win or not.
     */
    
    
    /**
     * getHardTurnDescription will return a randomly selected String showing
     * what the Hard Computer decided to do this turn.
     * 
     * You are supposed to be giving each of your computer skill levels personality,
     * and that will continue here.
     * 
     * Unlike the Easy and Medium computers, however, we are building in a little 
     * extra here because the Hard computer knows whether or not it is forcing a
     * win.  
     * 
     * The computer will have four random Strings to choose from if he is happy, 
     * and four random Strings to choose from if happy is false.
     * 
     * You get to have creative license for what being happy means for your hard
     * computer.  Will it gloat?  Trash talk?  Be smug?  Brush you off like you
     * are a peon?  Be nice about it?  It is up to you.
     * 
     * Similarly, you can decide how frustrated, indifferent, angry, etc. you want
     * your Hard computer to be if he is having to choose randomly.
     * 
     * @param  num  an integer representing the number of toothpicks which
     *              is supposed to be taken this turn
     * @param  happy  a boolean representing whether the computer is happy with its
     *                selection this turn (it is forcing a win) or not (it had to 
     *                pick randomly).
     * @return a String which describes what the hard computer does this turn
     */
        
    /**
     * The displayFinalStats method calls displayFinalStatsBanner and then
     * shows the results of the series of games and declare a winner.
     */
    
    
    /**
     * The displayFinalStatsBanner method displays a nice-looking banner to be used at the top
     * of the output for displayFinalStats.
     * 
     * That's all.
     * 
     * Be creative.
     */


}
