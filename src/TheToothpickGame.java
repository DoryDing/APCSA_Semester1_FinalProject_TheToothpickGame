import java.util.Scanner;
/**
 * The Toothpick Game is the the most amazing game EVER!
 * The toothpick game is a simple two-player game. The players decide whether they will be able to take 3, 4, 5, or 6 toothpicks per turn (or the computer will randomly determine before each game).
 * The players decide whether they will play one game, best of out 3, best out of 5, or best out of 7.
 * A coin is flipped to see who gets to go first.  A random pile of toothpicks, between 20 and 39 toothpicks, is placed in-between the two players.
 * The players alternate turns choosing toothpicks, and the winner is the one who takes the last toothpick.
 * If the series is not over, e.g. someone hasn’t won a best-out-of-5 match, then a new game is generated, and we play again.
 * Have fun!
 * @Yuanyuan Ding
 */
public class TheToothpickGame
{
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static boolean computerOpponent; //whether play with a computer opponent
    public static int maxToothpicksPerTurn; //maximum number of toothpicks that each player can take per turn
    public static int toothpicksRemaining;
    public static int currentPlayer; //either player 1 or 2
    public static int compSkillLevel; //easy, medium, or hard
    public static int winsNeeded;
    public static int player1Wins; //count how many times that player1 won
    public static int player2Wins; //count how many times that player2 won
    public static String player1Name;
    public static String player2Name;
    public static boolean randomMaxToothpicksPerTurn; //whether computer will randomly decide the value of maxToothpicksPerTurn in the beginning of every game
    public static String winner;
    public static void main(String[] args)
    {
        displayWelcomeBanner(); //Display welcome banner
        getStartingInformation(); //Get the starting information (number of players, number of games, etc.)

        while (player1Wins != winsNeeded && player2Wins != winsNeeded){ //play a game while someone has not won the series of games
            playOneGame();
        }
        if(player1Wins == winsNeeded){
            winner = player1Name;
        }else{
            winner = player2Name;
        }

        displayFinalStats(); //Congratulate the overall winner and display series stats.
    }

    /**
     * The displayWelcomeBanner method should be your take on a welcome message.
     *
     * Be creative.
     */
    private static void displayWelcomeBanner(){
        System.out.println("***************************************************************");
        System.out.println("******Welcome to the Toothpick Game created by Dory Ding!******");
        System.out.println("***************************************************************");
        System.out.println("\n\n");
    }

    /**
     * The getStartingInformation method, um, gets the starting information.
     *
     * In the course of running, setGameParameters uses three helper
     * methods -- choosePlayers(), getWinsNeeded(), and choooseMaxToothpicksPerTurn()
     */
    private static void getStartingInformation()
    {
        choosePlayers(); //play with a computer or not

        System.out.println();

        winsNeeded = getWinsNeeded(); //best out of what

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
    private static void choosePlayers(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Hello Player 1! Please enter your name to start the game: ");
        player1Name = userInput.nextLine();
        System.out.print("Thank you " + player1Name + ". Are you going to play with the computer? ");
        String playerDecision = userInput.nextLine();
        while((!playerDecision.equalsIgnoreCase("yes")) && (!playerDecision.equalsIgnoreCase("no"))){
            System.out.print("Sorry, the choice you entered is invalid. Please enter whether yes or no: ");
            playerDecision = userInput.nextLine();
        }
        if(playerDecision.equalsIgnoreCase("yes")){
            computerOpponent = true;
            System.out.println("************************ ");
            System.out.println("* Computer Skill Level * ");
            System.out.println("************************ ");
            System.out.println("* 1) Ann Smith         * ");
            System.out.println("* 2) IBM Watson        * ");
            System.out.println("* 3) Harvard            * ");
            System.out.println("************************ ");
            System.out.print("It seems like you chose to play with me! From 1 to 3, please choose the computer that you want to play with: ");
            int difficultyLevel = userInput.nextInt();
            while(difficultyLevel <= 0 || difficultyLevel > 3){
                System.out.print(player1Name + ", that was not one of the options!  Pick 1, 2, or 3. ");
                difficultyLevel = userInput.nextInt();
            }
            if(difficultyLevel == 1){
                compSkillLevel = EASY;
                player2Name = "EasyComputer";
            }
            if(difficultyLevel == 2){
                compSkillLevel = MEDIUM;
                player2Name = "MediumComputer";
            }
            if(difficultyLevel == 3){
                compSkillLevel = HARD;
                player2Name = "HardComputer";
            }
        }else{
            computerOpponent = false;
            System.out.print("Okay, it seems like you are going to play with a friend! Please enter player 2's name here: ");
            player2Name = userInput.nextLine();
        }
        System.out.println();
    }

    /**
     * The getWinsNeeded method asks player 1 how many games they are playing
     * in their series, and returns how many wins are needed for one player
     * to win the series.
     *
     * @return an integer representing the number of wins needed in order for
     *         one player to win the whole series
     */
    private static int getWinsNeeded(){
        Scanner userInput = new Scanner(System.in);
        System.out.print(player1Name + ", how mant series do you want to play? Choose whether 1, 3, 5, or 7: ");
        int numGames = userInput.nextInt();
        while(numGames != 1 && numGames != 3 && numGames != 5 && numGames != 7){
            System.out.print("The number of games you entered is invalid. Please enter either 1, 3, 5, or 7 to indicate how many games you want to play: ");
            numGames = userInput.nextInt();
        }
        System.out.println();
        return numGames/2 + 1; //2 out of 3, 3 out of 5, and etc.
    }

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
    private static void chooseMaxToothpicksPerTurn(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Do you want me to randomly determine the maximum number of toothpicks that you can take per turn: ");
        String playerDecision = userInput.nextLine();
        while(!playerDecision.equalsIgnoreCase("yes") && !playerDecision.equalsIgnoreCase("no")){
            System.out.print("Sorry, the choice you entered is invalid. Please enter whether yes or no: ");
            playerDecision = userInput.nextLine();
        }
        if(playerDecision.equalsIgnoreCase("yes")){
            randomMaxToothpicksPerTurn = true;
        }else{
            randomMaxToothpicksPerTurn = false;
            System.out.print("Please set up the maximum number of toothpicks that each player can take per turn (either 3, 4, 5, or 6): ");
            maxToothpicksPerTurn = userInput.nextInt();
            while(maxToothpicksPerTurn != 3 && maxToothpicksPerTurn != 4 && maxToothpicksPerTurn != 5 && maxToothpicksPerTurn != 6){
                System.out.print("Sorry, your input is invalid. Please choose either 3, 4, 5, or 6: ");
                maxToothpicksPerTurn = userInput.nextInt();
            }
        }
        System.out.println();
        System.out.println();
    }

    /**
     * The playOneGame method plays a single round of the Toothpick Game from
     * start to finish.
     */
    private static void playOneGame()
    {
        initializeGame();

        while (toothpicksRemaining > 0)
        {
            if (toothpicksRemaining == 1){
                System.out.println("\nThere is 1 toothpick remaining.");
            }
            else{
                System.out.println("\nThere are " + toothpicksRemaining + " toothpicks remaining.");
            }

            currentPlayerTakesTurn();


            if (toothpicksRemaining != 0){
                currentPlayer = (currentPlayer % 2) + 1; //switch current player
            }
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
    private static void initializeGame(){
        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println("So let's start playing!");
        if(randomMaxToothpicksPerTurn){
            maxToothpicksPerTurn = (int)(Math.random() * 4) + 3;
            System.out.println("Since you chose to randomly choose the maximum number of toothpicks that you can take per turn, this turn the maximum number is decided to be " + maxToothpicksPerTurn + " per turn.");
        }
        toothpicksRemaining = (int)(Math.random() * 20) + 20;
        System.out.println("This turn, there are " + toothpicksRemaining + " on the table.");
        currentPlayer = (int)(Math.random() * 2) + 1;
        if(computerOpponent && currentPlayer == 2){
            System.out.println("After flipping a coin, I am luckly be decided to go first.");
        }else{
            System.out.println("After flipping a coin, player " + currentPlayer + " is decided to go first.");
        }
    }

    /**
     * The congratulateWinner method will congratulate the winner!
     *
     * Postcondition:  After printing to the screen a relevant congratulations,
     *                 the appropriate player's win total has been incremented.
     */
    private static void congratulateWinner(){
        if(currentPlayer == 1){
            player1Wins++;
            System.out.println("Congradulations! " + player1Name + ", you have won this round!");
        }
        else{
            player2Wins++;
            System.out.println("Congradulations! " + player2Name + ", you have won this round!");
        }
        System.out.println("Until now, " + player1Name + " have won " + player1Wins + " rounds. " + player2Name + " have won " + player2Wins + " rounds.\n");
    }

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
    private static void player1TakesTurn(){
        Scanner userInput = new Scanner(System.in);
        System.out.print(player1Name + ", please enter the number of toothpicks you want to take this turn: ");
        int numToothpicks = userInput.nextInt();
        while(numToothpicks > toothpicksRemaining || numToothpicks > maxToothpicksPerTurn || numToothpicks <= 0){
            if(numToothpicks > toothpicksRemaining){
                System.out.print("**Error** number you entered will cause the number of toothpicks runs to a negative number.");
            }else if (numToothpicks > maxToothpicksPerTurn){
                System.out.print("**Error** The number you entered is larger than the maximum number of toothpicks that you can take per turn. Remember, you can only take less than " + maxToothpicksPerTurn + " toothpicks per turn.");
            }else{
                System.out.print("**Error** You cannot take negative number of toothpicks nor not taking any toothpicks.");
            }
            System.out.print("Please enter the number of toothpicks you want to take this turn again: ");
            numToothpicks = userInput.nextInt();
        }
        toothpicksRemaining -= numToothpicks;
    }

    /**
     * The player2TakesTurn method lets player 2, well, take a turn.
     *
     * Postcondition:  The pile of toothpicks does not go negative.
     */
    private static void player2TakesTurn(){
        Scanner userInput = new Scanner(System.in);
        System.out.println(player2Name + ", please enter the number of toothpicks you want to take this turn: ");
        int numToothpicks = userInput.nextInt();
        while(numToothpicks > toothpicksRemaining || numToothpicks > maxToothpicksPerTurn || numToothpicks <= 0){
            if(numToothpicks > toothpicksRemaining){
                System.out.print("**Error** number you entered will cause the number of toothpicks runs to a negative number.");
            }else if (numToothpicks > maxToothpicksPerTurn){
                System.out.print("**Error** The number you entered is larger than the maximum number of toothpicks that you can take per turn. Remember, you can only take less than " + maxToothpicksPerTurn + " toothpicks per turn.");
            }else{
                System.out.print("**Error** You cannot take negative number of toothpicks nor not taking any toothpicks.");
            }
            System.out.print("Please enter the number of toothpicks you want to take this turn again: ");
            numToothpicks = userInput.nextInt();
        }
        toothpicksRemaining -= numToothpicks;
    }

    /**
     * The getRandomChoice method will return a random number of toothpicks
     * between 1 and the max per turn.  It will also never pick a random
     * number which will make the pile go negative.
     *
     * @return an integer representing a randomly selected amount of toothpicks
     *         from 1 to the max per turn (inclusive).  The number returned must
     *         also NOT be greater than the number of toothpicks left in the pile.
     */
    private static int getRandomChoice(){
        int numToothpicks = (int)(Math.random() * maxToothpicksPerTurn ) + 1;
        while(numToothpicks > toothpicksRemaining){
            numToothpicks = (int)(Math.random() * maxToothpicksPerTurn ) + 1;
        }
        return numToothpicks;
    }

    /**
     * The getOptimalChoice method will return the number of toothpicks that
     * needs to be taken to force a win, if it exists.
     *
     * @return an integer representing the optimal number of toothpicks to take
     *         in order to force a win, if it exists;
     *         this will return -1 if it is impossible to force a win at this time
     */
    private static int getOptimalChoice(){
        int numToothpicks;
        if(toothpicksRemaining % (maxToothpicksPerTurn + 1) != 0){
            numToothpicks = toothpicksRemaining % (maxToothpicksPerTurn + 1);
        }else{
            numToothpicks = getRandomChoice();
        }
        return numToothpicks;
    }

    /**
     * The easyComputerTakesTurn method will always take a random number of
     * toothpicks and then output their choice to the screen after calling
     * getEasyTurnDescription.
     *
     * Reminder!  In the The Toothpick Game.pdf file, I told you this method
     * (and the next five methods after it!!) should not be using any global
     * variables.  Only local is needed due to the paramater lists.
     */

    private static void easyComputerTakesTurn(){
        int numToothpicks = getRandomChoice();
        toothpicksRemaining -= numToothpicks;
        System.out.println(getEasyTurnDescription(numToothpicks));
    }
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
    private static String getEasyTurnDescription(int num){
        int randomNum = (int)(Math.random() * 4);
        String output = "EasyComputer: ";
        if(randomNum == 0)
            output += "Hello, my name is Intelligence Artificial. I take " + num + " this turn! Heyhey, are you excited?";
        else if(randomNum == 1)
            output += "Today is a sunny day, isn't it? Ohoh! It's my turn? Well, I take " + num + " toothpicks.";
        else if(randomNum == 2)
            output += "Hey, what's your name? How old are you? Do you have a date? Tell me!!! Otherwise I will not tell you that I take " + num + " toothpicks this turn.";
        else
            output += "If I win this game, can I go to Harvard? I take " + num + " toothpicks this turn, I am so smart!!!";
        return output;
    }

    /**
     * The mediumComputerTakesTurn method will sometimes take a random amount
     * of toothpicks and sometimes take the optimal amount.  Once determined,
     * it will use getMediumTurnDescription in order to determine what to
     * print to the screen.
     */
    private static void mediumComputerTakesTurn(){
        int numToothpicks;
        if(toothpicksRemaining < 10){
            numToothpicks = getOptimalChoice();
        }else{
            numToothpicks = getRandomChoice();
        }
        toothpicksRemaining -= numToothpicks;
        System.out.println(getMediumTurnDescription(numToothpicks));
    }

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
    private static String getMediumTurnDescription(int num){
        String output = "Medium Computer: ";
        int randomNum = (int)(Math.random() * 4) + 1;
        if(randomNum == 1)
            output += "Heyyy bro, do you love my choice: " + num + " toothpicks?";
        else if(randomNum == 2)
            output += "Guess how many toothpics I took? I won't tell you that I took " + num + ".";
        else if(randomNum == 3)
            output += "Imagine taking " + num + " toothpicks~";
        else
            output += "I know I'm gonna win, because I took " + num + " toothpicks.";
        return output;
    }

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
    private static void hardComputerTakesTurn(){
        boolean isHappy;
        if(toothpicksRemaining % (maxToothpicksPerTurn + 1) != 0){
            isHappy = true;
        }else{
            isHappy = false;
        }
        int numToothpicks = getOptimalChoice();
        toothpicksRemaining -= numToothpicks;
        System.out.println(getHardTurnDescription(numToothpicks, isHappy));
    }

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
    private static String getHardTurnDescription(int num, boolean happy){
        String output = "HardComputer: ";
        int selection = (int)(Math.random() * 4) + 1;
        if(happy){
            if(selection == 1)
                output += "Bruh, do you even realized that I'm gonna win?? Oh come on, ready to cry because I take " + num + " toothpicks this turn.";
            else if(selection == 2)
                output += "Yayyy, taking " + num + " toothpicks, I am closer to win!";
            else if(selection == 3)
                output += "Imagine taking " + num + " toothpicks and ready to win.";
            else
                output += "If you call me sir, I can teach you how to be as smart as me. I, a smart computer, is going to take " + num + " toothpicks.";
        }else{
            if(selection == 1)
                output += "Don't laugh! I am taking " + num + " toothpicks this turn, so you might not win! I still have a chance.";
            else if(selection == 2)
                output += "Why you have to think for a long time and make a decision? You took too much time and made my mind messy! I take " + num + " toothpicks.";
            else if(selection == 3)
                output += "Bruh, are you kidding? Why you are so agressive to win? It's only a simple simple game! Fine, I take " + num + " toothpicks.";
            else
                output += "...... I take " + num + " toothpicks....... :(((((";
        }
        return output;
    }

    /**
     * The displayFinalStats method calls displayFinalStatsBanner and then
     * shows the results of the series of games and declare a winner.
     */
    private static void displayFinalStats(){
        displayFinalStatsBanner();
        if(currentPlayer == 1){
            System.out.println("Congradulations! " + player1Name + ", you have won this game!");
        }else{
            System.out.println("Congradulations! " + player2Name + ", you have won this game!");
        }
        System.out.println("In total, " + player1Name + " have won " + player1Wins + " games, and " + player2Name + " have won " + player2Wins + " games.");
    }

    /**
     * The displayFinalStatsBanner method displays a nice-looking banner to be used at the top
     * of the output for displayFinalStats.
     *
     * That's all.
     *
     * Be creative.
     */
    private static void displayFinalStatsBanner(){
        System.out.println("*******SLAYYYYYYYY*******");
        System.out.println("*******ALL DONEEEE*******");
    }

}
